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
 * that have been predefined for it. In this case LoginExitMenuOption has
 * the following valid values UNKNOWN,LOGIN & EXIT.
 * 
 * @see enum 
 * @author kenwilson
 */
public enum LoginExitMenuOption {
    UNKNOWN(0),
    LOGIN(1),
    EXIT(2);

    private static final Map<Integer,LoginExitMenuOption> lookup 
        = new HashMap<Integer,LoginExitMenuOption>();

    static {
        for(LoginExitMenuOption s : EnumSet.allOf(LoginExitMenuOption.class))
           lookup.put(s.getLoginExitMenuOption(), s);
    }

    final private int loginExitMenuOption;

    private LoginExitMenuOption(int loginExitMenuOption) {
        this.loginExitMenuOption = loginExitMenuOption;
    }

    public int getLoginExitMenuOption() { return loginExitMenuOption; }

    public static LoginExitMenuOption get(int loginExitMenuOption) { 
        return lookup.get(loginExitMenuOption); 
    }
    
    /**
     * Is a static method that returns a String representation of 
     * LoginExitMenuOption.
     * 
     * @param option login/exit menu option. 
     * @return String of textual representation of menu option
     */                    
    static public String toString(LoginExitMenuOption option) {
        switch (option) {
            case LOGIN:{
                return "1";
            }
            case EXIT:{
                return "2";
            }
            default:{
                return "-1";
            }
        }
    }
    
}
