package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {
    @Test
    void 차이름_검사() {
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("a bcd");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("a1bcd");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("abcdef");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("!bcd");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName(" asd");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new CarName("asd ");
        });
    }
}