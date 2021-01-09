package com.example.knapsack.pojo;

public class Item implements Comparable<Item>{
    private String name;
    private Double costPerStash;
    private Double weightPerStash;
    private Boolean fractional;
    private Double qty;

    private Double costPi;
    private Double weightWi;
    private Double ratioPiWi;

    public Item(String name, Double costPerStash, Double weightPerStash, Boolean fractional, Double qty, Double costPi, Double weightWi, Double ratioPiWi) {
        this.name = name;
        this.costPerStash = costPerStash;
        this.weightPerStash = weightPerStash;
        this.fractional = fractional;
        this.qty = qty;
        this.costPi = costPi;
        this.weightWi = weightWi;
        this.ratioPiWi = ratioPiWi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCostPerStash() {
        return costPerStash;
    }

    public void setCostPerStash(Double costPerStash) {
        this.costPerStash = costPerStash;
    }

    public Double getWeightPerStash() {
        return weightPerStash;
    }

    public void setWeightPerStash(Double weightPerStash) {
        this.weightPerStash = weightPerStash;
    }

    public Boolean getFractional() {
        return fractional;
    }

    public void setFractional(Boolean fractional) {
        this.fractional = fractional;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getCostPi() {
        return costPi;
    }

    public void setCostPi(Double costPi) {
        this.costPi = costPi;
    }

    public Double getWeightWi() {
        return weightWi;
    }

    public void setWeightWi(Double weightWi) {
        this.weightWi = weightWi;
    }

    public Double getRatioPiWi() {
        return ratioPiWi;
    }

    public void setRatioPiWi(Double ratioPiWi) {
        this.ratioPiWi = ratioPiWi;
    }


    @Override
    public int compareTo(Item item) {
        if(ratioPiWi==item.ratioPiWi)
            return 0;
        else if(ratioPiWi<item.ratioPiWi)
            return 1;
        else
            return -1;
    }
}
