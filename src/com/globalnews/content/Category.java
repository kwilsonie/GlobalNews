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
 * that have been predefined for it. In this case an article has one Category 
 * which can be one of the following values; UNKNOWN,NEWS,POLITICS,SPORT, 
 * SCIENCE,ENTERAINMENT,SOCIETY,FOOD,FASHION & INVOCING_TEAM  
 * 
 * @see enum 
 * @author kenwilson
 */
public enum Category {
    UNKNOWN(0),
    NEWS(1),
    POLITICS(2),
    SPORT(3),
    SCIENCE(4),
    ENTERAINMENT(5),
    SOCIETY(6),
    FOOD(7),
    FASHION(8),
    ART(9);
    
    private static final Map<Integer,Category> lookup 
        = new HashMap<Integer,Category>();

    static {
        for(Category s : EnumSet.allOf(Category.class))
           lookup.put(s.getCategory(), s);
    }

    final private int category;

    private Category(int category) {
        this.category = category;
    }

    public int getCategory() { return category; }

    public static Category get(int category) { 
        return lookup.get(category); 
    }

    /**
     * Is a static method that returns a String representation of a Category.
     * 
     * @param category of an Article. 
     * @return String of textual representation of a Category
     * @see Category
     */                
    static public String toString(Category category) {
        switch (category) {
            case NEWS:{
                return "News";
            }
            case POLITICS:{
                return "Politics";
            }
            case SPORT:{
                return "Sports";
            }
            case SCIENCE:{
                return "Science";
            }
            case ENTERAINMENT:{
                return "Enterainment";
            }
            case SOCIETY:{
                return "Society";
            }
            case FOOD:{
                return "Food";
            }
            case FASHION:{
                return "Fashion";
            }
            case ART:{
                return "ART";
            }
            default:{
                return "Unknown";
            }
        }
        
    }

    /**
     * Is a static method that returns a Category from an entered text.
     * 
     * @param category of an Article in entered text form. 
     * @return Category 
     * @see Category
     */                
    static public Category toCategory(String category) {
        try {
            category = category.toLowerCase();
            if ( category.matches("news") ) {
                return Category.NEWS;       
            }
            if ( category.matches("politics") ) {
                return Category.POLITICS;       
            }
            if ( category.matches("sports") ) {
                return Category.SPORT;       
            }
            if ( category.matches("science") ) {
                return Category.SCIENCE;       
            }
            if ( category.matches("enterainment") ) {
                return Category.ENTERAINMENT;       
            }
            if ( category.matches("society") ) {
                return Category.SOCIETY;       
            }
            if ( category.matches("food") ) {
                return Category.FOOD;       
            }
            if ( category.matches("fashion") ) {
                return Category.FASHION;       
            }
            if ( category.matches("art") ) {
                return Category.ART;       
            }
        } catch(Exception e ) { }
        return Category.UNKNOWN;
    }
}
