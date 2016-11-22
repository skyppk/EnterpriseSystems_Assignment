/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.servlet;

import cf.bean.ItemInfo;
import cf.db.ItemDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nanasemaru
 */
@WebServlet(urlPatterns = {"/product"})
public class HandleItem extends HttpServlet {
    private ItemDB db;
    
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser2");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword2");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl2");

        db = new ItemDB(dbUrl, dbUser, dbPassword);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String name = request.getParameter("name");
        if ("detail".equalsIgnoreCase(action)) {
            if (name!=null) {
                ItemInfo item = db.queryItemDetail(name);
                System.out.print("here");
                request.setAttribute("item", item);
                RequestDispatcher rd;
                rd = getServletContext().getRequestDispatcher("/showItemDetail.jsp");
                rd.forward(request, response);
            }
        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
        }
    }
}
