/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.author.mvc;

import com.globalnews.author.mvc.menus.AuthorMainMenuOption;
import com.globalnews.author.mvc.menus.LoginExitMenuOption;
import com.globalnews.content.ArticleStatus;
import com.globalnews.db.Database;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>AuthorController</h1>
 * The AuthorController uses the Model-View-Controller Pattern. This pattern 
 * is used to separate application's concerns.
 * 
 * Controller - AuthorController acts on both model (AuthorModel) and 
 * view ( AuthorView). It controls the data flow into model object and updates 
 * the view whenever data changes. It keeps view and model separate.
 * <p>
 * <b>Note:</b> The AuthorController supports authorLoginOptions and 
 * authorMainOptions
 * 
 * @see Database
 * @see AuthorModel 
 * @see AuthorView
 * @author kenwilson
 */
public class AuthorController {
    private Database db = null;
    private AuthorModel model = null;
    private AuthorView view = null; 

    /**
     * Constructor.
     */
    public AuthorController(){
        this.db = new Database( "globalnews", "littlefish", "letmein" );
        this.db.open();
        this.model = new AuthorModel( this.db );
        this.view = new AuthorView( this.model );
    }
    
    /**
     * Finalize() is called by the garbage collector on an object when 
     * garbage collection determines that there are no more references to 
     * the object.This method closes the open database before the 
     * application ends. 
     */
    @Override
    protected void finalize () {
        try {
            super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(AuthorController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        if ( this.db != null ) {
            this.db.close();
        }
    }
    
    /**
     * authorLoginOptions() calls the loginExitMenu until a user exists the 
     * application. It provides a login for uses and when an author logs into 
     * the they can select article management activities until they decide to 
     * quit.  
     */    
    public void authorLoginOptions(){
        LoginExitMenuOption loginExitMenu = LoginExitMenuOption.UNKNOWN;
        while (loginExitMenu != LoginExitMenuOption.EXIT) {        
            loginExitMenu = this.view.loginExitMenu(System.in);
            if (loginExitMenu == LoginExitMenuOption.LOGIN) {
                if (this.view.loginUser(System.in)) {                      
                    authorMainOptions();
                }
            }
        }
    }
 
    /**
     * authorMainOptions() calls the authorMainMenu providing login authors 
     * article management activities until they decide to quit. An author 
     * can list all articles, list rejected articles, list published articles,
     * display a full article and submit articles into the GlobalNews CMS 
     * system.
     */    
    protected void authorMainOptions(){
        AuthorMainMenuOption authorMainMenu = AuthorMainMenuOption.UNKNOWN;
        while (authorMainMenu != AuthorMainMenuOption.EXIT) {        
            authorMainMenu = this.view.authorMainMenu(System.in);
            switch(authorMainMenu) {
                case LIST_ALL_ARTICLES: {
                    this.view.displayArticles(ArticleStatus.ALL);
                    break;
                }
                case LIST_REJECTED_ARTICLES: { 
                    this.view.displayArticles(ArticleStatus.REJECTED);
                    break;
                }
                case LIST_PUBLISHED_ARTICLES: { 
                    this.view.displayArticles(ArticleStatus.APPROVED);
                    break;
                }
                case DISPLAY_ARTICLE: { 
                    this.view.displayArticle(-1);
                    break;
                }
                case SUBMIT_ARTICLE: { 
                    this.view.submitArticle(System.in);
                    break;
                }
                case EXIT: { 
                    break;
                }                
            }
        }        
    }
   
   /**
    * Access to the AuthorView for the JUNIT test  
    * @return AuthorView
    * @see AuthorView
    */
   public AuthorView getAuthorView(){
       return this.view;
   }
   
}
