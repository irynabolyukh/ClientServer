package com.kma.clientserver.clientserver.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "table_disciplines")
public class Disciplines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Integer dname;

    @Column
    private Integer credits;

//    @OneToMany(mappedBy = "table_disciplines")
//    private List<Enrollment> enrollments;

//    public List<Enrollment> getEnrollments() {
//        return enrollments;
//    }
//
//    public void setEnrollments(List<Enrollment> enrollments) {
//        this.enrollments = enrollments;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDname() {
        return dname;
    }

    public void setDname(Integer dname) {
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
        return "Disciplines{" +
                "id=" + id +
                ", dname=" + dname +
                ", credits=" + credits +
                '}';
    }
}
