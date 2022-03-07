package com.rentNgo.BackEnd.Project.Owners;

import java.util.List;

public interface OwnerDAO {
    int addNewOwner(Owner owner);

    int deleteOwnerById(Integer ownerId);

    int updateOwner(Integer ownerId, Owner updateOwner);

    Owner selectOwnerByEmail(String email);

    List<Owner> selectAllOwners();
}
