package com.example.healthyfit;

public class exItem {
    int exNum;
    String exName;
    String exImg;
    String exEx;
    String exPart;
    String exLevel;
    String exCal;
    String exUrl;
    int resourceId;


    public exItem(int resourceId, String exName) {
        this.exName = exName;
        this.resourceId = resourceId;
    }
    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    //운동 일련번호
    public int getNum() {
        return exNum;
    }

    public void setNum(int exNum) {
        this.exNum = exNum;
    }


    //운동 이름
    public String getName() {
        return exName;
    }

    public void setName(String exName) {
        this.exName = exName;
    }

    //운동 이미지
    public String getImg() {
        return exImg;
    }

    public void setImg(String exImg) {
        this.exImg = exImg;
    }

    //운동 설명
    public String getEx() {
        return exEx;
    }

    public void setEx(String exEx) {
        this.exEx = exEx;
    }

    //운동 파트(팔,다리 등)
    public String getPart() {
        return exPart;
    }

    public void setPart(String exPart) {
        this.exPart = exPart;
    }

    //운동 레벨(상,중,하)
    public String getLevel() {
        return exLevel;
    }

    public void setLevel(String exLevel) {
        this.exLevel = exLevel;
    }

    //운동 칼로리
    public String getCal() {
        return exCal;
    }

    public void setCal(String exCal) {
        this.exCal = exCal;
    }

    //운동 url
    public String getUrl() {
        return exUrl;
    }

    public void setUrl(String exUrl) {
        this.exUrl = exUrl;
    }



}