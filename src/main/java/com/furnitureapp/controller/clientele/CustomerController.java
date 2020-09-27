package com.furnitureapp.controller.clientele;
/*
 * @author: @nkosinathisola
 * Description: Customer Controller
 */
import com.furnitureapp.entity.clientele.Customer;
import com.furnitureapp.service.clientele.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/list")
    public Set<Customer> list(){
        return customerService.list();
    }

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer){
        return customerService.create(customer);
    }

    @GetMapping("/read/{customerCode}")
    public Customer read(@PathVariable Integer customerCode){
        return customerService.read(customerCode);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer){
        return customerService.update(customer);
    }

    @DeleteMapping("/delete/{customerCode}")
    public boolean delete(@PathVariable Integer customerCode){
        return customerService.delete(customerCode);
    }

}
