package com.sber.task.ThreeNumbersRest.model;

public class Member {
    private String id;
    private String sum;

    public Member(String id, String sum) {
        this.id = id;
        this.sum = sum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
