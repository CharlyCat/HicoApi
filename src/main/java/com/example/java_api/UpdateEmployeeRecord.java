package com.example.java_api;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//UPDATE existing employee record in the employee table
@WebServlet("/updateemployeerecord")
public class UpdateEmployeeRecord extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set the MIME type for the response message
        response.setContentType("text/html");
        // Get an output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();
        //Construct JSON response object
        try {
            // Step 1: Allocate a database 'Connection' object
            // Sample code format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hico-demo-db?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root", "gandulf8");   // For MySQL
            // Step 2: Allocate a 'Statement' object in the Connection
            Statement stmt = conn.createStatement();
            // Step 3: Execute a SQL SELECT query
            String sqlStr = "UPDATE `hico-demo-db`.`employeelist` SET ";
            sqlStr += "firstName =" + "'" + request.getParameter("firstName") + "'" + ",";
            sqlStr += "lastName =" + "'" + request.getParameter("lastName") + "'" + ",";
            sqlStr += "salutation =" + "'" + request.getParameter("salutation") + "'" + ",";
            sqlStr += "profileColour =" + "'" + request.getParameter("profileColour") + "'" + ",";
            sqlStr += "gender =" + "'" + request.getParameter("gender") + "'" + ",";
            sqlStr += "grossSalary =" + request.getParameter("grossSalary") + " ";
            sqlStr += "WHERE employeeID =" + request.getParameter("employeeID");
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
            System.out.println("ERROR updating");
            out.println("ERROR"+ e.getMessage());
        }
        out.println("SUCCESS");
    }//end doGet
}//end class


/*
SAMPLE UPDATE SYNTAX:
UPDATE `hico-demo-db`.`employeelist` SET `firstName`='Jim' WHERE  `employeeID`='002';
 */