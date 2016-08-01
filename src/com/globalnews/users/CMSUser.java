/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.users;

/**
 * An abstract CMSUser which implements the User interface. 
 * 
 * @see User
 * @author kenwilson
 */
public abstract class CMSUser implements User, Cloneable {
    private String name;
    private String password;
    private String mobile;
    private String email;
    private Role role;
    private int id;

    /**
     * Sets the Database unique id of the User. 
     * 
     * @param id unique id of the User
     */                                        
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the Database unique id of the User. 
     * 
     * @return id unique id of the User
     */                                            
    public int getId() {
        return this.id;
    }
    
    /**
     * Sets the name of the User.
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

   /**
     * Gets the name of the User.
     * @return name
     */    
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Sets the password of the User.
     * 
     * @param password 
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the password of the User.
     * 
     * @return password. 
     */
    @Override
    public String getPassword() {
        return this.password;
    }
    
    /**
     * Sets the User mobile number.
     * 
     * @param mobile 
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the User mobile number.
     * 
     * @return mobile number. 
     */
    public String getMobile() {
        return this.mobile;
    }
    
    /**
     * Sets the User email address. In future releases of the product the 
     * email address will probably be used for authentication. 
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the User email address. In future releases of the product the 
     * email address will probably be used for authentication. 
     * 
     * @return email 
     */    
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the Role of the User.
     * 
     * @see Role.
     * @param role 
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets the Role of the User.
     * 
     * @see Role.
     * @return role 
     */    
    public Role getRole() {
        return this.role;
    }
    
}
