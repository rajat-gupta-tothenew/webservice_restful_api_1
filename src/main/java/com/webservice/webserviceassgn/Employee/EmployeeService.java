package com.webservice.webserviceassgn.Employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

    private static List<Employee> employees=new ArrayList<>();
    static  int userid=0;
    static {
        employees.add(new Employee(++userid,22,"Ram"));
        employees.add(new Employee(++userid,23, "Shyam"));
    }

    public List<Employee> findAll(){
        return employees;
    }

    public Employee findById(int id){
        return employees.stream().filter(users -> users.getId().equals(id)).findFirst().orElse(null);
    }

    public Employee saveEmployee(Employee employee){
        employee.setId(++userid);
        employees.add(employee);
        return employee;
    }

    public void deleteEmployee(int id){
        employees.removeIf(employee-> employee.getId().equals(id));
    }

    public Employee updateEmployee(Employee emp){
        Optional<Employee> employee =   employees.stream().filter(e->e.getId() ==emp.getId() ).findFirst();
        if(employee.isPresent()){
            employee.get().setName(emp.getName());
            employee.get().setAge(emp.getAge());
            return employee.get();
        }else{
            return null;
        }
    }
}
