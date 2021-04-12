package com.kma.clientserver.clientserver.model;

import javax.persistence.*;

@Entity
@Table(name = "table_enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_discipline")
    private Disciplines discipline;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @Column
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
        return "Enrollment{" +
                "id=" + id +
                ", discipline=" + discipline +
                ", student=" + student +
                ", grade=" + grade +
                '}';
    }
}
