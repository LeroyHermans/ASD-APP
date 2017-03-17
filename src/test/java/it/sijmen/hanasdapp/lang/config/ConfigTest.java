package it.sijmen.hanasdapp.lang.config;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 17-3-2017.
 */
public class ConfigTest {

    @Test
    public void testLoadFromResource() throws Exception {
        Config config = new Config();
        config.loadFromResource("example.config");

        HashMap<String, Object> expected = new HashMap<>();
        expected.put("naam", "sijmen");
        expected.put("leeftijd", 20);
        expected.put("rol", "student");

        assertEquals(expected, config.getProps());
    }
}