package com.example.knapsack.configurations;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class AppConfig {

    @Value("${config-properties}")
    private String configValue;


    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getConfigValueByKey(String key,String child){
        JSONObject jsonObject = new JSONObject(configValue);
        JSONObject childObj = jsonObject.optJSONObject(key);
        return childObj.optString(child);
    }


}
