package com.krishna;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.krishna.model.Employee;
import com.krishna.model.EmployeeList;

@Controller
public class ExmployeeController {

	@Autowired
	private EmployeeList employeeList;
	
	@GetMapping(path="employee",produces = {"application/xml"})
	@ResponseBody
	public List<Employee> allEmployeeList(){
		System.out.println("Display-----");
		List<Employee> lst = new ArrayList<Employee>();
		Map<String,Employee> employeeMap = employeeList.getEmployeeMap();
		System.out.println("employeeMap-----"+employeeMap);
		for (Map.Entry<String, Employee> item : employeeMap.entrySet()) {
			lst.add(item.getValue());
		}
		return lst;
	}
	@GetMapping("employee/{empNo}/{empName}")
	@ResponseBody
	public String addEmployee(@PathVariable("empNo")String empNo,@PathVariable("empName") String empName) {
		System.out.println("Mapping---------");
		System.out.println("empNo"+empNo);
		System.out.println("empName"+empName);
		Employee e1= new Employee();
		e1.setEmpName(empName);
		e1.setEmpNo(empNo);
		employeeList.getEmployeeMap().put(empNo, e1);
		return "Success";
	}
	
	
}
