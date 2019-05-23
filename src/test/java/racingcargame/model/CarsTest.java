package racingcargame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    @Test
    void 이름이_없을때_테스트() {
        assertThrows(IllegalArgumentException.class, ()->
                new Cars(""));
    }

    @Test
    void 중복하는_이름이_존재할때_예외테스트() {
        assertThrows(IllegalArgumentException.class, ()->
                new Cars("a,a,b"));
    }

    @Test
    void 이름에_빈칸이_있을때_예외테스트() {
        assertThrows(IllegalArgumentException.class, ()->
                new Cars("a,,,b"));
    }

    @Test
    void 이름의길이가적합하지않을때() {
        assertThrows(IllegalArgumentException.class, ()->
                new Cars("a,b,aadsfsdfsadfadf"));
    }



}
