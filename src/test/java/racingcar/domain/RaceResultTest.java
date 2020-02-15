package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

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
        String allen = "앨런";
        String lowoon = "로운";
        int numberOfGage = 3;
        Cars cars = new Cars(String.join(CarsTest.COMMA, allen, lowoon));

        Car allenCar = cars.getCars().get(0);
        Car lowoonCar = cars.getCars().get(1);

        for (int i = 0; i < numberOfGage; i++) {
            allenCar.moveForward();
            lowoonCar.moveForward();
        }
        
        String result = allen + " : ---\n" + lowoon + " : ---\n";

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
        String lowoon = "로운";

        Cars oneWinnerCars = new Cars(String.join(CarsTest.COMMA, firstWinner, lowoon));
        Cars twoWinnerCars = new Cars(String.join(CarsTest.COMMA, firstWinner, lowoon, secondWinner));
        
        int winnerPosition = 3;
        int challengerPosition = 2;

        Car oneWinnerCar = oneWinnerCars.getCars().get(0);
        Car challengerCar = oneWinnerCars.getCars().get(1);

        Car firstWinnerCar = twoWinnerCars.getCars().get(0);
        Car lowoonCar = twoWinnerCars.getCars().get(1);
        Car secondWinnerCar = twoWinnerCars.getCars().get(2);
        

        for (int i = 0; i < winnerPosition; i++) {
            oneWinnerCar.moveForward();
            firstWinnerCar.moveForward();
            secondWinnerCar.moveForward();
        }

        for (int i = 0; i < challengerPosition; i++) {
            lowoonCar.moveForward();
            challengerCar.moveForward();
        }

        return Stream.of(
                Arguments.of(oneWinnerCars, firstWinner),
                Arguments.of(twoWinnerCars, String.join(RaceResult.COMMA, firstWinner, secondWinner))
        );
    }
}