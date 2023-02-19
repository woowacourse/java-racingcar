package racingcar.domain.carfactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.cars.Cars;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        carFactory = new CarFactory();
    }

    @ParameterizedTest
    @MethodSource("getCarNames")
    @DisplayName("createCars 메소드에 자동차 이름 배열을 입력하였을 때, Cars 객체를 생성하는지 확인")
    void createCars_test(final List<String> carNames) {
        Cars cars = carFactory.createCars(carNames);

        assertThat(cars).isInstanceOf(Cars.class);
    }

    static Stream<Arguments> getCarNames() {
        return Stream.of(
                Arguments.arguments(List.of("poy", "joy", "kane"))
        );
    }
}
