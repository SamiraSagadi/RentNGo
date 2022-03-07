package com.rentNgo.BackEnd.Project.Owners;

import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

public class OwnerMapper implements RowMapper<Owner> {
    public Owner mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Owner owner = new Owner();
        owner.setOwnerId(resultSet.getInt("owner_id"));
        owner.setFullName(resultSet.getString("full_name"));
        owner.setEmail(resultSet.getString("email"));

        return owner;

    }
}
