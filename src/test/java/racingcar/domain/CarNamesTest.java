package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNamesTest {

    CarNames carNames;

    @BeforeEach
    void setUp() {
        carNames = new CarNames();
    }

    @Test
    void 글자수가_1미만일때_테스트() {
        assertThrows(IllegalArgumentException.class, () ->{
            carNames.minimumCarNameException("abc,,,def".split(","));
        });
    }

    @Test
    void 글자수_5자초과() {
        assertThrows(IllegalArgumentException.class, () ->{
            carNames.maximumCarNameException("a,b,c,dwerwersdf".split(","));
        });
    }

    @Test
    void 연속된쉼표_입력시_올바른_예외인지_테스트() {
        try {
            CarNames carNames = new CarNames("pobi,,,crong");
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Test
    void 중복된_이름이_존재할때_테스트() {
        assertThrows(IllegalArgumentException.class, () ->{
            carNames.duplicateNameException(Arrays.asList("pobi", "pobi"));
        });
    }
}
