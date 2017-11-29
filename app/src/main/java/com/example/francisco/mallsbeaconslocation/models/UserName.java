package com.example.francisco.mallsbeaconslocation.models;

/**
 * Created by jhovy on 28/11/2017.
 */

public class UserName {

    String userid, nameitem;

    public UserName(String userid, String nameitem) {
        this.userid = userid;
        this.nameitem = nameitem;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNameitem() {
        return nameitem;
    }

    public void setNameitem(String nameitem) {
        this.nameitem = nameitem;
    }
}
