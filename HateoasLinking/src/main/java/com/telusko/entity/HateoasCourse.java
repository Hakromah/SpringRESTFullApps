package com.telusko.entity;

import org.springframework.hateoas.RepresentationModel;

public class HateoasCourse extends RepresentationModel<HateoasCourse> {

    private int cid;
    private String cname;
    private Double cost;

    public HateoasCourse() {
        super();
    }

    public HateoasCourse(int cid, String cname, Double cost) {
        this.cid = cid;
        this.cname = cname;
        this.cost = cost;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
