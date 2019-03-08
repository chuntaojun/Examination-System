package com.tensor.org.web.handler.file;

import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.web.bean.FileChunk;
import com.tensor.org.web.utils.FileUploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.FormFieldPart;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

import static com.tensor.org.web.utils.FileUploadUtils.filePathCreate;
import static com.tensor.org.web.utils.ResponseAdaperUtils.render;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
public class FileHandlerImpl implements FileHandler {

    @Value(value = "${file.parent.tmp.path}") private String parentPath;

    @Override
    public Mono<ServerResponse> chunkCheck(ServerRequest request) {
        int chunkNumber = Integer.valueOf(request.queryParam(FileChunk.FILE_CHUNK_NUMBER_FIELD).orElse("-1"));
        String fileName = request.queryParam(FileChunk.FILE_NAME_FIELD).orElse("");
        boolean isExist = FileUploadUtils.judgeFileExist(filePathCreate(parentPath, fileName), chunkNumber + ".tmp");
        return render(isExist, isExist ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @Override
    public Mono<ServerResponse> chunkSave(ServerRequest request) {
        return request.multipartData().map(MultiValueMap::toSingleValueMap)
                .map(stringPartMap -> {
                    HashMap<String, String> param = new HashMap<>(stringPartMap.size());
                    AtomicReference<FilePart> filePart = new AtomicReference<>(null);
                    stringPartMap.values().stream().flatMap(part -> {
                        if (part.headers().getContentType() == null) {
                            FormFieldPart fieldPart = (FormFieldPart) part;
                            param.put(part.name(), fieldPart.value());
                        } else {
                            filePart.set((FilePart) part);
                        }
                        return Stream.empty();
                    }).count();
                    FileChunk fileChunk = (FileChunk) JsonUtils.toObj(JsonUtils.toJson(param), FileChunk.class);
                    return FileUploadUtils.saveFile(filePart.get(), filePathCreate(parentPath, fileChunk.getFilename()),
                                fileChunk.getChunkNumber() + ".tmp");
                }).flatMap(resultData -> render(resultData, resultData.getValue()));
    }

    @Override
    public Mono<ServerResponse> merge(ServerRequest request) {
        return request.bodyToMono(FileChunk.class)
                .map(fileChunk -> FileUploadUtils.fileMerge(parentPath, fileChunk.getIdentifier(),
                        fileChunk.getFilename(), fileChunk.getChunks()))
                .flatMap(s -> render(s, HttpStatus.OK));
    }
}
