package com.example.knapsack.service.impl;

import com.example.knapsack.pojo.Item;
import com.example.knapsack.pojo.RequestPojo;
import com.example.knapsack.service.KnapsackAlgo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.knapsack.constants.Constants.LOG_REQ_PATTERN;

@Component
public class KnapsackImpl implements KnapsackAlgo {

    private static final Logger LOGGER = LoggerFactory.getLogger(KnapsackImpl.class);


    @Override
    public String getMaxProfitUsingGreedy(List<Item> itemsList, Integer playersCount) {
        String methodName = "getMaxProfitUsingGreedy";
        LOGGER.info(LOG_REQ_PATTERN, methodName, itemsList);
        List<RequestPojo> outputList = new ArrayList<>();

        int n = (playersCount <= 0) ? 1 : playersCount;
        double w = n * 100;  //knapsack
        Double maxProfit = 0.0;
        Collections.sort(itemsList);
        for (Item i : itemsList) {
            if (i.getWeightWi() <= w) {
                maxProfit = maxProfit + i.getCostPi();
                w = w - i.getWeightWi();
                outputList.add(new RequestPojo(i.getName(), i.getQty()));
            } else {
                Double fraction = w / i.getWeightWi();
                maxProfit = maxProfit + (fraction * i.getCostPi());
                w = 0;
                outputList.add(new RequestPojo(i.getName(), i.getQty() * fraction));
                break;
            }
        }
        StringBuilder stb = new StringBuilder();
        stb.append("Take the following items==>\n");
        for (RequestPojo resp : outputList) {
            stb.append(resp.getName()).append(" x ").append(resp.getCount()).append("\n");
        }
        stb.append("Max Profit ==>"+maxProfit);

        return stb.toString();
    }

}
