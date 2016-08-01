/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalnews.users;

import com.globalnews.content.Article;
import java.util.ArrayList;
import java.util.List;

/**
 * Authors blog articles for the Global News web site. This object stores all 
 * the relevant details and articles for a particular Author. 
 * 
 * @see Article
 * @author kenwilson
 */
public class Author extends CMSUser {
    private String addressLineOne;
    private String addressLineTwo;
    private String addressLineThree;
    private String zipCode;
    private String IBAN;
    private String BIC;
    private List<Article> articles = new  ArrayList<>();

    /**
     * Gets the first line of the Authors address.
     * 
     * @return first line of address
     */
    public String getAddressLineOne() {
        return this.addressLineOne;
    }
    
    /**
     * Sets the first line of the address.
     * 
     * @param addressLineOne text line of the address. 
     */
    public void setAddressLineOne( String addressLineOne ) {
        this.addressLineOne = addressLineOne;
    }

    /**
     * Gets the second line of the Authors address.
     * 
     * @return second line of address
     */    
    public String getAddressLineTwo() {
        return this.addressLineTwo;
    }

    /**
     * Sets the second line of the address.
     * 
     * @param addressLineTwo text line of the address. 
     */    
    public void setAddressLineTwo( String addressLineTwo ) {
        this.addressLineTwo = addressLineTwo;
    }

    /**
     * Gets the third line of the Authors address.
     * 
     * @return third line of address
     */
    public String getAddressLineThree() {
        return this.addressLineThree;
    }

    /**
     * Sets the third line of the address.
     * 
     * @param addressLineThree text line of the address. 
     */    
    public void setAddressLineThree( String addressLineThree ) {
        this.addressLineThree = addressLineThree;
    }

    /**
     * Sets the authors zip code. Zip code is a system of postal codes for a 
     * country.
     * 
     * @param zipCode 
     */
    public void setZipCode( String zipCode ) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the authors zip code. Zip code is a system of postal codes for a 
     * country.
     * 
     * @return String value of the zip code 
     */
    public String getZipCode( ) {
        return this.zipCode;
    }
    
    /**
     * This sets the IBAN of an Author. IBAN stands for International Bank 
     * Account Number and is a number attached to all accounts in the EU 
     * countries plus Norway, Switzerland, Liechtenstein and Hungary. 
     * 
     * The IBAN is made up of a code that identifies the country the account 
     * belongs to, the account holder's bank and the account number itself.
     * 
     * @param IBAN String value of the IBAN.
     */
    public void setIBAN( String IBAN ) {
        this.IBAN = IBAN;
    }

    /**
     * This gets the IBAN of an Author. IBAN stands for International Bank 
     * Account Number and is a number attached to all accounts in the EU 
     * countries plus Norway, Switzerland, Liechtenstein and Hungary. 
     * 
     * The IBAN is made up of a code that identifies the country the account 
     * belongs to, the account holder's bank and the account number itself.
     * 
     * @return String value of the IBAN.
     */
    public String getIBAN() {
        return this.IBAN;
    }

    /**
     * Sets the Author BIC number. BIC (Bank Identifier Code) is the SWIFT 
     * Address assigned to a bank in order to send automated payments quickly 
     * and accurately to the banks concerned. It uniquely identifies the name 
     * and country, (and sometimes the branch) of the bank involved. 
     * 
     * @param the authors BIC number. 
     */
    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    /**
     * Gets the Author BIC number. BIC (Bank Identifier Code) is the SWIFT 
     * Address assigned to a bank in order to send automated payments quickly 
     * and accurately to the banks concerned. It uniquely identifies the name 
     * and country, (and sometimes the branch) of the bank involved. 
     * 
     * @return the authors BIC number. 
     */    
    public String getBIC( ) {
        return this.BIC;
    }    
    
    /**
     * Sets the Authors articles. 
     * 
     * @see Article
     * @param articles 
     */
    public void setArticles( List<Article> articles ) {
        this.articles.addAll(articles);
    }

    /**
     * Gets the Authors articles. 
     * 
     * @see Article
     * @return articles 
     */    
    public List<Article> getArticles() {
        return this.articles;
    }  

    /**
     * Adds an Article to the list of Articles belonging to an Author. 
     * 
     * @see Article
     * @param article belonging to an Author.
     * @throws Exception when the article already exists.
     */    
    public void addArticle(Article article) throws Exception {
        for(Article a : this.articles) {
            if (a.getId() == article.getId()) {
                throw new Exception("Adding an Article that already exists");
            }
        }
        this.articles.add(article);
    }
   
    /**
     * Deletes all articles belonging to an Author.
     */
    public void clearArticles() {
        this.articles.clear();
    }   
}
