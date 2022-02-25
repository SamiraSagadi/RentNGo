package com.rentNgo.BackEnd.Project.Renters;

import com.rentNgo.BackEnd.Project.Customers.Customer;
import com.rentNgo.BackEnd.Project.Customers.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "renters")
@RestController
public class RenterController {
    private final RenterService renterService;

    @Autowired
    public RenterController(RenterService renterService) {
        this.renterService = renterService;
    }

    @GetMapping(path = "/get-all-renters")
    public void listAllRenters() {
        System.out.println(renterService.getFullListRenter());
    }

    @PostMapping(path = "/add-new-renter")
    void createNewCustomer(@RequestBody Renter renter) {
        System.out.println("POST REQUEST.....");
        renterService.addRenter(renter);
        System.out.println(renter);
    }

    @PutMapping(path = "/edit/{renterId}")
    public void updateRenter(@PathVariable("renterId") Integer renterId, @RequestBody Renter updateRenter) {
        System.out.println("UPDATE REQUEST.....");
        renterService.updateRenter(renterId, updateRenter);
    }

    @DeleteMapping(path = "/delete/{renterId}")
    void deleteRenter(@PathVariable("renterId") Integer renterId) {
        System.out.println("DELETE REQUEST FOR RENTER WITH ID: " + renterId);
        renterService.deleteRenterById(renterId);
    }
}
