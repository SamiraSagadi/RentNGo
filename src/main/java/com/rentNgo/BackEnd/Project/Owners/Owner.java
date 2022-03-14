package com.rentNgo.BackEnd.Project.Owners;

public class Owner {

    private Integer ownerId;
    private String fullName;
    private String email;

    public                                                       Owner(Integer ownerId, String fullName, String email) {
        this.ownerId = ownerId;
        this.fullName = fullName;
        this.email = email;
    }

    public Owner() {
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
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
        return "Owner{" +
                "ownerId=" + ownerId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
