package com.rentNgo.BackEnd.Project.Renters;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RenterJDBCTemplate implements RenterDAO{
    private JdbcTemplate jdbcTemplate;

    public RenterJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Renter selectRenterByEmail(String email) {
        String sql = """
                SELECT renter_id, fullName, email FROM renters WHERE renters.email = ?;
                """;
        return jdbcTemplate.queryForObject(sql, new RenterMapper(), email);
    }

    @Override
    public List<Renter> selectAllRenters() {
        String sql = """
                SELECT renter_id, full_name, email FROM Renters
                """;
        List<Renter> renters = jdbcTemplate.query(sql, new RenterMapper());
        return renters;
    }


    @Override
    public int addNewRenter(Renter renter) {
        String sql = """
                INSERT INTO renters (full_name, email)
                VALUES (?, ?)
                """;
        int rowsAffected = jdbcTemplate.update(sql, renter.getFullName(), renter.getEmail());
        return rowsAffected;
    }


    @Override
    public int deleteRenterById(Integer renterId) {
        String sql = "DELETE FROM renters WHERE renter_id=?";
        int rowsAffected = jdbcTemplate.update(sql, renterId);
        return rowsAffected;
    }

    @Override
    public int updateRenters(Integer renterId, Renter updateRenter) {
        String sql = """ 
                UPDATE renters 
                SET (full_name, email) = (?, ?)
                WHERE renter_id = ?              
                """;
        return jdbcTemplate.update(sql, updateRenter.getFullName(), updateRenter.getEmail(), renterId);
    }
}
