package com.example.knapsack.helper;

import com.example.knapsack.configurations.AppConfig;
import com.example.knapsack.constants.Constants;
import com.example.knapsack.pojo.Item;
import com.example.knapsack.pojo.RequestPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceHelper {

    @Autowired
    private AppConfig config;

    public List<Item> populateItemList(List<RequestPojo> reqList) {
        List<Item> itemList = new ArrayList<>();
        for (RequestPojo req : reqList) {
            String price = config.getConfigValueByKey(req.getName(), Constants.PRICE);
            String weight = config.getConfigValueByKey(req.getName(), Constants.WEIGHT);
            String fractional = config.getConfigValueByKey(req.getName(), Constants.FRACTIONAL);

            Item item = new Item(req.getName(),
                    Double.parseDouble(price),
                    Double.parseDouble(weight),
                    Boolean.parseBoolean(fractional),
                    req.getCount(),
                    Double.parseDouble(price) * req.getCount(),
                    Double.parseDouble(weight) * req.getCount(),
                    Double.parseDouble(price) / Double.parseDouble(weight));
            itemList.add(item);
        }
        return itemList;
    }
}
