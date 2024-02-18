package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @DisplayName("중복되는 자동차 이름이 있을 경우 예외가 발생한다.")
    @Test
    void exceptionByDuplicate() {
        //given
        List<String> names = List.of("a", "a", "c");
        List<Car> cars = names.stream()
                .map(CarName::new)
                .map(Car::new)
                .toList();

        //when //then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @DisplayName("전진 후 자동차 별 현재 위치 정보를 반환한다.")
    @ParameterizedTest
    @MethodSource("carNames")
    void makeCarsMove(List<CarName> carNames) {
        //given
        int expected = carNames.size();
        Cars cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::new));

        //when
        RoundResult roundResult = cars.makeCarsMove(randomNumberGenerator);
        Map<CarName, Position> result = roundResult.getResult();

        //then
        assertThat(result).hasSize(expected);
    }

    static Stream<Arguments> carNames() {
        return Stream.of(
                Arguments.arguments(List.of(new CarName("1"), new CarName("2"), new CarName("3"))),
                Arguments.arguments(List.of(new CarName("1"), new CarName("2"))),
                Arguments.arguments(List.of(new CarName("1")))
        );
    }
}
