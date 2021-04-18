package com.kma.clientserver.clientserver.model;

public class Student {

    private Integer id;

    private String fio;

    private Integer course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"fio\":\"" + fio + '\"' +
                ", \"course\":" + course +
                '}';
    }
}
