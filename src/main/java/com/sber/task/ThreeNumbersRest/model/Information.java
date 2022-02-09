package com.sber.task.ThreeNumbersRest.model;

import java.util.ArrayList;

public class Information {
    private ArrayList<Group> info;

    public Information(ArrayList<Group> info) {
        this.info = info;
    }

    public ArrayList<Group> getInfo() {
        return info;
    }

    public void setInfo(ArrayList<Group> info) {
        this.info = info;
    }
}
