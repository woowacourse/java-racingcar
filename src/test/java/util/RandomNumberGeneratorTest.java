package util;

import model.manager.ThresholdCarMoveManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("랜덤 값이 0 이상 9 이하로 생성되는지 테스트한다.")
    void randomNumberTest() {
        int number = RandomNumberGenerator.getRandomNumber();
        assertThatCode(() -> RandomNumberValidator.validate(number))
                .doesNotThrowAnyException();
    }

}
