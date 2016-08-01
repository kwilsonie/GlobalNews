/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.users;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * An enum type is a special data type that enables for a variable to be a set 
 * of predefined constants. The variable must be equal to one of the values 
 * that have been predefined for it. In this case the user has a Role which 
 * can be one of the following values; UNKNOWN,AUTHOR,REVIEWER,EDITORIAL_TEAM,
 * EDITOR_IN_CHIEF,ADVERTISEMENT_TEAM,PUBLISHING_TEAM & INVOCING_TEAM  
 * 
 * @see enum 
 * @author kenwilson
 */
public enum Role {
    UNKNOWN(0),
    AUTHOR(1),
    REVIEWER(2),
    EDITORIAL_TEAM(3),
    EDITOR_IN_CHIEF(4),
    ADVERTISEMENT_TEAM(5),
    PUBLISHING_TEAM(6),
    INVOCING_TEAM(7);

    private static final Map<Integer,Role> lookup 
        = new HashMap<Integer,Role>();

    static {
        for(Role s : EnumSet.allOf(Role.class))
           lookup.put(s.getRole(), s);
    }

    final private int role;

    private Role(int role) {
        this.role = role;
    }

    public int getRole() { return role; }

    public static Role get(int role) { 
        return lookup.get(role); 
    }
}
