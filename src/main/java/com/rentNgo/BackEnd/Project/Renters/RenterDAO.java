package com.rentNgo.BackEnd.Project.Renters;

import java.util.List;

public interface RenterDAO {
    int addNewRenter(Renter renter);

    int deleteRenterById(Integer renterId);

    int updateRenters(Integer renterId, Renter updateRenter);

    Renter selectRenterByEmail(String email);

    List<Renter> selectAllRenters();
}
