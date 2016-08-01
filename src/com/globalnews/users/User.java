/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.users;

/**
 * The User interface doesn't contain an implementation of the methods, only 
 * the signature (name, parameters and exceptions) of the method for CMSUsers
 * of the system.
 * 
 * @author kenwilson
 */
public interface User {
    public void setName( String name );
    public String getName( );
    public void setPassword ( String password );
    public String getPassword( );
}
