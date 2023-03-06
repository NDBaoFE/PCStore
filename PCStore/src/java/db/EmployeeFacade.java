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
import models.Employee;

/**
 *
 * @author Administrator
 */
public class EmployeeFacade {
    
    public List<Employee> select() throws SQLException {
        List<Employee> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from employee");
        list = new ArrayList<>();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong toy
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employeeId"));
            employee.setEmpName(rs.getString("empName"));
            employee.setSalary(rs.getDouble("salary"));
            //Them toy vao list
            list.add(employee);
        }
        con.close();
        return list;
    }

    public void create(Employee employee) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("insert employee values (?,?,?)");
        //Thực thi lệnh
        stm.setInt(1, employee.getEmployeeId());
        stm.setString(2, employee.getEmpName());
        stm.setDouble(3, employee.getSalary());
        int count = stm.executeUpdate();
        con.close();
        // neu xoa khong duoc thi gay ra ngoai le
    }

    public Employee read(int employeeId) throws SQLException {
        Employee employee = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("select * from employee where employeeId = ?");
        //Thực thi lệnh SELECT
        stm.setInt(1, employeeId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong product
            employee = new Employee();
            employee.setEmployeeId(rs.getInt("employeeId"));
            employee.setEmpName(rs.getString("empName"));
            employee.setSalary(rs.getDouble("salary"));
        }
        con.close();
        return employee;
    }

    public void delete(int employeeId) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("delete from product where customerId = ?");
        //Thực thi lệnh 
        stm.setInt(1,employeeId);
        int count = stm.executeUpdate();
        con.close();
        // neu xoa khong duoc thi gay ra ngoai le
    }

    public void update(Employee employee) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        PreparedStatement stm = con.prepareStatement("update customer set customerName = ?, address = ?, phoneNo = ? where customerId = ?");
        //Thực thi lệnh 
        stm.setInt(1, employee.getEmployeeId());
        stm.setString(2, employee.getEmpName());
        stm.setDouble(3, employee.getSalary());
        int count = stm.executeUpdate();
        con.close();
        // neu xoa khong duoc thi gay ra ngoai le
    } 
}
