package com.example.yang.tabstest.model;

/**
 * @author yang xp
 * @version V1.0
 * @date 2017/10/15 14:16
 */

public class ChatItem {

    public ChatItem(int imageId, String contentTitle, String contentDetail) {
        this.imageId = imageId;
        this.contentTitle = contentTitle;
        this.contentDetail = contentDetail;
    }

    /**
     * 消息图片id
     */
    private int imageId;

    /**
     * 内容头
     */
    private String contentTitle;

    /**
     * 内容详情
     */
    private String contentDetail;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentDetail() {
        return contentDetail;
    }

    public void setContentDetail(String contentDetail) {
        this.contentDetail = contentDetail;
    }
}
