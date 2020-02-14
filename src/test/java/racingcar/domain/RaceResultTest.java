package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RaceResultTest {
    private RaceResult raceResult = new RaceResult();

    @Test
    void generateGage() {
        //given
        String name = "앨런";
        int numberOfGage = 3;
        Car car = new Car(new Name(name), numberOfGage);
        Cars cars = new Cars(List.of(car));
        String result = name + " : ---\n";

        //then
        assertThat(raceResult.getEachRaceResult(cars.getCars())).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("createWinners")
    void getWinnerNames(Cars cars, String winnerNames) {
        assertThat(raceResult.getWinnerNames(cars.getWinners())).isEqualTo(winnerNames);
    }

    private static Stream<Arguments> createWinners() {
        String firstWinner = "앨런";
        String secondWinner = "포비";
        String loser = "로운";

        int winnerPosition = 3;
        int loserPosition = 2;

        Car firstCar = new Car(new Name(firstWinner), winnerPosition);
        Car secondCar = new Car(new Name(secondWinner), winnerPosition);
        Car thirdCar = new Car(new Name(loser), loserPosition);

        Cars oneWinnerCars = new Cars(List.of(firstCar, thirdCar));
        Cars twoWinnerCars = new Cars(List.of(firstCar, secondCar, thirdCar));

        return Stream.of(
                Arguments.of(oneWinnerCars, firstWinner),
                Arguments.of(twoWinnerCars, String.join(RaceResult.COMMA, firstWinner, secondWinner))
        );
    }
}