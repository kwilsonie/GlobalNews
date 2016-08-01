/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.content;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * An enum type is a special data type that enables for a variable to be a set 
 * of predefined constants. The variable must be equal to one of the values 
 * that have been predefined for it. In this case an article has a ongoing 
 * status which can be one of the following values; ALL,SUBMITTED,REVIEWED,
 * REJECTED,APPROVED & FEATURED.
 * 
 * @see enum 
 * @author kenwilson
 */
public enum ArticleStatus {
    ALL(0),
    SUBMITTED(1),
    REVIEWED(2),
    REJECTED(3),
    APPROVED(4),
    FEATURED(5);

    private static final Map<Integer,ArticleStatus> lookup 
        = new HashMap<Integer,ArticleStatus>();

    static {
        for(ArticleStatus s : EnumSet.allOf(ArticleStatus.class))
           lookup.put(s.getArticleStatus(), s);
    }

    final private int articleStatus;

    private ArticleStatus(int articleStatus) {
        this.articleStatus = articleStatus;
    }

    public int getArticleStatus() { return articleStatus; }

    public static ArticleStatus get(int articleStatus) { 
        return lookup.get(articleStatus); 
    }

    /**
     * Is a static method that returns a String representation of 
     * an ArticleStatus.
     * 
     * @param status of an Article. 
     * @return String of textual representation of an ArticleStatus
     */                    
    static public String toString(ArticleStatus status) {
        switch (status) {
            case SUBMITTED:{
                return "Submitted";
            }
            case REVIEWED:{
                return "Reviewed";
            }
            case REJECTED:{
                return "Rejected";
            }
            case APPROVED:{
                return "Approved";
            }
            case FEATURED:{
                return "Featured";
            }
            default:{
                return "All";
            }
        }      
    }
}
