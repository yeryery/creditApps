package com.mycompany.app;

import java.util.*;

public class DataSet {
    private Map<String, Object> data = new LinkedHashMap<>();

    public void put(String columnName, Object value) {
        data.put(columnName, value);
    }

    public List<Object> getValues() {
        return new ArrayList<>(data.values());
    }

    public Set<String> getColumnNames() {
        return data.keySet();
    }

    public Object get(String columnName) {
        return data.get(columnName);
    }

    @Override
    public String toString() {
        return "{columnNames: " + getColumnNames() + ", " +
                "values: " + getValues() + "}";
    }
}
