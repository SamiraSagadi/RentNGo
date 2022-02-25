package com.rentNgo.BackEnd.Project.Renters;

import com.rentNgo.BackEnd.Project.Customers.Customer;
import com.rentNgo.BackEnd.Project.Customers.CustomerDAO;
import com.rentNgo.BackEnd.Project.Products.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterService {
    private RenterDAO renterDAO;

    @Autowired
    public void RenterService(RenterDAO renterDAO) {
        this.renterDAO = renterDAO;
    }

    //Selecting all customers
    public List<Renter> getFullListRenter() {
        List<Renter> renters = renterDAO.selectAllRenters();
        if (renterDAO.selectAllRenters() == null) {
            throw new IllegalStateException("No Renters were found");
        }
        return renters;
    }

    private void checkRenterInputIsNotNull(Renter renter) {
        if (renter.getFullName() == null) {
            throw new IllegalStateException("FullName cannot be null");
        }
        if (renter.getEmail() == null) {
            throw new IllegalStateException("Email cannot be null");
        }
    }


    public int addRenter(Renter renter) {
        checkRenterInputIsNotNull(renter);
        int rowsAffected = renterDAO.addNewRenter(renter);
        if (rowsAffected <= 0) {
            System.out.println("cannot add a new renter");
        }
        return rowsAffected;
    }

    public int deleteRenterById(Integer renterId) {
        int rowsAffected = renterDAO.deleteRenterById(renterId);
        if (rowsAffected <= 0) {
            System.out.println("cannot delete this renter with renter ID: " + renterId);
        }
        return rowsAffected;
    }

    public void updateRenter(Integer renterId, Renter updateRenter) {
        int result = renterDAO.updateRenters(renterId, updateRenter);
        if (result != 1) {
            throw new IllegalStateException("Couldn't update this renter!");
        }
    }
}
