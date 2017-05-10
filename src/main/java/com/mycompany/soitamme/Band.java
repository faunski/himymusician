/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soitamme;

/**
 *
 * @author Kimi
 */
public class Band {
    
    private String name, genre, email, phone, link;
    
    public Band(String giveName, String giveGenre, String giveEmail, String givePhone, String giveLink) {
        this.name = giveName;
        this.genre = giveGenre;
        this.email = giveEmail;
        this.phone = givePhone;
        this.link = giveLink;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLink() {
        return link;
    }
    
}
