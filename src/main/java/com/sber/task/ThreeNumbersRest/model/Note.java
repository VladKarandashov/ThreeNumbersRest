package com.sber.task.ThreeNumbersRest.model;

import javax.persistence.*;

@Entity
@Table(name = "NOTES")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "MEMBER", nullable = false)
    private Long member;

    @Column(name = "section", nullable = false)
    private Long group;

    @Column(name = "item", nullable = false)
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

    public Note() {
    }

    public Note(Long member, Long group, Double item) {
        this.member = member;
        this.group = group;
        this.item = item;
    }
}
