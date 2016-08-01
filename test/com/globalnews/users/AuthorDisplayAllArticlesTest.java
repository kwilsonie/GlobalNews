/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.users;

import com.globalnews.author.mvc.AuthorController;
import com.globalnews.author.mvc.AuthorView;
import com.globalnews.author.mvc.menus.AuthorMainMenuOption;
import com.globalnews.author.mvc.menus.LoginExitMenuOption;
import com.globalnews.content.ArticleStatus;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.testng.Assert.assertNotNull;

/**
 * AuthorDisplayAllArticlesTest JUNIT test
 * 
 * @author kenwilson
 */
public class AuthorDisplayAllArticlesTest {
    private AuthorController app = null;
    private AuthorView view = null;
    
    public AuthorDisplayAllArticlesTest() {
    }

    @Test
    public void testAuthorSumitArticle() {
        System.out.println("(SETUP) - Start Setup");
        System.out.println("(SETUP) - Create new instance of AuthorController ");        
        this.app = new AuthorController();        
        assertNotNull(this.app);
        System.out.println("(SETUP) - Created instance of AuthorController ");        
        System.out.println("(SETUP) - Instance of AuthorModel not NULL");        
        System.out.println("(SETUP) - Get instance of AuthorView ");        
        this.view = this.app.getAuthorView();
        assertNotNull(this.view);
        System.out.println("(SETUP) - Instance of AuthorView not NULL");        
        System.out.println("(SETUP) - Finished Setup");                

        System.out.println("");        
        System.out.println("(TEST 1) - Start test Author Login");
        System.out.println("(TEST 1) - Executing loginExitMenu to fetch login."); 
        System.out.println("(TEST 1) - Setting up Login option into a stream."); 
        String option = LoginExitMenuOption.toString(LoginExitMenuOption.LOGIN)
                + "\n";        
        InputStream input = new
            ByteArrayInputStream(option.getBytes(StandardCharsets.UTF_8));
        System.out.println("(TEST 1) - Login option stream created."); 
        System.out.println("");        
        System.out.println("(TEST 1) - Start display menu and emulate option " + 
                "'Login' to be pressed."); 

        LoginExitMenuOption loginExitMenu  = 
                this.view.loginExitMenu(input);
        
        System.out.println("");                
        System.out.println("(TEST 1) - Completed display menu and emulate option " 
                + "'Login' to be pressed."); 

        assertEquals(loginExitMenu, LoginExitMenuOption.LOGIN);
        System.out.println("(TEST 1) - Finish test Author Login");

        System.out.println("");        
        System.out.println("(TEST 2) - Start test Login User");
        System.out.println("(TEST 2) - Executing Login User."); 
        System.out.println("(TEST 2) - Setting up Username & password into a" + 
                " stream."); 
        System.out.println("");        
        option = "kenwilson\nletmein\n\n";
        input = new
            ByteArrayInputStream(option.getBytes(StandardCharsets.UTF_8));
        System.out.println("(TEST 3) - Username & password stream created."); 
        System.out.println("");        
        boolean isUserLoggedIn = this.view.loginUser(input);
        assertEquals(isUserLoggedIn, true);
        System.out.println("");                        
        System.out.println("(TEST 3) - User succesfully login."); 
        System.out.println("(TEST 3) - Finishsed test Login User");
        
        System.out.println("");        
        System.out.println("(TEST 4) - Start Test Display all Articles");
        System.out.println("(TEST 4) - Executing authMainMenuOption to" + 
                " fetch login."); 
        System.out.println("(TEST 4) - Setting up Login option into a stream."); 
        option = AuthorMainMenuOption.toString(
                AuthorMainMenuOption.LIST_ALL_ARTICLES) + "\n";        
        input = new
            ByteArrayInputStream(option.getBytes(StandardCharsets.UTF_8));
        System.out.println("(TEST 4) - Login option stream created."); 
        System.out.println("");        
             
        AuthorMainMenuOption authorMainMenu = this.view.authorMainMenu(input);
        assertEquals(authorMainMenu, AuthorMainMenuOption.LIST_ALL_ARTICLES);
        System.out.println("");
        System.out.println("(TEST 4) - Completed display main menu and "
                + "emulated 'LIST_ALL_ARTICLES' pressed."); 
        System.out.println("");        
        
        System.out.println("(TEST 5) - List all articles.");         
        assertEquals(this.view.displayArticles(ArticleStatus.ALL), true);
        System.out.println("(TEST 6) - List all article for an Author.");         
        System.out.println("");        
        System.out.println("(FINISHED) - Completed Test Run");
        System.out.println("");        
        System.out.println("");        
        System.out.println("");        
    }

    
}
