package com.tensor.org.api.dao.enpity.notice;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * @author liaochuntao
 */

public class NoticePackage implements Serializable {

    protected static final long serialVersionUID = -6075185081509822385L;
    protected String noticeId;
    protected String noticeLabel;
    protected String publisher;
    protected String orgId;
    protected List<String> receivers;
    protected int groupType;
    protected String message;
    protected long totalReceivers;
    private boolean finish;

    public NoticePackage() {
        noticeId = UUID.randomUUID().toString();
    }

    public NoticePackage(String noticeLabel, String publisher, String orgId, List<String> receivers, int groupType, String message, long totalReceivers, boolean finish) {
        this.noticeId = UUID.randomUUID().toString();
        this.noticeLabel = noticeLabel;
        this.publisher = publisher;
        this.orgId = orgId;
        this.receivers = receivers;
        this.groupType = groupType;
        this.message = message;
        this.totalReceivers = totalReceivers;
        this.finish = finish;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeLabel() {
        return noticeLabel;
    }

    public void setNoticeLabel(String noticeLabel) {
        this.noticeLabel = noticeLabel;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<String> receivers) {
        this.receivers = receivers;
    }

    public int getGroupType() {
        return groupType;
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTotalReceivers() {
        return totalReceivers;
    }

    public void setTotalReceivers(long totalReceivers) {
        this.totalReceivers = totalReceivers;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "NoticePackage{" +
                "noticeId='" + noticeId + '\'' +
                ", noticeLabel='" + noticeLabel + '\'' +
                ", publisher='" + publisher + '\'' +
                ", orgId='" + orgId + '\'' +
                ", receivers=" + receivers +
                ", groupType=" + groupType +
                ", message='" + message + '\'' +
                ", totalReceivers=" + totalReceivers +
                ", finish=" + finish +
                '}';
    }
}
