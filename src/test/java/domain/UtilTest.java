package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {
    @Test
    void 난수_발생() {
        int randomNumber = Util.getRandomNumber();
        assertTrue(Const.ZERO <= randomNumber && randomNumber < Const.RANGE_RAN_NUM);
        assertFalse(Const.ZERO > randomNumber || randomNumber >= Const.RANGE_RAN_NUM);
    }
}