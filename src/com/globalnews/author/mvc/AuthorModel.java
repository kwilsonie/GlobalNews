/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.author.mvc;

import com.globalnews.content.Article;
import com.globalnews.content.ArticleStatus;
import com.globalnews.content.Category;
import com.globalnews.db.Database;
import com.globalnews.security.SingleSignOn;
import com.globalnews.users.Author;
import com.globalnews.users.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h1>AuthorModel</h1>
 * The AuthorModel uses the Model-View-Controller Pattern. This pattern 
 * is used to separate application's concerns.
 * 
 * Model - AuthorModel represents an object or JAVA POJO carrying data. It can
 * also have logic to update controller if its data changes.
 * <p>
 * <b>Note:</b> The AuthorModel supports getUser, Author and Article information
 * and allowing the submission of articles. AuthorModel uses a MySQL database 
 * to store information in reference to the GlobalNews CMS system.
 * @see Database
 * @see Author 
 * @author kenwilson
 */
public class AuthorModel {
    final private Database db; 
    final private Author author;
 
    /**
     * Constructor.
     * 
     * @param db (required) A validate Database object to manage all creates, 
     * reads, updates and deletes.
     * @see Database
     */    
    public AuthorModel(Database db){
        this.db = db;
        this.author = new Author();
    }

    /**
     * Gets a user from the database. It uses the SingleSignOn security class
     * to ensure the correct username and password is entered into the system.
     * Once a valid user and password is entered the Author and its Articles 
     * are populated from the database.
     * 
     * @param username (required) A validate Database object to manage all 
     * creates, reads, updates and deletes.
     * @return true or false depending on whether the user has been 
     * successfully retrieved from the database. 
     */        
    public boolean getUser(String username, String password) 
            throws Exception{
        int id = SingleSignOn.signOn(this.db, username, password);
        if ( id == -1 ) {
            return false;
        }
        try {
            ResultSet rs = this.db.executeQuery("SELECT * FROM user WHERE id ='" 
                    + id + "';");
            while (rs.next()) {
                this.author.setName( username);
                this.author.setPassword(password);
                this.author.setId(id);
                this.author.setMobile(rs.getString("mobile"));
                this.author.setEmail(rs.getString("email"));
                this.author.setAddressLineOne(rs.getString("addressLineOne"));
                this.author.setAddressLineTwo(rs.getString("addressLineTwo"));
                this.author.setAddressLineThree(rs.getString(
                    "addressLineThree"));
                this.author.setZipCode(rs.getString("zipCode"));
                this.author.setIBAN(rs.getString("IBAN"));
                this.author.setRole(Role.get(rs.getInt("role")));
            }
            this.author.setId(id);
            this.db.cleanupQuery(rs);
            getArticles();
        } catch (SQLException ex) {
            Logger.getLogger(AuthorModel.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new Exception( ex.toString());
        }        
        return true;
    }

    /**
     * Get all articles for a particle user from the Database. 
     */            
    private void getArticles() 
            throws Exception {
        if ( this.author.getId() == -1 ) {
            throw new Exception("Invalid user ID, cannot get articles.");
        }

        try {
            ResultSet rs = this.db.executeQuery(
                "SELECT * FROM article WHERE user_id ='" + this.author.getId()+ 
                        "';");
            this.author.clearArticles();
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setUserId(rs.getInt("user_id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setDateCreated(rs.getDate("dateCreated"));
                article.setDateUpdated(rs.getDate("dateUpdated"));
                article.setLocation(rs.getString("location"));
                article.setCategory(Category.get(rs.getInt("category")));
                article.setArticleStatus(ArticleStatus.get(
                        rs.getInt("status")));
                article.setComment(rs.getString("comment"));
                this.author.addArticle(article);
            }
            this.db.cleanupQuery(rs);
        } catch (SQLException ex) {
            Logger.getLogger(AuthorModel.class.getName()).
                    log(Level.SEVERE, null, ex);
            throw new Exception( ex.toString());
        }             
    }
    
    /**
     * Adds a new article to the globalnews CMS system. It adds the new row via 
     * executing the SQL INSERT statement. Once the row has been successfully 
     * added, the id of the article is automatically generated by the server 
     * and stored in the row. 
     * To keep all in-memory attributes up to date, the Author attribute 
     * List<Article> is cleared and read from memory. 
     * 
     * @param article (required) A validate Article object that contains all 
     * the journal entry.
     */            
    public int addArticle(Article article){
        try {
            List<Article> oldArticles = this.getAuthor().getArticles();
            
            String sql = String.format("INSERT INTO article (user_id, " + 
                    "title, content, dateUpdated,dateCreated, location, " + 
                    "category, status, comment) VALUES ('%1$s','%2$s'," + 
                    "'%3$s', CURDATE(), CURDATE(),'%4$s', '%5$d', " +
                    "'%6$d', 'None');",  article.getUserId(), 
                    article.getTitle(), article.getContent(), 
                    article.getLocation(), article.getCategory().getCategory(), 
                    article.getArticleStatus().getArticleStatus());
            if (this.db.execute(sql)) {
                this.author.clearArticles();
                getArticles();
                List<Article> newArticles = this.getAuthor().getArticles();
                newArticles.removeAll(oldArticles);
                for (Article a : newArticles) {
                    return a.getId();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(AuthorModel.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    /**
     * Returns the Author object
     * 
     * @return Author object. 
     * @see Author.
     */
    public Author getAuthor() {
        return this.author;
    }    
}
