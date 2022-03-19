package com.keyboardworks.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JsonUtil {

    private final ObjectMapper objectMapper;

    public String objectToString(Object source) {
        try {
            return objectMapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public <T> T stringToObject(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

}
