/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Customer;

/**
 *
 * @author Administrator
 */
public class CustomerFacade {
    
    public List<Customer> select() throws SQLException {
        List<Customer> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from customer");
        list = new ArrayList<>();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong toy
            Customer customer = new Customer();
            customer.setCustomerId(rs.getInt("customerId"));
            customer.setCustomerName(rs.getString("customerName"));
            customer.setAddress(rs.getString("address"));
            customer.setPhoneNo(rs.getString("phoneNo"));
            //Them toy vao list
            list.add(customer);
        }
        con.close();
        return list;
    }

    public void create(Customer customer) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("insert customer values (?,?,?,?)");
        //Thực thi lệnh
        stm.setInt(1, customer.getCustomerId());
        stm.setString(2, customer.getCustomerName());
        stm.setString(3, customer.getAddress());
        stm.setString(4, customer.getPhoneNo());
        int count = stm.executeUpdate();
        con.close();
        // neu xoa khong duoc thi gay ra ngoai le
    }

    public Customer read(int customerId) throws SQLException {
        Customer customer = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("select * from customer where customerId = ?");
        //Thực thi lệnh SELECT
        stm.setInt(1, customerId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong product
            customer = new Customer();
            customer.setCustomerId(rs.getInt("customerId"));
            customer.setCustomerName(rs.getString("customerName"));
            customer.setAddress(rs.getString("address"));
            customer.setPhoneNo(rs.getString("phoneNo"));
        }
        con.close();
        return customer;
    }

    public void delete(int customerId) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("delete from customer where customerId = ?");
        //Thực thi lệnh 
        stm.setInt(1, customerId);
        int count = stm.executeUpdate();
        con.close();
        // neu xoa khong duoc thi gay ra ngoai le
    }

    public void update(Customer customer) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("update customer set customerName = ?, address = ?, phoneNo = ? where customerId = ?");
        //Thực thi lệnh 
        stm.setString(1, customer.getCustomerName());
        stm.setString(2, customer.getAddress());
        stm.setString(3, customer.getPhoneNo());
        stm.setInt(4, customer.getCustomerId());
        int count = stm.executeUpdate();
        con.close();
        // neu xoa khong duoc thi gay ra ngoai le
    }
}
