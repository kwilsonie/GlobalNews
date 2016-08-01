/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.security;

import com.globalnews.db.Database;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Single Sign-On is a service that is usually provided by a class of
 * technology called Access management and there is a good reason for
 * that. An efficient SSO solution asks for user credentials just once. Then it 
 * needs to remember the fact that the user is already authenticated and it 
 * needs a session for that which requires some form of session management 
 * (which is part of access management). This has been broken out into a class 
 * to allow for it to be extended to introduce proper Access Management.
 * 
 * @author kenwilson
 */
public class SingleSignOn {
    
    /**
     * Static method to authenticate a username and password.
     * 
     * @param db
     * @param username
     * @param password
     * @return
     * @throws SecurityException 
     */
    static public int signOn(Database db, String username, 
            String password ) throws SecurityException {
        ResultSet rs = null;
        try {
            String sql = 
               "SELECT username, password, id FROM user WHERE username = '" + 
                    username +"';";
            rs = db.executeQuery(sql);
            String user = null;
            String pass = null;
            int id = -1;
            while ( rs.next()) {
                user = rs.getString("username");
                pass = rs.getString("password");
                id = rs.getInt("id");
            } 
            if ( id == -1 || username == null || 
                    username.compareTo(user) != 0 || 
                    password == null ||
                    password.compareTo( pass ) != 0 ) {
                return -1;
            }
            return id;
        } catch (Exception ex) {
            Logger.getLogger(SingleSignOn.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new SecurityException( ex.toString( ) );
        } finally {
            db.cleanupQuery(rs);
        }
    }
}
