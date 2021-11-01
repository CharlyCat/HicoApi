package com.example.java_api;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/addnewemployee")
public class AddNewEmployee extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the MIME type for the response message
        response.setContentType("text/html");
        //Check that rset executed correctly & send response
        PrintWriter out = response.getWriter();
        try {
            // Step 1: Allocate a database 'Connection' object
            // Sample code format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hico-demo-db?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root", "gandulf8");   // For MySQL
            // Step 2: Allocate a 'Statement' object in the Connection
            Statement stmt = conn.createStatement();
            // Step 3: Execute a SQL SELECT query
            String sqlStr = "INSERT INTO `hico-demo-db`.`employeelist` (`employeeID`, `firstName`, `lastName`, `salutation`, `profileColour`, `gender`, `grossSalary`)";
            sqlStr += "VALUES(" + "'" + request.getParameter("employeeID") + "'" + ",";
            sqlStr += "'" + request.getParameter("firstName") + "'" + ",";
            sqlStr += "'" + request.getParameter("lastName") + "'" + ",";
            sqlStr += "'" + request.getParameter("salutation") + "'" + ",";
            sqlStr += "'" + request.getParameter("profileColour") + "'" + ",";
            sqlStr += "'" + request.getParameter("gender") + "'" + ",";
            sqlStr += request.getParameter("grossSalary") + ")";
            System.out.println(sqlStr);

            try {
                //Send the query to the server
                Integer rset = stmt.executeUpdate(sqlStr); //SQL result stored in rset
                out.println(rset);
            } catch (SQLException error) {
                System.out.println("ERROR " + error.getMessage());
                out.println("ERROR"+ error.getMessage());
            }
        } catch (Exception e) {
            System.out.println("ERROR adding new");
            out.println("ERROR"+ e.getMessage());
        }
        out.println("SUCCESS");
    }//end doGet
}//end class

/*
SQL Statement
INSERT INTO `hico-demo-db`.`employeelist` (`employeeID`, `firstName`, `lastName`, `salutation`, `profileColour`, `gender`, `grossSalary`)
VALUES ('003', 'Mary', 'Jane', 'Ms', 'Green', 'Female', '1250000');
 */
