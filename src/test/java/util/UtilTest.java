package util;

import domain.Const;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Util;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {
    private int randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = Util.getRandomNumber();
    }

    @Test
    void 난수_발생_성공_확인() {
        assertTrue(Const.ZERO <= randomNumber && randomNumber < Const.RANGE_RAN_NUM);
    }

    @Test
    void 난수_발생_실패_확인() {
        assertFalse(Const.ZERO > randomNumber || randomNumber >= Const.RANGE_RAN_NUM);
    }
}