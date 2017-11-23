package com.example.francisco.mallsbeaconslocation.models;

/**
 * Created by jhovy on 23/09/2017.
 */

public class Recomendation {

    private String itemname, itemdescription, itemurl, itemsodium, itemsugar, promotion, promotiondescription;

    public Recomendation() {
    }

    public Recomendation(String itemname, String itemdescription, String itemurl, String itemsodium, String itemsugar, String promotion, String promotiondescription) {
        this.itemname = itemname;
        this.itemdescription = itemdescription;
        this.itemurl = itemurl;
        this.itemsodium = itemsodium;
        this.itemsugar = itemsugar;
        this.promotion = promotion;
        this.promotiondescription = promotiondescription;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getPromotiondescription() {
        return promotiondescription;
    }

    public void setPromotiondescription(String promotiondescription) {
        this.promotiondescription = promotiondescription;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public String getItemurl() {
        return itemurl;
    }

    public void setItemurl(String itemurl) {
        this.itemurl = itemurl;
    }

    public String getItemsodium() {
        return itemsodium;
    }

    public void setItemsodium(String itemsodium) {
        this.itemsodium = itemsodium;
    }

    public String getItemsugar() {
        return itemsugar;
    }

    public void setItemsugar(String itemsugar) {
        this.itemsugar = itemsugar;
    }
}
