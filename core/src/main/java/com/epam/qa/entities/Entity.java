package com.epam.qa.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public abstract class Entity {

    public Map<String, Object> toMap() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(this, mapper.constructType(new TypeToken<Map<String, Object>>(){}.getType()));
    }
}
