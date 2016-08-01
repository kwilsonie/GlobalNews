/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class provides a simple JDBC class. This will show you how to open a 
 * database connection, execute a SQL query, and return the results. Requires 
 * that you initialize a driver so you can open a communication channel 
 * with the database. 
 * 
 * @author kenwilson
 */
public class Database {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
   final private String db;
   final private String user;
   final private String password;
   private Connection conn;
   private Statement stmt;


   /**
    * Constructor for database access.  
    * @param db
    * @param user
    * @param password 
    */
   public Database(String db, String user, String password) {
       this.db = db;
       this.user = user;
       this.password = password;
       this.conn = null;
       this.stmt = null;
   }

   /**
    * Returns the database name.
    * @return database.
    */
   public String getDbName() {
       return this.db;
   }
   
   /**
    * Opens a connection to the database. It requires using the D
    * riverManager.getConnection() method to create a Connection object, 
    * which represents a physical connection with the database.
    * 
    * @return boolean value indicating whether connection to database was 
    * successful. 
    */
   public boolean open( ) {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/globalnews", this.user, 
                    this.password);
            this.stmt = this.conn.createStatement( );                  
       } catch ( SQLException e ) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, 
                   null,"Openning SQL connection failure: " + e.toString());
           return false;
       } catch ( ClassNotFoundException e){
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, 
                   null,"Cant find jdbc.Driver: " + e.toString());
           return false;           
       }
       return true;
   }

    /**
     * Executes a query SQL to the database. Requires using an object of 
     * type Statement for building and submitting an SQL statement to the 
     * database.
     * 
     * @param sql
     * @return resultSet 
     * @throws SQLException
     * @see ResultSet
     */
   public ResultSet executeQuery(String sql) throws SQLException {
       return this.stmt.executeQuery(sql);       
   }

    /**
     * Executes an SQL to the database. Requires using an object of 
     * type Statement for building and submitting an SQL statement to the 
     * database.
     * 
     * @param sql
     * @return boolean 
     * @throws SQLException
     */   
   public boolean execute(String sql) throws SQLException {
       return this.stmt.execute(sql);       
   }   

   /**
    * Cleans up query objects to the database. Requires explicitly closing all 
    * database resources versus relying on the JVM's garbage collection.
    * 
    * @param set 
    */
   public void cleanupQuery(ResultSet set) {
       try {       
            set.close();
       } catch (Exception e) {
           Logger.getLogger(Database.class.getName()).
                   log(Level.SEVERE, null, e);
       }
   }

   /**
    * Close access to the database. Requires explicitly closing all 
    * database resources versus relying on the JVM's garbage collection.
    * 
    * @return boolean value informing whether the action was successful or not. 
    */   
   public boolean close ( ) {
       try {
           this.stmt.close();
           this.conn.close();             
       } catch ( SQLException e ) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, 
                   null,"CLosing SQL connection failure: " + e.toString());
           return false;
       }
       return true;
   }
}
