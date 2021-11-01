package com.example.java_api;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/getemployeelist")
public class GetEmployeeList extends HttpServlet {
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
            String sqlStr = "select * from employeelist";
            ResultSet rset = stmt.executeQuery(sqlStr);  // Send the query to the server
            // Step 4: Process the query result set
            String myJsonString; //Variable to store list of employees in JSON format
            myJsonString = "[";
            Boolean recordWasFound = rset.next();
            while (recordWasFound) {
                //Get current record in table and add to JSON response
                myJsonString += "{";
                myJsonString += "\"employeeID\":" + "\"" + rset.getString("employeeID") + "\"";
                myJsonString += ",";
                myJsonString += "\"firstName\":" + "\"" + rset.getString("firstName") + "\"";
                myJsonString += ",";
                myJsonString += "\"lastName\":" + "\"" + rset.getString("lastName") + "\"";
                myJsonString += ",";
                myJsonString += "\"salutation\":" + "\"" + rset.getString("salutation") + "\"";
                myJsonString += ",";
                myJsonString += "\"profileColour\":" + "\"" + rset.getString("profileColour") + "\"";
                myJsonString += ",";
                myJsonString += "\"gender\":" + "\"" + rset.getString("gender") + "\"";
                myJsonString += ",";
                myJsonString += "\"grossSalary\":" + rset.getDouble("grossSalary");
                myJsonString += "}";
                //Move the row to the next record
                recordWasFound = rset.next();
                if (recordWasFound == true) {
                    //if there are more rows / records
                    myJsonString += ",";
                } else {
                    //if this is the last record / rows
                    myJsonString += "]";
                }//end if
            }//end While
            System.out.println(myJsonString); //Print in Tomcat log what the JSON string looks like
            //Put JSON String into 'out' (output package)
            out.println(myJsonString);
        } catch (Exception e) {
            System.out.println("ERROR getting table data");
        }
    }//end doGet
}//end class
