package racing.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class RepeatNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void ZERO_보다_작음_체크() {

        RepeatNumber number = new RepeatNumber(0);
    }

    @Test
    public void 정수변환_체크() {
        RepeatNumber number = new RepeatNumber("3");

        assertEquals(3, number.getNumber());
    }
}
