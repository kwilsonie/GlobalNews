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
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.testng.Assert.*;

/**
 * AuthorSubmitsArticleTest JUNIT
 * 
 * @author kenwilson
 */
public class AuthorSubmitsArticleTest {
    private AuthorController app = null;
    private AuthorView view = null;
    
    public AuthorSubmitsArticleTest() {
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
        System.out.println("(TEST 4) - Start Test Submit Article");
        System.out.println("(TEST 4) - Executing authMainMenuOption to" + 
                " fetch login."); 
        System.out.println("(TEST 4) - Setting up Login option into a stream."); 
        option = AuthorMainMenuOption.toString(
                AuthorMainMenuOption.SUBMIT_ARTICLE) + "\n";        
        input = new
            ByteArrayInputStream(option.getBytes(StandardCharsets.UTF_8));
        System.out.println("(TEST 4) - Login option stream created."); 
        System.out.println("");        
             
        AuthorMainMenuOption authorMainMenu = this.view.authorMainMenu(input);
        assertEquals(authorMainMenu, AuthorMainMenuOption.SUBMIT_ARTICLE);
        System.out.println("");
        System.out.println("(TEST 4) - Completed display main menu and "
                + "emulated 'SUBMIT ARTICLE' pressed."); 
        System.out.println("");        
        
        System.out.println("(TEST 5) - Setting up submitted article into a" + 
                " stream.");         
        String title = "These two people are running the ENTIRE Wild " + 
                "Atlantic Way for charity";
        String content = "That’s the advice of Lillian Deegan, a " + 
                "long-distance runner in the middle of one of her biggest " + 
                "challenges to date. She and Tom Reynolds are currently " +
                "running the entire Wild Atlantic Way. Driving the 2,500km " + 
                "route would be a daunting enough task, but the Wicklow duo " + 
                "are going above and beyond that. They hope to raise €10,000 " +
                "for suicide prevention charity Pieta House and Billy’s " +
                "World Ireland, a charity looking to build a recreation " + 
                "facility for children with disabilities.";
        String location = "Wicklow";
        String category = "Sport";
        String comment = "None";
        
        option = title + "\n" + content + "\n" + location + "\n" + category + 
                "\n" + comment + "\n";
        input = new
            ByteArrayInputStream(option.getBytes(StandardCharsets.UTF_8));
        System.out.println("(TEST 5) - Completed setting up submitted article" + 
                "into a stream.");         
        System.out.println("");        
        System.out.println("(TEST 6) - Submiting article into globalnews.");         
        int id = this.view.submitArticle(input);
        System.out.println("");
        assertNotEquals(id, false);
        System.out.println("(TEST 6) - Submitted article into globalnews.");         
        System.out.println("");        
        System.out.println("(FINISHED) - Completed Test Run");
        System.out.println("");        
        System.out.println("");        
        System.out.println("");        
    }
}
