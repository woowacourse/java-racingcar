package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    @DisplayName("입력한 이름대로 올바르게 Car 리스트가 만들어지는지 확인")
    void setCarsTest() {
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        List<Car> expected = new ArrayList<>();
        expected.add(new Car("루트"));
        expected.add(new Car("소롱"));

        List<Car> actual = exceptionHandler.setCars("루트,소롱");

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}
