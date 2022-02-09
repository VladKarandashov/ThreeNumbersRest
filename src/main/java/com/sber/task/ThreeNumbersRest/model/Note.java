package com.sber.task.ThreeNumbersRest.model;

public class Note {
    private int id;
    private Long member;
    private Long group;
    private Double item;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMember() {
        return member;
    }

    public void setMember(Long member) {
        this.member = member;
    }

    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
    }

    public Double getItem() {
        return item;
    }

    public void setItem(Double item) {
        this.item = item;
    }
}
