/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cf.servlet;

import cf.db.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nanasemaru
 */
@WebServlet(name="Registration", urlPatterns={"/registration"})
public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String sex = req.getParameter("sex");
        int tel = Integer.parseInt(req.getParameter("tel"));
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String birthday = req.getParameter("birthday");
        
        if (birthday.equals("")) {
            birthday = null;
        }
        
        out.println("<html><body>"+username+tel+email+address+birthday);

        UserDB db = new UserDB("jdbc:mysql://localhost:3306/ESD_Assignment", "root", "");
        if (db.checkEmail(email)) {
            out.print("success");
            if (db.addUserInfo(username, sex, birthday, tel, email, address)) {
                out.print("Added");
            } else {
                out.print("Not added");
            }
            
        } else {
            out.print("fail");
        }
        out.println("</body></html>");
    }
}
