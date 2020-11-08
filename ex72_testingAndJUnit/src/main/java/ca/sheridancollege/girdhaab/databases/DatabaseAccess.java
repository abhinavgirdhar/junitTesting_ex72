package ca.sheridancollege.girdhaab.databases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.girdhaab.beans.Student;

@Repository
public class DatabaseAccess {
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insertStudent() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO student(name, program) VALUES ('Abhi', 'Software Development and Network Engineering'), ('Simon', 'Software Development and Network Engineering')";
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted student into database");
	}
	
	public void insertStudent(Student student) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query= "INSERT INTO student(name, program) VALUES (:name, :program)";
		namedParameters.addValue("name", student.getName());
		namedParameters.addValue("program", student.getProgram());
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted student into database");
	}

	public List<Student> getStudentList() {MapSqlParameterSource namedParameters= new MapSqlParameterSource();
	String query = "SELECT * FROM student";
	return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Student>(Student.class));
	}
}
