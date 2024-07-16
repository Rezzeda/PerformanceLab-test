package main.java;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestReportGenerator {

    public void generateReport(String valuesFilePath, String testsFilePath, String reportFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // чтение values.json
        Map<Integer, String> valuesMap = new HashMap<>();
        Map<String, List<Map<String, Object>>> valuesJson = mapper.readValue(new File(valuesFilePath), new TypeReference<>() {});
        List<Map<String, Object>> valuesList = valuesJson.get("values");
        for (Map<String, Object> valueEntry : valuesList) {
            valuesMap.put((Integer) valueEntry.get("id"), (String) valueEntry.get("value"));
        }

        // чтение tests.json
        Map<String, List<TestNode>> testsJson = mapper.readValue(new File(testsFilePath), new TypeReference<>() {});
        List<TestNode> testsList = testsJson.get("tests");

        // заполнение значений в tests.json
        fillValues(testsList, valuesMap);

        // создание результирующей структуры для записи
        Map<String, List<TestNode>> result = new HashMap<>();
        result.put("tests", testsList);

        // запись в report.json
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(reportFilePath), result);
    }

    private void fillValues(List<TestNode> nodes, Map<Integer, String> valuesMap) {
        for (TestNode node : nodes) {
            if (valuesMap.containsKey(node.getId())) {
                node.setValue(valuesMap.get(node.getId()));
            }
            if (node.getValues() != null) {
                fillValues(node.getValues(), valuesMap);
            }
        }
    }
}