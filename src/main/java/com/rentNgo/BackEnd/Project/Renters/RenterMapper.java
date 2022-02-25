package com.rentNgo.BackEnd.Project.Renters;

import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

public class RenterMapper implements RowMapper<Renter> {
    public Renter mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Renter renter = new Renter();
        renter.setRenterId(resultSet.getInt("renter_id"));
        renter.setFullName(resultSet.getString("full_name"));
        renter.setEmail(resultSet.getString("email"));

        return renter;

    }
}
