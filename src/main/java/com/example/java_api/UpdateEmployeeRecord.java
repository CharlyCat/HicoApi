package com.example.java_api;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

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
        try {/*
            // Step 1: Allocate a database 'Connection' object
            // Sample code format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hico-demo-db?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root", "gandulf8");   // For MySQL
            // Step 2: Allocate a 'Statement' object in the Connection
            Statement stmt = conn.createStatement();
            // Step 3: Execute a SQL SELECT query
            String sqlStr = "UPDATE INTO `hico-demo-db`.`employeelist` (`employeeID`, `firstName`, `lastName`, `salutation`, `profileColour`, `gender`, `grossSalary`)";
            sqlStr += "SET(" + "'" + request.getParameter("employeeID") + "'" + ",";
            sqlStr += "'" + request.getParameter("firstName") + "'" + ",";
            sqlStr += "'" + request.getParameter("lastName") + "'" + ",";
            sqlStr += "'" + request.getParameter("salutation") + "'" + ",";
            sqlStr += "'" + request.getParameter("profileColour") + "'" + ",";
            sqlStr += "'" + request.getParameter("gender") + "'" + ",";
            sqlStr += "'" + request.getParameter("grossSalary") + "'" + ")";
            System.out.println(sqlStr);*/
        } catch (Exception e) {
            System.out.println("ERROR updating");
        }
    }//end doGet
}//end class


/*
UPDATE `hico-demo-db`.`employeelist` SET `firstName`='Jim' WHERE  `employeeID`='002';
 */