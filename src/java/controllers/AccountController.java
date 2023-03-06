/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Account;
import db.AccountFacade;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Config;

/**
 *
 * @author PHT
 */
@WebServlet(name = "AccountController", urlPatterns = {"/account"})
public class AccountController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "login":
                //Hien login form                
                request.getRequestDispatcher(Config.LOGIN).forward(request, response);
                break;
            case "login_handler":
                //Xu ly login form
                login_handler(request, response);
                break;
            //hien register form
            case "register":
                request.getRequestDispatcher(Config.REGISTER).forward(request, response);
                break;
            case "register_handler":
                register_handler(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            default:
            //Show error page
        }
    }

    protected void login_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "login":
                    //Lay thong tin login
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    //Kiem tra thong trong DB
                    AccountFacade af = new AccountFacade();
                    Account account = af.login(email, password);
                    if (email == "" || password == "") {
                        request.setAttribute("message", "Missing email or password.");
                        request.getRequestDispatcher(Config.LOGIN).forward(request, response);
                    } else {
                        if (account == null) {
                            //Neu login khong thanh cong thi quay ve login form 
                            //de nhap lai thong tin
                            request.setAttribute("message", "Incorrect email or password.");
                            request.getRequestDispatcher(Config.LOGIN).forward(request, response);
                        } else {
                            //Neu login thanh cong
                            //Luu account vao session
                            HttpSession session = request.getSession();
                            session.setAttribute("account", account);
                            //Quay ve Home Page
                            response.sendRedirect(request.getContextPath() + "/home/index.do");
                        }
                    }
                    //
                    break;
                case "cancel":
                    //Quay ve Home Page
                    response.sendRedirect(request.getContextPath() + "/home/index.do");
                    break;
            }
        } catch (Exception ex) {
            //Quay ve login form de thong bao loi
            request.setAttribute("message", ex.toString());
            request.getRequestDispatcher(Config.LOGIN).forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Xoa session
        HttpSession session = request.getSession();
        session.invalidate();
        //Quay ve trang chu
        response.sendRedirect(request.getContextPath() + "/home/index.do");
    }

    private void register_handler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            switch (op) {
                case "register":
                    //Lay thong tin register
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    String fullName = request.getParameter("fullName");
                    String address = request.getParameter("address");
                    String phoneNo = request.getParameter("phoneNo");
                    boolean cont = true;
                    //Kiem tra thong trong DB
                    Account account = new Account(email, password, fullName, address, phoneNo);
                    AccountFacade af = new AccountFacade();
                    List<Account> list = af.readEmail();
                    if (email == "" || password == "" || fullName == "" || address == "" || phoneNo == "") {
                        request.setAttribute("message", "Please fulfill the form");
                        request.getRequestDispatcher(Config.REGISTER).forward(request, response);
                    } else {
                        for (Account accountEmail : list) {
                            System.out.println(accountEmail.getEmail());
                            if (accountEmail.getEmail().equals(email)) {
                                request.setAttribute("message", "Email da dang ki");
                                cont = false;
                                request.getRequestDispatcher(Config.REGISTER).forward(request, response);
                            }
                        }

                    }
                    if (cont) {
                        af.register(account);
                        response.sendRedirect(request.getContextPath() + "/home/index.do");
                    }
                    break;

                case "cancel":
                    //Quay ve Home Page
                    response.sendRedirect(request.getContextPath() + "/home/index.do");
                    break;
                default:
            }
        } catch (Exception ex) {
            //Quay ve register form de thong bao loi
            request.setAttribute("message", ex.toString());
            request.getRequestDispatcher(Config.REGISTER).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
