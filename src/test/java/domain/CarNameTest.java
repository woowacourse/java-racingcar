package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {
    @Test
    void carNameFailTest() {
        final String testCarName = "포포포포포비";
        assertThrows(IllegalArgumentException.class, () -> new CarName(testCarName));
    }

}