package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    @DisplayName("중복되는 자동차 이름이 있을 경우 예외가 발생한다.")
    @Test
    void exceptionByDuplicate() {
        //given
        List<String> names = List.of("a", "a", "c");
        List<Car> cars = names.stream()
                .map(Car::new)
                .toList();

        //when //then
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @DisplayName("자동차별 현재 위치 정보를 반환한다.")
    @ParameterizedTest
    @MethodSource("carNameAndPosition")
    void getRoundResult(CarName carName, Position position) {
        //given
        List<Car> givenCars = List.of(
                new Car(carName.getName(), position.getPosition()),
                new Car("ted", 2)
        );
        Cars cars = new Cars(givenCars);

        //when
        RoundResult roundResult = cars.getRoundResult();
        Map<CarName, Position> result = roundResult.getResult();

        //then
        assertThat(result).hasSize(givenCars.size());
        assertThat(result.get(carName)).isEqualTo(position);
    }

    static Stream<Arguments> carNameAndPosition() {
        return Stream.of(
                Arguments.arguments(new CarName("daon"), new Position(1)),
                Arguments.arguments(new CarName("ikjo"), new Position(5)),
                Arguments.arguments(new CarName("lilly"), new Position(3))
        );
    }
}
