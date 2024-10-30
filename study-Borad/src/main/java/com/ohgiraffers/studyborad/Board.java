package com.ohgiraffers.studyborad;


public class Board {

    private int uid;
    private String subject;
    private String contents;
    private String name;
    private String viewcnt;
    private String regdate;

    public Board() {
    }

    public Board(int uid, String subject, String contents, String name, String viewcnt, String regdate) {
        this.uid = uid;
        this.subject = subject;
        this.contents = contents;
        this.name = name;
        this.viewcnt = viewcnt;
        this.regdate = regdate;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getViewcnt() {
        return viewcnt;
    }

    public void setViewcnt(String viewcnt) {
        this.viewcnt = viewcnt;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "uid=" + uid +
                ", subject='" + subject + '\'' +
                ", contents='" + contents + '\'' +
                ", name='" + name + '\'' +
                ", viewcnt='" + viewcnt + '\'' +
                ", regdate='" + regdate + '\'' +
                '}';
    }
}
