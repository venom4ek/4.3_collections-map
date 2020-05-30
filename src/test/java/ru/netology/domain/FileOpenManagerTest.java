package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileOpenManagerTest {
    private FileOpenManager openManager = new FileOpenManager();


    @BeforeEach
    void setUp() {
        openManager.save("jpeg", "photoshop");
        openManager.save("GIF", "photoshop");
        openManager.save("PNG", "photoshop");
        openManager.save("url", "chrome");
        openManager.save("mp4", "mpc-hc");
        openManager.save("mov", "mpc-hc");
        openManager.save("avi", "mpc-hc");
        openManager.save("mp3", "winamp");
        openManager.save("acc", "winamp");
        openManager.save("wav", "winamp");
    }

    @Test
    void test () {
        System.out.println(openManager.getAppsList());
    }
}