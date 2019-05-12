package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    void 최초차이름들_입력형식_및_중복검사() {
        assertThrows(IllegalArgumentException.class, ()->{
           new Cars(",pobi,");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("pobi,");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("pobi,,coogie");
        });
        assertThrows(IllegalArgumentException.class, ()->{
            new Cars("abc,abc");
        });
    }
}