package com.rentNgo.BackEnd.Project.Owners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "owners")
@RestController
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(path = "/get-all-owners")
    public void listAllOwners() {
        System.out.println(ownerService.getFullListOwner());
    }

    @PostMapping(path = "/add-new-owner")
    void createNewCustomer(@RequestBody Owner owner) {
        System.out.println("POST REQUEST.....");
        ownerService.addOwner(owner);
        System.out.println(owner);
    }

    @PutMapping(path = "/edit/{ownerId}")
    public void updateOwner(@PathVariable("ownerId") Integer ownerId, @RequestBody Owner updateOwner) {
        System.out.println("UPDATE REQUEST.....");
        ownerService.updateOwner(ownerId, updateOwner);
    }

    @DeleteMapping(path = "/delete/{ownerId}")
    void deleteOwner(@PathVariable("ownerId") Integer ownerId) {
        System.out.println("DELETE REQUEST FOR OWNER WITH ID: " + ownerId);
        ownerService.deleteOwnerById(ownerId);
    }
}
