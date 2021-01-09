package com.example.knapsack.service;

import com.example.knapsack.pojo.Item;

import java.util.List;

public interface KnapsackAlgo {

    String getMaxProfitUsingGreedy(List<Item> itemCountList, Integer players);
}
