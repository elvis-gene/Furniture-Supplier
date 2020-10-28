package com.furnitureapp.controller.staff;


import com.furnitureapp.entity.staff.EmployeeJob;
import com.furnitureapp.factory.staff.EmployeeJobFactory;
import com.furnitureapp.service.staff.impl.EmployeeJobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/EmployeeJob")
public class EmployeeJobController {




        @Autowired
        private EmployeeJobServiceImpl employeeJobService;


        @GetMapping("/list")
        public Set<EmployeeJob> list(){
            return employeeJobService.list();
        }

        @PostMapping("/create")
        public EmployeeJob create(@RequestBody EmployeeJob employeeJob){
            EmployeeJob newEmployeeJob = EmployeeJobFactory.createEmployeeJob(employeeJob.getEmployeeCode(), employeeJob.getJobCode());
            return employeeJobService.create(newEmployeeJob);
        }

        @GetMapping("/read/{empCode}")
        public EmployeeJob read(@PathVariable Integer empCode){
            return employeeJobService.read(empCode);
        }

        @PostMapping("/update")
        public EmployeeJob update(@RequestBody EmployeeJob employeeJob){
            return employeeJobService.update(employeeJob);
        }

        @DeleteMapping("/delete/{empCode}")
        public boolean delete(@PathVariable Integer empCode){
            return employeeJobService.delete(empCode);
        }


}
