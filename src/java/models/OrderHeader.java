/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class OrderHeader {

    private int orderHeaderId;
    private Date date;
    private String status;
    private int customerId;
    private int employeeId;

    public OrderHeader() {
    }

    public OrderHeader(int orderHeaderId, Date date, String status, int customerId, int employeeId) {
        this.orderHeaderId = orderHeaderId;
        this.date = date;
        this.status = status;
        this.customerId = customerId;
        this.employeeId = employeeId;
    }

    public int getOrderHeaderId() {
        return orderHeaderId;
    }

    public void setOrderHeaderId(int orderHeaderId) {
        this.orderHeaderId = orderHeaderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

}
