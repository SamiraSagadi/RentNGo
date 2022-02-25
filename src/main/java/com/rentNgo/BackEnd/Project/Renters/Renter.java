package com.rentNgo.BackEnd.Project.Renters;

public class Renter {

    private Integer renterId;
    private String fullName;
    private String email;

    public Renter(Integer renterId, String fullName, String email) {
        this.renterId = renterId;
        this.fullName = fullName;
        this.email = email;
    }

    public Renter() {
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "renterId=" + renterId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
