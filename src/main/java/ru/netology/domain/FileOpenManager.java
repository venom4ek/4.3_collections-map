package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor

public class FileOpenManager {
    HashMap appsList = new HashMap<>();

    public void save(String ext, String app) {
        appsList.put(ext.toLowerCase(), app.toLowerCase());
    }

    public HashMap<String, String> getAppsList() {
        return appsList;
    }

    public Object getApp(String ext) {
        return appsList.get(ext.toLowerCase());
    }

    public Object clearApp(String ext) {
        return appsList.replace(ext.toLowerCase(), null);
    }

    public void removeApp(String ext) {
        appsList.remove(ext);
    }

    public List getRegisteredApp() {
        Set<Map.Entry<String, String>> set;
        List result = new ArrayList();
        set = appsList.entrySet();
        for (Map.Entry<String, String> temp : set) {
            if (temp.getValue() != null) {
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileOpenManager that = (FileOpenManager) o;
        return Objects.equals(appsList, that.appsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appsList);
    }
}