package com.example.mypc.fb_mvvm.Data;

/**
 * Created by MyPC on 27/06/2017.
 */

public class Friend {
    String name;
    String image;

    public Friend(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
