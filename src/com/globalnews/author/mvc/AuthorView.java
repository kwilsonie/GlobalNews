/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.author.mvc;

import com.globalnews.author.mvc.menus.AuthorMainMenuOption;
import com.globalnews.author.mvc.menus.LoginExitMenuOption;
import com.globalnews.content.Article;
import com.globalnews.content.ArticleStatus;
import com.globalnews.content.Category;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 * <h1>AuthorView</h1>
 * The AuthorView uses the Model-View-Controller Pattern. This pattern 
 * is used to separate application's concerns.
 * 
 * View - AuthorView represents the visualization of the data that AuthorModel 
 * contains.
 * <p>
 * <b>Note:</b> Any method which contains Menu in it displays and accepts 
 * Author menu options. Other key display and data entry methods are loginUser, 
 * displayArticles, displayArticle and submitArticle. There is also a static 
 * snippet method used to limit the display of large text. 
 * 
 * @see AuthorModel
 * @author kenwilson
 */
public class AuthorView {
    final private AuthorModel model;

    /**
     * Constructor.
     * 
     * @param model (required) Model object handle all Java POJO carrying data.
     * @see AuthorModel
     */        
    public AuthorView(AuthorModel model) {
        this.model = model;
    }

    /**
     * Displays and accepts menu options login and exit to the user. It uses 
     * an enum LoginExitMenuOption to store the valid menu options. Also 
     * InputStreamReader & BufferedReader to accept entries from the console.
     * 
     * @see LoginExitMenuOption
     * @see InputStreamReader
     * @see BufferedReader
     * @param in input from keyword or String (JUNIT)
     * @return whether the user wants to login or exit. 
     */            
    public LoginExitMenuOption loginExitMenu(InputStream in) {
        InputStreamReader istream = new InputStreamReader(in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;        
        LoginExitMenuOption option = LoginExitMenuOption.UNKNOWN;
        System.out.println(""); 
        System.out.println(""); 
        System.out.println("--- Welcome to the CMS tool for Authors ---");
        while (true) {
            System.out.println(""); 
            System.out.println("1) Login User");
            System.out.println("2) Exit");
            System.out.println(""); 
            System.out.print( "Select option 1 or 2? ");            
            try {
                option = LoginExitMenuOption.get(
                        Integer.parseInt(bufRead.readLine()));
            } catch (Exception ex) {
                option = LoginExitMenuOption.UNKNOWN;
            } finally {
                if ( option == LoginExitMenuOption.UNKNOWN ) {
                    System.out.println("");
                    System.out.println("ERROR> Enter either 1 or 2");
                    System.out.println("");
                    System.out.println("");  
                }                
            }
            return option;
        }
    }

    /**
     * Displays and accepts menu options list all, rejected, published 
     * articles and allows the user to display or submit an article. It uses 
     * an enum AuthorMainMenuOption to store the valid menu options. Also 
     * InputStreamReader & BufferedReader to accept entries from the console
     * 
     * @see AuthorMainMenuOption
     * @see InputStreamReader
     * @see BufferedReader
     * @param in input from keyword or String (JUNIT)
     * @return whether the user wants to login or exit. 
     */            
    public AuthorMainMenuOption authorMainMenu(InputStream in) {
        InputStreamReader istream = new InputStreamReader(in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;        
        AuthorMainMenuOption option = AuthorMainMenuOption.UNKNOWN;
        while (true) {
            System.out.println(""); 
            System.out.println("1) List All Articles");
            System.out.println("2) List Rejected Articles");
            System.out.println("3) List Published Articles");
            System.out.println("4) Display Article");
            System.out.println("5) Submit Article");
            System.out.println("6) Exit");
            System.out.println(""); 
            System.out.print(this.model.getAuthor().getName() + 
                    "> Select option 1,2,3,4,5 or 6? ");            
            try {
                option = AuthorMainMenuOption.get(
                        Integer.parseInt(bufRead.readLine()));
            } catch (Exception ex) {
                option = AuthorMainMenuOption.UNKNOWN;
            } finally {
                if ( option == AuthorMainMenuOption.UNKNOWN ) {
                    System.out.println( "");
                    System.out.println( "ERROR> 1,2,3,4,5 or 6");
                    System.out.println( "");
                    System.out.println( "");  
                }                
            }
            return option;
        }        
    }

    /**
     * Displays and accepts user name and password. With the login credentials 
     * uses the AuthorModel to fetch a valid Author and returns true/false if
     * the process has been successfully or not. It uses InputStreamReader 
     * & BufferedReader to accept entries from the console
     * 
     * @see AuthorModel
     * @see InputStreamReader
     * @see BufferedReader
     * @param in input from keyword or String (JUNIT)
     * @return whether the user has successfully logged in or not. 
     */                
    public boolean loginUser(InputStream in) {
        InputStreamReader istream = new InputStreamReader(in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;
        boolean userloggedIn = false;       
        try {
            System.out.println(""); 
            System.out.print( 
                "Please enter your username [Ctrl+C to quit]. ");
            String username = bufRead.readLine();
            System.out.print( 
                "Please enter your password [Ctrl+C to quit]. ");
            String password = bufRead.readLine();
            userloggedIn = this.model.getUser( username, password );
            if ( userloggedIn ) {  
                System.out.println( "");
                System.out.print( 
                    "Successfully logged in [press enter to continue].");         
            } else {
                System.out.println( "");
                System.out.print( 
                    "User not found [press enter to continue].");                         
            }
            bufRead.readLine();   
        } catch (Exception ex) {
            Logger.getLogger(AuthorView.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return userloggedIn;
    } 
    
    /**
     * Displays all articles of a particular ArticleStatus. It gets the valid 
     * List of Articles from the Author object and displays a summary of 
     * requested articles to the console. 
     * 
     * @param status the selected article types to display. 
     * @return boolean indicating when results are found or not. 
     * @see AuthorModel
     * @see Author
     */                    
    public boolean displayArticles(ArticleStatus status) {
        System.out.println(""); 
        System.out.print(this.model.getAuthor().getName() + 
                    "> Display " + 
                ArticleStatus.toString(status) + " articles.");
        System.out.println(""); 
        boolean resultsFound = false;
        List<Article> articles = this.model.getAuthor().getArticles();
        for (Article a : articles) {
            if (a.getArticleStatus() == status || 
                    status == ArticleStatus.ALL) {
                resultsFound = true;
                System.out.println("   ID:'" + a.getId() + 
                        "' TITLE:'" + snippet(a.getTitle(), 10 ) + 
                        "' LOCATION:" + snippet(a.getLocation(),10 ) + 
                        " CATEGORY:'" + Category.toString(a.getCategory()) + 
                        "'");
            }
        }
        System.out.println("");
        return resultsFound;
    }

    /**
     * Displays one particular article in full. The user is prompted to entered
     * the article ID to be displayed. If the ID is valid the Article is 
     * fetched and displayed in full on the console. 
     * 
     * @param id int of the unique key to the article. 
     * @see InputStreamReader
     * @see BufferedReader
     */                        
    public void displayArticle(int id) {
        if (id == -1) {
            InputStreamReader istream = new InputStreamReader(System.in) ;
            BufferedReader bufRead = new BufferedReader(istream) ;
            boolean userloggedIn = false;       
            try {
                System.out.println(""); 
                System.out.print(this.model.getAuthor().getName() + 
                    "> Please enter the article id to display. ");
                id = Integer.parseInt(bufRead.readLine());
            } catch (Exception ex) {
                System.out.println("Invalid article ID."); 
                return;
            }
        }

        System.out.println(""); 
        System.out.print(this.model.getAuthor().getName() + 
                    "> Display Article with ID:'" + id + "'.");
        List<Article> articles = this.model.getAuthor().getArticles();
        for (Article a : articles) {
            if (a.getId() == id){
                System.out.println(""); 
                System.out.println("   ID:'" + a.getId() + "'.");
                System.out.println("   TITLE:'" + a.getTitle() + "'.");
                System.out.println("   CONTENT:'" + a.getContent() + "'.");
                System.out.println("   DATE CREATED:'" + 
                        a.getDateCreated() + "'.");
                System.out.println("   DATE UPDATED:'" + 
                        a.getDateUpdated() + "'.");
                System.out.println("   LOCATION:'" + a.getLocation() + "'.");
                System.out.println("   CATEGORY:'" + 
                        Category.toString(a.getCategory()) + "'.");
                System.out.println("   STATUS:'" + 
                        ArticleStatus.toString(a.getArticleStatus()) + "'.");
                System.out.println("   COMMENTS:'" + a.getId() + "'.");
                System.out.println(""); 
                return;
            }
        }
        System.out.println(" Article not found."); 
        System.out.println(""); 
    }

    /**
     * Allows the user to submit an article. The user is prompted to entered
     * each attribute of an article and its added to the database via the 
     * Model. 
     * 
     * @see InputStreamReader
     * @see BufferedReader
     * @see AuthorModel
     * @param in input from keyword or String (JUNIT)
     * @return int ID or -1.
     */                            
    public int submitArticle(InputStream in) {
        System.out.println(""); 
        System.out.print(this.model.getAuthor().getName() + 
                    "> Submit an article " );
        System.out.println(""); 
        InputStreamReader istream = new InputStreamReader(in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;
        try {
            Article article = new Article();
            System.out.println(""); 
            System.out.print("Please enter the title. ");
            article.setTitle(bufRead.readLine().trim().replaceAll("\n"," "));
            System.out.print("Please enter the content. ");
            article.setContent(bufRead.readLine().trim().replaceAll("\n"," "));
            System.out.print("Please enter the location. ");
            article.setLocation(bufRead.readLine().trim().replaceAll("\n"," "));
            System.out.print("Please enter the category(news,politics," + 
                    "sports,science,enterainment,society,food,fashion,art).");
            article.setCategory(Category.toCategory(bufRead.readLine().
                    trim().replaceAll("\n"," ")));
            System.out.print("Please enter the comment. ");
            article.setComment(bufRead.readLine().trim().replaceAll("\n"," "));
            article.setDateCreated(new Date());
            article.setDateUpdated(new Date());
            article.setUserId(this.model.getAuthor().getId());
            article.setArticleStatus(ArticleStatus.SUBMITTED);
            return this.model.addArticle(article);            
        } catch (Exception ex) {
            System.out.println("An error happened when entering your article."); 
            System.out.println(""); 
        }
        return -1;
    }    
   
    /**
     * A static method that creates a snippet of text to a maximum size. 
     * 
     * @param data original String
     * @param length maximum length of the string.
     * 
     * @see InputStreamReader
     * @see BufferedReader
     * @see AuthorModel
     */                                
    static private String snippet(String data, int length) {
        if ( data.length() <= length ) {
            return data;
        }
        return data.substring(0, length) + "...";
    } 

}