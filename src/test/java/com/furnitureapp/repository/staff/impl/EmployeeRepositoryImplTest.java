package com.furnitureapp.repository.staff.impl;

import com.furnitureapp.entity.staff.Employee;
import com.furnitureapp.factory.staff.EmployeeFactory;
import com.furnitureapp.factory.staff.JobFactory;
import com.furnitureapp.repository.staff.EmployeeRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImplTest {

    private static EmployeeRepository repo = EmployeeRepositoryImpl.getEmployeeRepository();
    private static Employee employee = EmployeeFactory.createEmployee("Yaseen Johnston", "123 South Street",
            "yaseenj@abc.com", "0123456789",
            "9am - 3pm", 40000, "1234",
            JobFactory.createJob("Software Engineer", "Develops and maintains software infrastructure"));

    @Test
    public void a_create() {
        Employee created = repo.create(employee);
        assertEquals(created, employee);
    }

    @Test
    public void b_read() {
        Employee read = repo.read(employee.getEmployeeCode());
        assertEquals(employee.getEmployeeCode(), read.getEmployeeCode());
    }

    @Test
    public void c_update() {
        Employee updated = new Employee.EmployeeBuilder().copy(employee).setFullName("Isaac Isaacs").build();
        updated = repo.update(updated);
        assertNotEquals(updated, employee);
    }

    @Test
    public void d_delete() {
        repo.delete(employee.getEmployeeCode());
    }

    @Test
    public void e_list() {
        Set<Employee> employees = repo.list();
        assertEquals(0, employees.size());
    }
}