package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberTest {
    private RandomNumber randomNumber = new RandomNumber();

    @BeforeEach
    public void init() {
        randomNumber = new RandomNumber();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("랜덤으로 생성된 값이 범위 밖이면 예외 발생")
    void validateRandomNumberTest(int randomNo) {
        assertThatThrownBy(() -> {
            randomNumber.validateRandomNumber(randomNo);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"0, false", "3, false", "4, true", "9, true"})
    @DisplayName("전달된 값에 따라 움직일 수 있는지 확인")
    void canMoveTest(int randomNo, boolean status) {
        assertThat(RandomNumber.canMove(randomNo)).isEqualTo(status);
    }
}
