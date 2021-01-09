package com.example.knapsack.pojo;

import java.io.Serializable;

public class RequestPojo implements Serializable {

    private String name;
    private Double count;

    public RequestPojo() {
    }

    public RequestPojo(String name, Double count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }
}
