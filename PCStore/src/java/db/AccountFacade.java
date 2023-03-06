package db;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Account;
import utils.Hasher;

/**
 * 
 * @author Admin
 */
public class AccountFacade {

    public List<Account> readEmail() throws SQLException {
        List<Account> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select email from account");
        list = new ArrayList<>();
        while (rs.next()) {
            //Doc mau tin hien hanh de vao doi tuong
            Account account = new Account();
            account.setEmail(rs.getString("email"));
            //Them toy vao list
            list.add(account);
        }
        con.close();
        return list;
    }

    public Account login(String email, String password) throws SQLException, NoSuchAlgorithmException {
        Account account = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select * from account where email=? and password=?");
        //Thực thi lệnh SELECT
        stm.setString(1, email);
        stm.setString(2, Hasher.hash(password));
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            account = new Account();
            account.setAccountId(rs.getInt("accountId"));
            account.setEmail(rs.getString("email"));
            account.setPassword(rs.getString("password"));
            account.setFullName(rs.getString("fullName"));
            account.setRole(rs.getString("role"));
        }
        con.close();
        return account;
    }

    public void register(Account account)
            throws SQLException, NoSuchAlgorithmException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("INSERT Account ([fullname], [password], [email], [role], [Address], [phoneNo]) VALUES (?, ?, ?, 'ROLE_CUSTOMER', ?, ?)");
        stm.setString(1, account.getFullName());
        stm.setString(2, Hasher.hash(account.getPassword()));
        stm.setString(3, account.getEmail());
        stm.setString(4, account.getAddress());
        stm.setString(5, account.getPhoneNo());
        int count = stm.executeUpdate();
        con.close();
    }
}
