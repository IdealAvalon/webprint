package com.lightprint.webprint.pojo;

import java.util.Date;

/**
 * @author: zhangdq
 * @Description:
 * @Date: Create in 16:18 2018/10/22
 * private int id;
private String qqNumber;
private int paperSize;
private int color;
private int twoSided;
private int bind;
private String dcomment;
private int finished;
private Date printDate;
 */
public class Photo {

    private int id;
    private String qqNumber;
    private int paperSize;
    private int color;
    private String dcomment;
    private int finished;
    private Date printDate;

    public Photo() {
    }

    public Photo(int id, String qqNumber, int paperSize, int color, String dcomment, int finished, Date printDate) {
        this.id = id;
        this.qqNumber = qqNumber;
        this.paperSize = paperSize;
        this.color = color;
        this.dcomment = dcomment;
        this.finished = finished;
        this.printDate = printDate;
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

    public String getDcomment() {
        return dcomment;
    }

    public void setDcomment(String dcomment) {
        this.dcomment = dcomment;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }
}
