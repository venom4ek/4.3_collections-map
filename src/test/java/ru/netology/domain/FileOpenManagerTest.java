package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {
    private FileOpenManager openManager = new FileOpenManager();
    private String jpeg = "jpeg";
    private String gif = "GIF";
    private String mp4 = "mp4";
    private String mov = "mov";
    private String html = "html";
    private String chm = "chm";



    @BeforeEach
    void setUp() {
        openManager.save(jpeg, "photoshop");
        openManager.save(gif, "photoshop");
        openManager.save(mp4, "mpc-hc");
        openManager.save(mov, "mpc-hc");
        openManager.save(html, "chrome");
        openManager.save(chm, "chrome");
    }

    @Test
    void shouldGetApp() {
        assertEquals("mpc-hc", openManager.getApp(mp4));
    }

    @Test
    void shouldRemoveApp() {
        HashMap<String, String> expected = new HashMap<>();
        expected.put(jpeg, "photoshop");
        expected.put(gif.toLowerCase(), "photoshop");
        expected.put(mp4, "mpc-hc");
        expected.put(mov, "mpc-hc");
        expected.put(html, "chrome");
        openManager.removeApp(chm);
        assertEquals(expected, openManager.getAppsList());
    }

    @Test
    void shouldRegisteredApps() {
        openManager.clearApp(jpeg);
        openManager.clearApp(gif);
        openManager.clearApp(mp4);
        Map<String, String> expected = new HashMap<>();
        expected.put(mov, "mpc-hc");
        expected.put(chm, "chrome");
        expected.put(html, "chrome");
        Map<String, String> actual = openManager.getRegisteredApp();
        assertEquals(expected, actual);

    }

    @Test
    void shouldClearBindKey() {
        assertEquals("photoshop", openManager.clearApp(jpeg));
    }

    @Test
    void shouldClearBindKeyWithGetApp() {
        openManager.clearApp(jpeg);
        assertEquals(null, openManager.getApp(jpeg));
    }

    @Test
    void shouldRemoveNonExistKey() {
        assertEquals(null, openManager.clearApp("exe"));
    }

    @Test
    void shouldGetAllKeysSorted() {
        List<String> expected = new ArrayList<>();
        expected.addAll(List.of(chm, gif.toLowerCase(), html, jpeg, mov, mp4));
        List<String> actual = openManager.getAllKey();
        assertEquals(expected, actual);
    }

    @Test
    void shouldGetAllValuesSorted() {
        List<String> expected = new ArrayList<>();
        expected.addAll(List.of("chrome", "mpc-hc", "photoshop"));
        List<String> actual = openManager.getAllValue();
        assertEquals(expected, actual);
    }
}