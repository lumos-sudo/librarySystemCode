package com.library.pojo;

public class borrowBook {
    private Integer bno;
    private String bname;
    private String returning;
    private String bdate;
    private String ldate;

    public borrowBook(Integer bno, String bname, String returning, String bdate, String ldate) {
        this.bno = bno;
        this.bname = bname;
        this.returning = returning;
        this.bdate = bdate;
        this.ldate = ldate;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getReturning() {
        return returning;
    }

    public void setReturning(String returning) {
        this.returning = returning;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getLdate() {
        return ldate;
    }

    public void setLdate(String ldate) {
        this.ldate = ldate;
    }
}