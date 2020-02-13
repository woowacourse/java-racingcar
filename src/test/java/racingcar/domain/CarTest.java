package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("자동차 객체 테스트")
public class CarTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/racingtestcase/illegalCarNameTestcase.csv")
    @DisplayName("잘못된 이름으로 객체생성을 시도할 때 테스트")
    void illegalCarNameTest(String illegalName) {
        assertThatThrownBy(() -> new Car(illegalName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하의 비어있지 않은 이름이어야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("provideNumAndDistance")
    @DisplayName("move가 숫자 값에 대해서 적절하게 작동하는지 테스트")
    void moveTest(int input, int expectedDistance) {
        Car testCar = new Car("test");
        testCar.move(input);
        assertThat(testCar.getDistance()).isEqualTo(expectedDistance);

    }

    private static Stream<Arguments> provideNumAndDistance() {
        return Stream.of(
                Arguments.of(0,0),
                Arguments.of(1,0),
                Arguments.of(2,0),
                Arguments.of(3,0),
                Arguments.of(4,1),
                Arguments.of(5,1),
                Arguments.of(6,1),
                Arguments.of(7,1),
                Arguments.of(8,1),
                Arguments.of(9,1)
        );
    }
}



