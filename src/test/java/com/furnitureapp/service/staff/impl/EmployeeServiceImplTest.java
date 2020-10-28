package com.furnitureapp.service.staff.impl;

import com.furnitureapp.entity.staff.Employee;
import com.furnitureapp.factory.staff.EmployeeFactory;
import com.furnitureapp.service.staff.EmployeeService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Set;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceImplTest {

    @Autowired
    private static EmployeeService service;
    private static Employee employee = EmployeeFactory.createEmployee("Yaseen Johnston", "123 South Street",
            "yaseenj@abc.com", "0123456789",
            "9am - 3pm", 40000, "1234"
            );


    @Test
    public void list() {
        Set<Employee> employees = service.list();
        assertEquals(0, employees.size());
        System.out.println("All Employees: " + employees);
    }

    @Test
    public void a_create() {
        Employee created = service.create(employee);
        assertEquals(created, employee);
        System.out.println("Create: " + created);
    }

    @Test
    public void b_read() {
        Employee read = service.read(employee.getEmployeeCode());
        assertEquals(employee.getEmployeeCode(), read.getEmployeeCode());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Employee updated = new Employee.EmployeeBuilder().copy(employee).setFullName("Isaac Isaacs").build();
        updated = service.update(updated);
        assertNotEquals(updated, employee);
        System.out.println("Update: " + updated);
    }

    @Test
    public void d_delete() {
        boolean deleted = service.delete(employee.getEmployeeCode());
        assertTrue(deleted);
        System.out.println("Employee deleted: " + deleted);
    }
}
