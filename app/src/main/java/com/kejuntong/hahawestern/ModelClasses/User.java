package com.kejuntong.hahawestern.ModelClasses;

/**
 * Created by kejuntong on 16-05-08.
 */
public class User {

    String userId;
    String userName;

    public User(String id, String name){
        this.userId = id;
        this.userName = name;
    }

    public String getUserId(){
        return this.userId;
    }
    public String getUserName(){
        return this.userName;
    }

}
