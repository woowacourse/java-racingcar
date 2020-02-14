package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {
    @Test
    void splitCarNames() {
        //given
        String inputNames = "123,324,456";
        Cars cars = new Cars(inputNames);
        List<String> expectedNameList = List.of("123", "324", "456");

        //when
        List<String> carNames = cars.getCars()
                .stream()
                .map(Car::toString)
                .collect(Collectors.toList());

        //then
        assertThat(carNames).isEqualTo(expectedNameList);
    }

    @ParameterizedTest
    @MethodSource("createCarsAndWinners")
    void getWinners(Cars cars, List<String> expectedWinners) {
        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(winners).isEqualTo(expectedWinners);
    }

    private static Stream<Arguments> createCarsAndWinners() {
        Name allen = new Name("앨런");
        Name lowoon = new Name("로운");
        Name pobi = new Name("포비");

        List<Car> testCars = List.of(new Car(allen, 3), new Car(lowoon, 2), new Car(pobi, 3));
        Cars cars = new Cars(testCars);

        return Stream.of(
                Arguments.of(cars, List.of(allen.toString(), pobi.toString()))
        );
    }

    @Test
    void validateCars(String inputNames, String message) {
        assertThatThrownBy(() -> {
            Cars cars = new Cars(inputNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 " + Cars.MINIMUM_TEAM + "명 이상이어야합니다.");
    }
}