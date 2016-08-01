/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.author.mvc.menus;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * An enum type is a special data type that enables for a variable to be a set 
 * of predefined constants. The variable must be equal to one of the values 
 * that have been predefined for it. In this case AuthorMainMenuOption has
 * the following valid values UNKNOWN,LIST_ALL_ARTICLES,LIST_REJECTED_ARTICLES,
 * LIST_PUBLISHED_ARTICLES,DISPLAY_ARTICLE,SUBMIT_ARTICLE & EXIT.
 * 
 * @see enum 
 * @author kenwilson
 */
public enum AuthorMainMenuOption {
    UNKNOWN(0),
    LIST_ALL_ARTICLES(1),
    LIST_REJECTED_ARTICLES(2),
    LIST_PUBLISHED_ARTICLES(3),
    DISPLAY_ARTICLE(4),
    SUBMIT_ARTICLE(5),
    EXIT(6);

    private static final Map<Integer,AuthorMainMenuOption> lookup 
        = new HashMap<Integer,AuthorMainMenuOption>();

    static {
        for(AuthorMainMenuOption s : EnumSet.allOf(AuthorMainMenuOption.class))
           lookup.put(s.getAuthorMainMenuOption(), s);
    }

    final private int authorMainMenuOption;

    private AuthorMainMenuOption(int authorMainMenuOption) {
        this.authorMainMenuOption = authorMainMenuOption;
    }

    public int getAuthorMainMenuOption() { return authorMainMenuOption; }

    public static AuthorMainMenuOption get(int authorMainMenuOption) { 
        return lookup.get(authorMainMenuOption); 
    }
    
    /**
     * Is a static method that returns a String representation of 
     * AuthorMainMenuOption.
     * 
     * @param option author main menu option. 
     * @return String of textual representation of menu option
     */                    
    static public String toString(AuthorMainMenuOption option) {
        switch (option) {
            case LIST_ALL_ARTICLES:{
                return "1";
            }
            case LIST_REJECTED_ARTICLES:{
                return "2";
            }
            case LIST_PUBLISHED_ARTICLES:{
                return "3";
            }
            case DISPLAY_ARTICLE:{
                return "4";
            }
            case SUBMIT_ARTICLE:{
                return "5";
            }
            case EXIT:{
                return "6";
            }
            default:{
                return "0";
            }
        }
    }    
}
