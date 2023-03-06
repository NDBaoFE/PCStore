/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class Account {

    private int accountId;
    private String email;
    private String password;
    private String fullName;
    private String role;
    private String address;
    private String phoneNo;

    public Account() {
    }

    public Account(int accountId, String email, String password, String fullName, String role, String address, String phoneNo) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.address = address;
        this.phoneNo = phoneNo;
    }
    

    public Account(String email, String password, String fullName, String address, String phoneNo) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
}
