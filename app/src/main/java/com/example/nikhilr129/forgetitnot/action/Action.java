package com.example.nikhilr129.forgetitnot.action;

import io.realm.RealmModel;

/**
 * Created by kanchicoder on 4/12/17.
 */


public class Action implements RealmModel {
    private String name;
    private int thumbnail;
    private boolean isSelected;

    public void setSelected(){
        this.isSelected = !this.isSelected;
    }

    public boolean getSelected(){
        return isSelected;
    }
    public Action() {
        this.isSelected = false;

    }

    public Action(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
