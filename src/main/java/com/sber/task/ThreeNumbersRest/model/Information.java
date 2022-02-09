package com.sber.task.ThreeNumbersRest.model;

import java.util.ArrayList;

public class Information {
    private ArrayList<Group> info;
    private String sum;

    public Information(ArrayList<Group> info,  String sum) {
        this.info = info;
        this.sum = sum;
    }

    public ArrayList<Group> getInfo() {
        return info;
    }

    public void setInfo(ArrayList<Group> info) {
        this.info = info;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
