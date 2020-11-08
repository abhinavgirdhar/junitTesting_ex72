package ca.sheridancollege.girdhaab.database;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.sheridancollege.girdhaab.beans.Student;
import ca.sheridancollege.girdhaab.databases.DatabaseAccess;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class TestDatabaseAccess {

	@Autowired
	private DatabaseAccess da;
	
	@Test
	public void boundary_whenInsertStudent_getStudentList() {
		Student student = new Student();
		student.setName("Abhi");
		student.setProgram("SDNE");
		da.insertStudent(student);
		Assert.assertTrue(da.getStudentList().size() == 6);
	}
	
	@Test
	public void pass_whenInsertStudent_getStudentList() {
		Student student = new Student();
		student.setName("Abhi");
		student.setProgram("SDNE");
		da.insertStudent(student);
		Assert.assertTrue(da.getStudentList().size() > 2);
	}

	@Test
	public void fail_whenInsertStudent_getStudentList() {
		Student student = new Student();
		student.setName("Abhi");
		student.setProgram("SDNE");
		da.insertStudent(student);
		Assert.assertFalse(da.getStudentList().size() > 8);
	}
	

}

