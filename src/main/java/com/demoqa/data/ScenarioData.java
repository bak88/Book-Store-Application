package com.demoqa.data;

import lombok.*;

@Data
public class ScenarioData {

    private static final ScenarioData INSTANCE = new ScenarioData();
    private String userName;
    private String password;

    public static ScenarioData getInstance() {
        return INSTANCE;
    }
}
