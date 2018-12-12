package de.meonwax.soundboard.sound;

import android.webkit.HttpAuthHandler;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SoundTest {
    private Sound example;

    @Before
    public void setUp() throws Exception{
        example = new Sound(10, "Bolero-Xzh", "C:\\music");
    }

    @Test
    public void Test_getId1() throws Exception{
        assertEquals(10, example.getId());
    }

    @Test
    public void Test_getId2() throws Exception{
        assertEquals(11, example.getId());
    }

    @Test
    public void Test_getName1() throws Exception{
        assertEquals("Bolero-Xzh", example.getName());
    }

    @Test
    public void Test_getName2() throws Exception{
        assertEquals("Bolero", example.getName());
    }

    @Test
    public void Test_getPath1() throws Exception{
        assertEquals("C:\\music", example.getPath());
    }

    @Test
    public void TestgetPath2() throws Exception{
        assertEquals("D:\\music", example.getPath());
    }

}