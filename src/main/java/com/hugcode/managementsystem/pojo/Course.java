package com.hugcode.managementsystem.pojo;

public class Course {
    private String cid;
    private String cname;
    private Double ccredit;
    private String tname;
    private String tid;

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", ccredit=" + ccredit +
                ", tname='" + tname + '\'' +
                ", tid='" + tid + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Double getCcredit() {
        return ccredit;
    }

    public void setCcredit(Double ccredit) {
        this.ccredit = ccredit;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
