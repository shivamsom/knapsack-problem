package com.example.knapsack.controller;

import com.example.knapsack.helper.ServiceHelper;
import com.example.knapsack.pojo.Item;
import com.example.knapsack.pojo.RequestPojo;
import com.example.knapsack.pojo.ResponsePojo;
import com.example.knapsack.service.KnapsackAlgo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    private KnapsackAlgo knapsack;

    @Autowired
    private ServiceHelper helper;

    @PostMapping("/knapsack")
    public ResponsePojo getKnapsackResult(@RequestBody List<RequestPojo>reqList,
                                          @RequestParam("players")Integer players){

        List<Item> itemList = helper.populateItemList(reqList);
        return knapsack.getMaxProfitUsingGreedy(itemList,players);
    }

}
