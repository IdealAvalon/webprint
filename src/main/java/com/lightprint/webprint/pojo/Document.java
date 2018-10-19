package com.lightprint.webprint.pojo;

public class Document {

    private int id;
    private String qqNumber;
    private int paperSize;
    private int color;
    private int twoSided;
    private int bind;
    private String comment;

    public Document() {
    }

    public Document(int id, String qqNumber, int paperSize, int color, int twoSided, int bind, String comment) {
        this.id = id;
        this.qqNumber = qqNumber;
        this.paperSize = paperSize;
        this.color = color;
        this.twoSided = twoSided;
        this.bind = bind;
        this.comment = comment;
    }

    public int getTwoSided() {
        return twoSided;
    }

    public void setTwoSided(int twoSided) {
        this.twoSided = twoSided;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public int getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(int paperSize) {
        this.paperSize = paperSize;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBind() {
        return bind;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
