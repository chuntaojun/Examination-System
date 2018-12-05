package com.tensor.org.web.bean;

/**
 * @author liaochuntao
 */
public class FileChunk {

    public static String FILE_NAME_FIELD = "filename";
    public static String FILE_CHUNK_NUMBER_FIELD = "chunkNumber";

    private int totalSize;
    private int chunks;
    private int chunkNumber;
    private String filename;
    private String identifier;

    public FileChunk() {
    }

    public FileChunk(int totalSize, int chunks, int chunkNumber, String filename, String identifier) {
        this.totalSize = totalSize;
        this.chunks = chunks;
        this.chunkNumber = chunkNumber;
        this.filename = filename;
        this.identifier = identifier;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getChunks() {
        return chunks;
    }

    public void setChunks(int chunks) {
        this.chunks = chunks;
    }

    public int getChunkNumber() {
        return chunkNumber;
    }

    public void setChunkNumber(int chunkNumber) {
        this.chunkNumber = chunkNumber;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "FileChunk{" +
                "totalSize=" + totalSize +
                ", chunks=" + chunks +
                ", chunkNumber=" + chunkNumber +
                ", filename='" + filename + '\'' +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
