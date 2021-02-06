package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @DisplayName("이름 길이 검증 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"똘이는강아지", "똘순이는똘복이", "", "여섯글자이름"})
    void 이름길이_검증_테스트(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name));
    }

    @DisplayName("주어진 숫자에 따라 자동차가 움직이는지 테스트")
    @ParameterizedTest
    @CsvSource({"2, false", "3,false", "4,true", "5,true"})
    void 자동차가_움직이는지(int given, boolean result) {
        Car car = new Car("TEST");
        car.move(given);

        assertThat(car.getPosition() == 1).isEqualTo(result);
    }
}
