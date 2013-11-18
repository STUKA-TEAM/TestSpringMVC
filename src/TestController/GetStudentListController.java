package TestController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GetStudentListController {
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String getList(Model model){
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("Bob","PEKING"));
		students.add(new Student("Jim", "SEU"));
		model.addAttribute("studentList", students);
		return "showStudentList";
	}
}
