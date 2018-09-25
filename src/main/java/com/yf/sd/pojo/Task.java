package com.yf.sd.pojo;

import java.sql.Date;

public class Task {
    //关键词
    private String keyword;
    //主图链接
    private String imgUrl;
    //掌柜名称
    private String bossName;
    //价格
    private String price;
    //佣金
    private double brokerage;
    //任务数
    private double taskNum;
    //商品链接
    private String comUrl;
    //开始时间
    private Date startDate;
    //结束时间
    private Date endDate;
    //备注留言
    private String remark;
    //状态
    private int state;
    //接收人
    private String receive;
    //发布人
    private String master;

    public void setState(int state) {
        this.state = state;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public int getState() {
        return state;
    }

    public String getReceive() {
        return receive;
    }

    public String getMaster() {
        return master;
    }

    public Task(String keyword, String imgUrl, String bossName, String price, double brokerage, double taskNum, String comUrl, Date startDate, Date endDate, String remark, int state, String receive, String master) {
        this.keyword = keyword;
        this.imgUrl = imgUrl;
        this.bossName = bossName;
        this.price = price;
        this.brokerage = brokerage;
        this.taskNum = taskNum;
        this.comUrl = comUrl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.remark = remark;
        this.state = state;
        this.receive = receive;
        this.master = master;
    }

    @Override
    public String toString() {
        return "Task{" +
                "keyword='" + keyword + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", bossName='" + bossName + '\'' +
                ", price='" + price + '\'' +
                ", brokerage=" + brokerage +
                ", taskNum=" + taskNum +
                ", comUrl='" + comUrl + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", remark='" + remark + '\'' +
                '}';
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setBrokerage(double brokerage) {
        this.brokerage = brokerage;
    }

    public void setTaskNum(double taskNum) {
        this.taskNum = taskNum;
    }

    public void setComUrl(String comUrl) {
        this.comUrl = comUrl;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getBossName() {
        return bossName;
    }

    public String getPrice() {
        return price;
    }

    public double getBrokerage() {
        return brokerage;
    }

    public double getTaskNum() {
        return taskNum;
    }

    public String getComUrl() {
        return comUrl;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getRemark() {
        return remark;
    }

    public Task() {
    }

    public Task(String keyword, String imgUrl, String bossName, String price, double brokerage, double taskNum, String comUrl, Date startDate, Date endDate, String remark) {
        this.keyword = keyword;
        this.imgUrl = imgUrl;
        this.bossName = bossName;
        this.price = price;
        this.brokerage = brokerage;
        this.taskNum = taskNum;
        this.comUrl = comUrl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.remark = remark;
    }
}
