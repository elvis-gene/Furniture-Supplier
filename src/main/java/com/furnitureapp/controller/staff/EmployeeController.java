package com.furnitureapp.controller.staff;

/*
 * @author: @yaseenjohnston
 * Description: Controller for Employee
 */

import com.furnitureapp.entity.staff.Employee;
import com.furnitureapp.factory.staff.EmployeeFactory;
import com.furnitureapp.service.staff.EmployeeService;
import com.furnitureapp.service.staff.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl employeeService;


    @GetMapping("/list")
    public Set<Employee> list(){
        return employeeService.list();
    }

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        Employee newEmployee = EmployeeFactory.createEmployee(employee.getFullName(), employee.getAddress(),
                employee.getEmailAddress(), employee.getPhone(), employee.getShift(), employee.getSalary(),
                employee.getPassCode());
        return employeeService.create(newEmployee);
    }

    @GetMapping("/read/{empCode}")
    public Employee read(@PathVariable Integer empCode){
        return employeeService.read(empCode);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{empCode}")
    public boolean delete(@PathVariable Integer empCode){
        return employeeService.delete(empCode);
    }



}
