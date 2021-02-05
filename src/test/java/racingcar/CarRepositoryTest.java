package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryTest {

    @AfterEach
    void deleteAllCars() {
        CarRepository.deleteAll();
    }

    @DisplayName("1회 경주 - 모든 자동차들이 랜덤값에 따라 전진하거나 전진하지 않아야 한다.")
    @Test
    void allCarsGoForwardOrStop() {
        int numberOfCars = 1000;

        List<Car> cars = createCars(numberOfCars);
        CarRepository.saveAll(cars);

        List<Integer> randomNumbers = getRandomNumbers(numberOfCars);

        CarRepository.raceOneTime(randomNumbers);

        for (int i = 0; i < numberOfCars; i++) {
            assertGoForwardOrStop(cars.get(i), randomNumbers.get(i));
        }
    }

    private List<Car> createCars(int numberOfCars) {
        List<Car> createdCars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            createdCars.add(new Car(String.valueOf(i)));
        }
        return createdCars;
    }

    private List<Integer> getRandomNumbers(int numberOfRandomNumbersToGenerate) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfRandomNumbersToGenerate; i++) {
            randomNumbers.add(i);
        }
        return randomNumbers;
    }

    private void assertGoForwardOrStop(Car car, Integer randomNumber) {
        int minNumberToGoForward = 4;
        int positionAfterGoForward = 1;
        int positionAfterStop = 0;

        if (minNumberToGoForward <= randomNumber) {
            assertThat(car.getPosition()).isEqualTo(positionAfterGoForward);
            return;
        }
        assertThat(car.getPosition()).isEqualTo(positionAfterStop);
    }

    @DisplayName("우승자 결과 테스트 한 명")
    @Test
    void singleWinnerResult() {
        Car winner = new Car("111");
        Car loser = new Car("222");

        CarRepository.save(winner);
        CarRepository.save(loser);

        winner.goForward();

        List<Car> winners = CarRepository.getWinners();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo(winner);
    }

    @DisplayName("우승자 결과 테스트 여러명")
    @Test
    void multiWinnerResult() {
        List<Car> expectedWinners = new ArrayList<>();

        Car winner1 = new Car("111");
        Car winner2 = new Car("222");
        Car winner3 = new Car("333");
        Car loser = new Car("444");

        CarRepository.save(winner1);
        CarRepository.save(winner2);
        CarRepository.save(winner3);
        CarRepository.save(loser);

        winner1.goForward();
        winner2.goForward();
        winner3.goForward();

        expectedWinners.add(winner1);
        expectedWinners.add(winner2);
        expectedWinners.add(winner3);

        List<Car> actualWinners = CarRepository.getWinners();

        assertThat(actualWinners.size()).isEqualTo(3);
        assertThat(actualWinners.containsAll(expectedWinners)).isTrue();
    }
}
