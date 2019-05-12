package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNamesTest {

    CarNames carNames;

    @BeforeEach
    void setUp() {
        carNames = new CarNames();
    }

    @Test
    void create() {
        assertThat(new CarNames()).isEqualTo(new CarNames());
    }

    @Test
    void 글자수_5자초과() {
        assertThrows(IllegalArgumentException.class, () ->{
            new CarNames("a,b,c,dwerwersdf");
        });
    }

    @Test
    void 중복된_이름이_존재할때() {
        assertThrows(IllegalArgumentException.class, () ->{
            new CarNames("pobi,pobi");
        });
    }

    @Test
    void 글자수가_1미만일때() {
        assertThrows(IllegalArgumentException.class, () ->{
            new CarNames("a,b,c,,,d,e,f");
        });
    }
}
