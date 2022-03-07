package com.rentNgo.BackEnd.Project.Owners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private OwnerDAO ownerDAO;

    @Autowired
    public void OwnerService(OwnerDAO ownerDAO) {
        this.ownerDAO = ownerDAO;
    }

    //Selecting all customers
    public List<Owner> getFullListOwner() {
        List<Owner> owners = ownerDAO.selectAllOwners();
        if (ownerDAO.selectAllOwners() == null) {
            throw new IllegalStateException("No Owner Information were found");
        }
        return owners;
    }

    private void checkOwnerInputIsNotNull(Owner owner) {
        if (owner.getFullName() == null) {
            throw new IllegalStateException("FullName cannot be null");
        }
        if (owner.getEmail() == null) {
            throw new IllegalStateException("Email cannot be null");
        }
    }


    public int addOwner(Owner owner) {
        checkOwnerInputIsNotNull(owner);
        int rowsAffected = ownerDAO.addNewOwner(owner);
        if (rowsAffected <= 0) {
            System.out.println("cannot add a new owner");
        }
        return rowsAffected;
    }

    public int deleteOwnerById(Integer ownerId) {
        int rowsAffected = ownerDAO.deleteOwnerById(ownerId);
        if (rowsAffected <= 0) {
            System.out.println("cannot delete this owner with owner ID: " + ownerId);
        }
        return rowsAffected;
    }

    public void updateOwner(Integer ownerId, Owner updateOwner) {
        int result = ownerDAO.updateOwner(ownerId, updateOwner);
        if (result != 1) {
            throw new IllegalStateException("Couldn't update this owner!");
        }
    }
}
