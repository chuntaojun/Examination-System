package com.tensor.org.work.service.socket.impl;

import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.work.service.socket.ChannelIdPool;
import com.tensor.org.work.service.socket.NoticeChannelHandler;
import com.tensor.org.work.utils.StringsValue;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Stream;

import static com.tensor.org.work.service.socket.ChannelGroupTypeEnum.CHANNEL_GROUP_GLOBAL;
import static com.tensor.org.work.service.socket.ChannelGroupTypeEnum.CHANNEL_GROUP_STUDENT;
import static com.tensor.org.work.service.socket.ChannelGroupTypeEnum.CHANNEL_GROUP_TEACHER;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
public class NoticeChannelHandlerImpl extends SimpleChannelInboundHandler<TextWebSocketFrame>
        implements NoticeChannelHandler {

    /**
     * 仅仅通知学生用户
     */
    protected static ChannelGroup studentChannels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    /**
     * 仅仅通知教师用户
     */
    protected static ChannelGroup teacherChannels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    /**
     * 全局通知所有用户
     */
    protected static ChannelGroup globalChannels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 客户端首次接入时，需发送用户编号信息
     * 客户端发送的信息：{ChannelGroupType}-{user_uuid}
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        Channel channel = ctx.channel();
        String[] contexts = msg.text().split("-");
        int clientContextSplitNum = 2;
        if (contexts.length != clientContextSplitNum) {
            channel.writeAndFlush(new TextWebSocketFrame(StringsValue.CN.CLIENT_SEND_ERR_MSG));
        } else {
            channel.writeAndFlush(new TextWebSocketFrame("客户端id ：" + channel.id()));
            NoticeConsumerCenterImpl.addReceiver(contexts[1]);
            ChannelIdPool.add(contexts[1], channel.id());
            addToChannelGroup(contexts[0], channel);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("新接入编号为 [{}] 的客户端", ctx.channel().id());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端编号为 [{}] 已断开链接", ctx.channel().id());
        ChannelIdPool.remove(ctx.channel().id());
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("客户端编号为 [{}] 报错：[{}]", ctx.channel().id(), cause.getMessage());
        super.exceptionCaught(ctx, cause);
    }

    /**
     * @param noticePackage
     */
    @Override
    public void publishMsg(NoticePackage noticePackage, String receiver) {
        if (noticePackage.getGroupType() == CHANNEL_GROUP_STUDENT.getValue()) {
            send(receiver, studentChannels, noticePackage);
        } else if (noticePackage.getGroupType() == CHANNEL_GROUP_TEACHER.getValue()) {
            send(receiver, teacherChannels, noticePackage);
        } else if (noticePackage.getGroupType() == CHANNEL_GROUP_GLOBAL.getValue()) {
            send(receiver, globalChannels, noticePackage);
        }
    }

    /**
     * @param channelId
     * @param channels
     * @param noticePackage
     */
    private void send(String channelId, ChannelGroup channels, NoticePackage noticePackage) {
        TextWebSocketFrame frame = new TextWebSocketFrame(noticePackage.getMessage());
        final Channel[] channel = {null};
        ChannelIdPool.get(channelId).ifPresent(channelId2 -> {
            channel[0] = channels.find(channelId2);
            channel[0].writeAndFlush(frame).addListener(future ->
                    log.info("消息主题为 [{}] 通知已向客户端 [{}] 推送完成", noticePackage.getNoticeLabel(), channel[0].id()));
        });
    }

    /**
     * @param type
     * @param channel
     */
    private void addToChannelGroup(String type, Channel channel) {
        if (CHANNEL_GROUP_STUDENT.getType().equals(type)) {
            studentChannels.add(channel);
        } else if (CHANNEL_GROUP_TEACHER.getType().equals(type)) {
            teacherChannels.add(channel);
        } else if (CHANNEL_GROUP_GLOBAL.getType().equals(type)) {
            globalChannels.add(channel);
        }
    }

}
