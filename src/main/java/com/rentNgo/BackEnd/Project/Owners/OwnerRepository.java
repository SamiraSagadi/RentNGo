package com.rentNgo.BackEnd.Project.Owners;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepository implements OwnerDAO {
    private JdbcTemplate jdbcTemplate;

    public OwnerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Owner selectOwnerByEmail(String email) {
        String sql = """
                SELECT owner_id, fullName, email FROM owners WHERE owners.email = ?;
                """;
        return jdbcTemplate.queryForObject(sql, new OwnerMapper(), email);
    }

    @Override
    public List<Owner> selectAllOwners() {
        String sql = """
                SELECT owner_id, full_name, email FROM owners
                """;
        List<Owner> owners = jdbcTemplate.query(sql, new OwnerMapper());
        return owners;
    }


    @Override
    public int addNewOwner(Owner owner) {
        String sql = """
                INSERT INTO owners (full_name, email)
                VALUES (?, ?)
                """;
        int rowsAffected = jdbcTemplate.update(sql, owner.getFullName(), owner.getEmail());
        return rowsAffected;
    }


    @Override
    public int deleteOwnerById(Integer ownerId) {
        String sql = "DELETE FROM owners WHERE owner_id=?";
        int rowsAffected = jdbcTemplate.update(sql, ownerId);
        return rowsAffected;
    }

    @Override
    public int updateOwner(Integer ownerId, Owner updateOwner) {
        String sql = """ 
                UPDATE owners 
                SET (full_name, email) = (?, ?)
                WHERE owner_id = ?              
                """;
        return jdbcTemplate.update(sql, updateOwner.getFullName(), updateOwner.getEmail(), ownerId);
    }
}
