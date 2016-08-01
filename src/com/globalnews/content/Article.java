/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.content;

import java.util.Date;

/**
 * The Article is used by Global News to publish publications that contains 
 * news with advertising. The publications are hosted on their web site with 
 * all articles accompanied on their twitter feed. The continuous up to date 
 * publication covers various news topics. 
 * 
 * The Editorial-team has responsibility for accepting or rejecting articles. 
 * A publishing-team manages trafficking content, helped with a sales team 
 * that manages the online advertisements
 * 
 * @author kenwilson
 */
public class Article {
    private int id; 
    private int userId;
    private String title;
    private String content;
    private Date dateUpdated;
    private Date dateCreated;    
    private String location;
    private Category category;
    private ArticleStatus status;
    private String comment;

    /**
     * Sets the Database unique id of the Article. 
     * 
     * @param id unique id of the Article
     */                                    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }

    /**
     * Sets the Database unique id of the Author of the Article. 
     * 
     * @param userId unique id of the Author
     */                                        
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get the Database unique id of the Author of the Article. 
     * 
     * @return unique id of the Author
     */                                            
    public int getUserId() {
        return this.userId;
    }
    
    /**
     * Sets the title of the Article. 
     * 
     * @param title String of the title.
     */                                            
    public void setTitle( String title) {
        this.title = title;
    }

    /**
     * Gets the title of the Article. 
     * 
     * @param title of the Article.
     */                                              
    public String getTitle( ) {
        return this.title;
    }

    /**
     * Sets the content of the Article. 
     * 
     * @param content String of the content.
     */                                            
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the content of the Article. 
     * 
     * @return content of the Article.
     */                                                
    public String getContent( ) {
        return this.content;
    }

    /**
     * Stores the creation date of the Article.  
     * 
     * @param date Creation date of the article.
     */                                                
    public void setDateCreated(Date date) {
        this.dateCreated = date;
    }

    /**
     * Gets the creation date of the Article.  
     * 
     * @return Creation date of the article.
     */                                                   
    public Date getDateCreated( ) {
        return this.dateCreated;
    }

    /**
     * Stores the updated date of the Article.  
     * 
     * @param date Updated date of the article.
     */                                                    
    public void setDateUpdated(Date date) {
        this.dateUpdated = date;
    }

    /**
     * Gets the last updated date of the Article.  
     * 
     * @return Last updated date of the article.
     */                                                       
    public Date getDateUpdated( ) {
        return this.dateUpdated;
    }

    /**
     * Allows for a text location to be attached to an Article. In future 
     * releases this will be altered to a GSP coordinates.    
     * 
     * @param location attached to an article.
     */                                                        
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the text location to be attached to an Article. In future 
     * releases this will be altered to a GSP coordinates.    
     * 
     * @return location attached to an article.
     */                                                           
    public String getLocation( ) {
        return this.location;
    }

    /**
     * Sets the category of the article.    
     * 
     * @param category Category of Article.
     * @see Category
     */                                                            
    public void setCategory(Category category ) {
        this.category = category;
    }

    /**
     * Gets the category of the article.    
     * 
     * @return  Category of Article.
     * @see Category
     */                                                                
    public Category getCategory( ) {
        return this.category;
    }

    /**
     * Sets the status of the article.    
     * 
     * @param status the ongoing status of the Article.
     * @see ArticleStatus
     */                                                                
    public void setArticleStatus(ArticleStatus status) {
        this.status = status;
    }

    /**
     * Gets the status of the article.    
     * 
     * @return the ongoing status of the Article.
     * @see ArticleStatus
     */                                                                
    
    public ArticleStatus getArticleStatus( ) {
        return this.status ;
    }

    /**
     * Attaches comment to the article. Normally used by the Reviewer to send 
     * messages to the Author.
     * 
     * @param comment String comment about the Article.
     */                                                                   
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the attached comment to the article. Normally used by the 
     * Reviewer to send messages to the Author.
     * 
     * @return comment about the Article.
     */                                                                       
    public String getComment( ) {
        return this.comment;
    }
}
