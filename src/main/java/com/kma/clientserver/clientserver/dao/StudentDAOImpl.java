package com.kma.clientserver.clientserver.dao;

import com.kma.clientserver.clientserver.model.Disciplines;
import com.kma.clientserver.clientserver.model.Enrollment;
import com.kma.clientserver.clientserver.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class StudentDAOImpl extends JdbcDaoSupport implements StudentDAO {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public List<Student> get() {
        try{
            String sql = "SELECT * FROM table_student";
            List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

            List<Student> result = new ArrayList<Student>();
            for(Map<String, Object> row:rows){
                Student student = new Student();
                student.setId((Integer) row.get("id"));
                student.setFio((String)row.get("fio"));
                student.setCourse((Integer) row.get("course"));
                result.add(student);
            }

            return result;
        }
        catch (Exception e){
            System.out.println("Can't get list of students: \n" + e);
        }
        return null;
    }

    @Override
    public Student get(int id) {
        try{
            String sql = "SELECT * FROM table_student WHERE id = ?";
            return (Student) getJdbcTemplate().queryForObject(sql, new Object[]{id}, (rs, rwNumber) -> {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFio(rs.getString("fio"));
                student.setCourse(rs.getInt("course"));
                return student;
            });
        }
        catch (Exception e){
            System.out.println("Can't get student: \n" + e);
        }
        return null;
    }

    @Override
    public List<Enrollment> getEnrollmentsForStudent(int id) {
        try{
            String sql = "SELECT * FROM table_enrollment where id_student = ?";
            List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[]{id});
            AtomicInteger disciplineId = new AtomicInteger();
            Student student = get(id);
            List<Enrollment> result = new ArrayList<Enrollment>();
            for(Map<String, Object> row:rows){
                Enrollment enrollment = new Enrollment();
                enrollment.setId((Integer) row.get("id"));
                enrollment.setStudent(student);
                disciplineId.set((Integer) row.get("id_discipline"));
                enrollment.setDiscipline(getDiscipline(disciplineId.get()));
                enrollment.setGrade((Double) row.get("grade"));
                result.add(enrollment);
            }
            return result;
        }
        catch (Exception e){
            System.out.println("Can't get enrollments for this student: \n" + e);
        }
        return null;
    }

    public Disciplines getDiscipline(int id) {
        try{
            String sql = "SELECT * FROM table_disciplines WHERE id = ?";
            return (Disciplines) getJdbcTemplate().queryForObject(sql, new Object[]{id}, (rs, rwNumber) -> {
                Disciplines discipline = new Disciplines();
                discipline.setId(rs.getInt("id"));
                discipline.setDname(rs.getString("dname"));
                discipline.setCredits(rs.getInt("credits"));
                return discipline;
            });
        }
        catch (Exception e){
            System.out.println("Can't get this discipline: \n" + e);
        }
        return null;
    }
}
