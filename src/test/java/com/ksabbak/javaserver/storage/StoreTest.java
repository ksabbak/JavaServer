package com.ksabbak.javaserver.storage;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class StoreTest {
    private Store store;

    @Before
    public void setup(){
        store = new Store();
    }

    @Test
    public void createOnlyKeyNoConflictTest() {
        try {
            store.create("Hello");
            assertEquals("", store.read("Hello").get());
        } catch (KeyTakenException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void createOnlyKeyConflictTest() {
        try {
            store.create("Hello");
            store.create("Hello");
        } catch (KeyTakenException e) {
            assertTrue(true);
        }
    }

    @Test
    public void createKeyValueNoConflict() {
        try {
            store.create("Hello", "world");
            assertEquals("world", store.read("Hello").get());
        } catch (KeyTakenException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void createKeyValueConflict() {
        try {
            store.create("Hello", "world");
            store.create("Hello", "goodbye");
        } catch (KeyTakenException e) {
            assertTrue(true);
        }
    }

    @Test
    public void updateExistingTest() {
        try {
            store.create("Hello", "world");
            store.update("Hello", "goodbye");
            assertEquals("goodbye", store.read("Hello").get());
        } catch (KeyTakenException | KeyNotFoundException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void updateNothingTest() {
        try {
            store.update("Hello", "goodbye");
        } catch (KeyNotFoundException e) {
            assertTrue(true);
        }
    }

    @Test
    public void readExistingTest() {
        try {
            store.create("Hello", "world");
            assertEquals("world", store.read("Hello").get());
        } catch (KeyTakenException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void readNothingTest() {
           Optional<String> value =  store.read("Hello");
           assertFalse(value.isPresent());
    }

    @Test
    public void deleteExistingTest() {
        try {
            store.create("Hello", "world");
            store.delete("Hello");
            assertTrue(true);
        } catch (KeyTakenException | KeyNotFoundException e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    public void deleteNothingTest() {
        try {
            store.delete("Hello");
        } catch (KeyNotFoundException e) {
            assertTrue(true);
        }
    }
}