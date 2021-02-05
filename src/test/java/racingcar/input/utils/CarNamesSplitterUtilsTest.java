package racingcar.input.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNamesSplitterUtilsTest {

    @DisplayName("자동차 이름이 쉼표(,)를 기준으로 구분되는가?")
    @Test
    void splitCarNames() {
        String carNamesInput = "aaa,bbb,ccc";
        List<String> splitCarNames = CarNamesSplitterUtils.splitCarNames(carNamesInput);
        assertEquals("aaa", splitCarNames.get(0));
        assertEquals("bbb", splitCarNames.get(1));
        assertEquals("ccc", splitCarNames.get(2));
    }
}
