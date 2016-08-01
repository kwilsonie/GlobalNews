/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews;

import com.globalnews.author.mvc.AuthorController;

/**
* <h1>GlobalNews Authors Application</h1>
* The AuthorApplication program implements an application that
* allows for Authors to list, submit, display Articles to the GlobalNews 
* Content Management System.
* <p>
* <b>Note:</b> General info on Content Management Systems can be found here
* https://en.wikipedia.org/wiki/Content_management_system.
*
* @author  kenwilson
* @version 1.0
* @since   29-07-2016
*/
public class AuthorApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AuthorController app = new AuthorController();
        app.authorLoginOptions();
    }
    
}
