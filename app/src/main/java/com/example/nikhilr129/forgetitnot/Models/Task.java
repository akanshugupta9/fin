package com.example.nikhilr129.forgetitnot.Models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by nikhilr129 on 22/4/17.
 */

public class Task extends RealmObject {
    @PrimaryKey
    public long id;
    public String title;
    public Event event;
    public RealmList<Action> actions;
    public String a0;
    public String a1;
    public String a2;
    public String a3;

    public Task()
    {

    }

}
