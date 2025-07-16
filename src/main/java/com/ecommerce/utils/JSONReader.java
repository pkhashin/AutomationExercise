package com.ecommerce.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class JsonReader {
    public static Map<String, String> readJsonFile(String filepath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filepath),new TypeReference<Map<String, String>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to read test data", e);
        }

    }

    }

