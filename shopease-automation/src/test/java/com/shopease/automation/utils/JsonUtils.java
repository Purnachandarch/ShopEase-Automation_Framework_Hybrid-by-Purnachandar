
package com.shopease.automation.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static Object[][] getJsonData(String filePath)
            throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        List<Map<String, Object>> testData =
                mapper.readValue(
                    new File(filePath),
                    new TypeReference<List<Map<String, Object>>>() {}
                );

        Object[][] data = new Object[testData.size()][3];

        for (int i = 0; i < testData.size(); i++) {

            Map<String, Object> record = testData.get(i);

            data[i][0] = record.get("email");
            data[i][1] = record.get("password");
            data[i][2] = record.get("expectedResult").toString();
        }

        return data;
    }
}
