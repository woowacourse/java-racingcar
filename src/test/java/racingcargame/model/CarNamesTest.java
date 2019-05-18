package racingcargame.model;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CarNamesTest {
    @Test
    void 이름입력값이_배열로_전달되는지_테스트() {
        String input = "a,b,c";
        List<String> checker = Arrays.asList("a", "b", "c");
        assertThat(CarNames.makeCarNames(input)).isEqualTo(checker);
    }

    @Test
    void 널일때예외처리되는지테스트() {
        assertThrows(IllegalArgumentException.class, ()->
                CarNames.makeCarNames(null));
    }

    @Test
    void 엠티쓰트링일때테스트() {
        assertThrows(IllegalArgumentException.class, ()->
                CarNames.makeCarNames(""));
    }

    @Test
    void 중복하는_이름이_존재할때_예외테스트() {
        assertThrows(IllegalArgumentException.class, ()->
                CarNames.makeCarNames("a,a,b"));
    }

    @Test
    void 이름에_빈칸이_있을때_예외테스트() {
        assertThrows(IllegalArgumentException.class, ()->
                CarNames.makeCarNames("a,,,b"));
    }

    @Test
    void 이름의길이가적합하지않을때() {
        assertThrows(IllegalArgumentException.class, ()->
                CarNames.makeCarNames("a,b,aadsfsdfsadfadf"));
        assertThrows(IllegalArgumentException.class, ()->
                CarNames.makeCarNames("a,,b"));
    }

}
