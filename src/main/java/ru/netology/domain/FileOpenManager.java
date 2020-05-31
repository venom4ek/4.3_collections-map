package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor

public class FileOpenManager {
    private Map<String, String> appsList = new HashMap<>();

    public void save(String ext, String app) {
        appsList.put(ext.toLowerCase(), app.toLowerCase());
    }

    public Map<String, String> getAppsList() {
        return appsList;
    }

    public String getApp(String ext) {
        return appsList.get(ext.toLowerCase());
    }

    public String clearApp(String ext) {
        return appsList.replace(ext.toLowerCase(), null);
    }

    public void removeApp(String ext) {
        appsList.remove(ext);
    }

    public Map<String,String> getRegisteredApp() {
        Map<String,String> result = new HashMap<>();
        for (Map.Entry<String,String> temp : appsList.entrySet()) {
            if (temp.getValue() != null) {
                result.put(temp.getKey(), temp.getValue());
            }
        }
        return result;
    }

    public List<String> getAllKey() {
        Set<String> app = new HashSet<>();
        app.addAll(appsList.keySet());
        ArrayList<String> list = new ArrayList<>(app);
        list.sort(Comparator.naturalOrder());
        return list;
    }

    public List<String> getAllValue() {
        Set<String> app = new HashSet<>();
        app.addAll(appsList.values());
        ArrayList<String> list = new ArrayList<>(app);
        list.sort(Comparator.naturalOrder());
        return list;
    }

}