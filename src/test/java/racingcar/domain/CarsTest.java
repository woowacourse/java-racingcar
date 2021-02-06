package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {
    @DisplayName("우승자 가려내는지 테스트")
    @ParameterizedTest
    @MethodSource("provideRaceWinnerCases")
    void findWinners_우승자_올바르게_가려내는지(List<Car> racedCars, List<String> expectedWinnerNames) {
        Cars cars = new Cars(racedCars);
        Cars winnersDto = cars.findWinners();
        List<String> winnerNames = winnersDto
                .getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        assertThat(winnerNames).isEqualTo(expectedWinnerNames);
    }

    private static Stream<Arguments> provideRaceWinnerCases() {
        List<String> winnerNames1 = Arrays.asList("포비");
        List<String> winnerNames2 = Arrays.asList("웨지");
        List<String> winnerNames3 = Arrays.asList("포비", "웨지");
        List<String> winnerNames4 = Arrays.asList("포비", "웨지", "삭정");

        return Stream.of(
                Arguments.of(createRacedCars(winnerNames1), winnerNames1),
                Arguments.of(createRacedCars(winnerNames2), winnerNames2),
                Arguments.of(createRacedCars(winnerNames3), winnerNames3),
                Arguments.of(createRacedCars(winnerNames4), winnerNames4)
        );
    }

    private static List<Car> createRacedCars(List<String> winnerNames) {
        Car car1 = new Car("포비");
        Car car2 = new Car("웨지");
        Car car3 = new Car("삭정");
        List<Car> cars = Arrays.asList(car1, car2, car3);

        cars.stream()
                .filter(car -> winnerNames.contains(car.getName()))
                .forEach(car -> car.move(5));

        return cars;
    }
}