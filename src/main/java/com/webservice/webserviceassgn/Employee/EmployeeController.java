package com.webservice.webserviceassgn.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Q1
    @RequestMapping(path = "/")
    public String welcome(){
        return "Welcome to spring boot";
    }

    //Q3
    @GetMapping(path = "/employees")
    public List<Employee> retriveEmployess(){
        return employeeService.findAll();
    }

    //Q4
    @GetMapping(path = "/employees/{id}")
    public Employee retriveEmployess(@PathVariable Integer id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new UserNotFoundException("id :"+id);
        }
        return employee;
    }

    //Q5
    @PostMapping(path = "/employees")
    public Employee addEmployess(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    //Q7
    @DeleteMapping(path = "/deleteemployees/{id}")
    public void deleteEmployess(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }

    //Q8
    @PutMapping(path = "/updateemployees")
    public void updateEmployess(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }


}
