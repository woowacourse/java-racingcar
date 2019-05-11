package util;

import domain.Const;
import org.junit.jupiter.api.Test;
import util.Util;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {
    @Test
    void getRandomNumber_난수_발생_범위에_있는지() {
        int randomNumber = Util.getRandomNumber();
        assertTrue(Const.ZERO <= randomNumber && randomNumber < Const.RANGE_RAN_NUM);
    }

    @Test
    void getRandomNumber_난수_발생_범위에_없는지() {
        int randomNumber = Util.getRandomNumber();
        assertFalse(Const.ZERO > randomNumber || randomNumber >= Const.RANGE_RAN_NUM);
    }
}