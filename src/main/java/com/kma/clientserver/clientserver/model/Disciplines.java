package com.kma.clientserver.clientserver.model;

public class Disciplines {

    private Integer id;

    private String dname;

    private Integer credits;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "{" +
                " \"id\":" + id +
                ", \"dname\":\"" + dname +
                "\", \"credits\":" + credits +
                '}';
    }
}
