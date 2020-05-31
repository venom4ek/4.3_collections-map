package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileOpenManagerTest {
    private FileOpenManager openManager = new FileOpenManager();


    @BeforeEach
    void setUp() {
        openManager.save("jpeg", "photoshop");
        openManager.save("GIF", "photoshop");
        openManager.save("mp4", "mpc-hc");
        openManager.save("mov", "mpc-hc");
        openManager.save("html", "chrome");
        openManager.save("chm", "chrome");
    }

    @Test
    void test() {
        HashMap<String, String> expected = new HashMap<>();
        expected.put("jpeg", "photoshop");
        expected.put("gif", "photoshop");
        expected.put("mp4", "mpc-hc");
        expected.put("mov", "mpc-hc");
        expected.put("html", "chrome");
        openManager.removeApp("chm");
        assertEquals(expected, openManager.getAppsList());
    }

    @Test
    void shouldRegisteredApps() {
        openManager.clearApp("jpeg");
        openManager.clearApp("gif");
        openManager.clearApp("mp4");
        List<String> expected = new ArrayList<>();
        expected.addAll(List.of("mov=mpc-hc", "chm=chrome", "html=chrome"));
        List<String> actual = openManager.getRegisteredApp();
        assertEquals(expected, actual);

    }

    @Test
    void shouldClearBindKey() {
        assertEquals("photoshop", openManager.clearApp("jpeg"));
    }

    @Test
    void shouldClearBindKeyWithGetApp() {
        openManager.clearApp("jpeg");
        assertEquals(null, openManager.getApp("jpeg"));
    }

    @Test
    void shouldRemoveNonExistKey() {
        assertEquals(null, openManager.clearApp("exe"));
    }
}