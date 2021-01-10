package com.example.knapsack.service;

import com.example.knapsack.pojo.Item;
import com.example.knapsack.pojo.ResponsePojo;

import java.util.List;

public interface KnapsackAlgo {

    ResponsePojo getMaxProfitUsingGreedy(List<Item> itemCountList, Integer players);
}
