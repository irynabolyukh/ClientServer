package com.kma.clientserver.clientserver.model;

public class Enrollment {

    private Integer id;

    private Disciplines discipline;

    private Student student;

    private Double grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Disciplines getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Disciplines discipline) {
        this.discipline = discipline;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"discipline\":" + discipline +
                ", \"student\":" + student +
                ", \"grade\":" + grade +
                '}';
    }
}
