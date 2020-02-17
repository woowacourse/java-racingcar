package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    private RandomNumber randomNumber = new RandomNumber();

    @BeforeEach
    public void init() {
        randomNumber = new RandomNumber();
    }

    @ParameterizedTest
    @CsvSource({"0, false", "3, false", "4, true", "9, true"})
    @DisplayName("전달된 값에 따라 움직일 수 있는지 확인")
    void canMoveTest(int randomNo, boolean status) {
        assertThat(RandomNumber.canMove(randomNo)).isEqualTo(status);
    }
}
