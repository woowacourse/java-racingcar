package model;

import org.junit.jupiter.api.Test;

import static model.LapCount.parseNaturalNumber;
import static org.junit.jupiter.api.Assertions.*;

class LapCountTest {
    @Test
    void 자연수_유무_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            parseNaturalNumber("A");
            parseNaturalNumber("0");
            parseNaturalNumber("-1");
        });
    }

    @Test
    void 자연수_범위_확인() {
        assertThrows(IllegalArgumentException.class, () -> {
            parseNaturalNumber(new Integer(Integer.MAX_VALUE).toString() + "0");
        });
    }
}