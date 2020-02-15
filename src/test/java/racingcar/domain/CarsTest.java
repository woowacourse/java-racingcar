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
    static final String COMMA = ",";

    @Test
    void splitCarNames() {
        //given
        String inputNames = "123,324,456";
        Cars cars = new Cars(inputNames);
        List<String> expectedNameList = List.of("123", "324", "456");

        //when
        List<String> carNames = cars.getCars()
                .stream()
                .map(Car::getName)
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
        String allen = "앨런";
        String lowoon = "로운";
        String pobi = "포비";

        Cars cars = new Cars(String.join(COMMA, allen, lowoon, pobi));

        int winnerPosition = 3;
        int loserPosition = 2;

        Car allenCar = cars.getCars().get(0);
        Car lowoonCar = cars.getCars().get(1);
        Car pobiCar = cars.getCars().get(2);

        for (int i = 0; i < winnerPosition; i++) {
            allenCar.moveForward();
            pobiCar.moveForward();
        }

        for (int i = 0; i < loserPosition; i++) {
            lowoonCar.moveForward();
        }

        return Stream.of(
                Arguments.of(cars, List.of(allen, pobi))
        );
    }

    @Test
    void validateCars() {
        //given
        String inputNames = "앨런";

        //then
        assertThatThrownBy(() -> new Cars(inputNames))
        .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자는 " + Cars.MINIMUM_TEAM + "명 이상이어야합니다.");
    }
}