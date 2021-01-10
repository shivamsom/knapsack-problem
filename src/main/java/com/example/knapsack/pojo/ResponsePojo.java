package com.example.knapsack.pojo;

import java.io.Serializable;
import java.util.List;

public class ResponsePojo implements Serializable {
    private List<RequestPojo>itemList;
    private Double maxProfit;

    public ResponsePojo(List<RequestPojo> itemList, Double maxProfit) {
        this.itemList = itemList;
        this.maxProfit = maxProfit;
    }

    public List<RequestPojo> getItemList() {
        return itemList;
    }

    public void setItemList(List<RequestPojo> itemList) {
        this.itemList = itemList;
    }

    public Double getMaxProfit() {
        return maxProfit;
    }

    public void setMaxProfit(Double maxProfit) {
        this.maxProfit = maxProfit;
    }
}
