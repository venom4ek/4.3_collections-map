package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor

public class FileOpenManager {
    HashMap appsList = new HashMap<>();

    public void save(String ext, String app) {
        appsList.put(ext, app);
    }

    public HashMap<String, String> getAppsList() {
        return appsList;
    }
}