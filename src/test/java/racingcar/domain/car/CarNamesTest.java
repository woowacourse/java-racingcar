package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNamesTest {

    @Test
    @DisplayName("이름들을 받아서 CarNames 생성")
    void createTest() {
        CarNames carNames = CarNames.create("pobi,jason,java");
    }
}