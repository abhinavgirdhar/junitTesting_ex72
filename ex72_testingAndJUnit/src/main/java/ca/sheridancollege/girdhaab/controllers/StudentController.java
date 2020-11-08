package ca.sheridancollege.girdhaab.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.girdhaab.beans.Student;
import ca.sheridancollege.girdhaab.databases.DatabaseAccess;


@Controller
public class StudentController {
//	List<Student> studentList = new CopyOnWriteArrayList<Student>();
	
	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index(Model model) {
		//da.insertStudent(); //Without argument
		model.addAttribute("studentList", da.getStudentList());
		model.addAttribute("student", new Student());
		return "index";
	}
	
	@PostMapping("/insertStudent")
	public String insertStudent(Model model, @ModelAttribute Student student)
	{
		da.insertStudent(student); //With argument, the prepopulated student received from HTML through model
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudentList());
		
		return "index";
	}
}
