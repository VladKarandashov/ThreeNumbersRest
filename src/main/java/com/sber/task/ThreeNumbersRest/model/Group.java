package com.sber.task.ThreeNumbersRest.model;

import java.util.ArrayList;

public class Group {
    private String group;
    private String sum;
    private ArrayList<Member> members;

    public Group(String group, String sum, ArrayList<Member> members) {
        this.group = group;
        this.sum = sum;
        this.members = members;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }
}
