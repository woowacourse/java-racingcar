package racingcar.domain.racing;


import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.domain.numbergenerator.FixedNumberGenerator;

class CarRacingTest {
    private final CarRepository carRepository = new CarRepository();
    private final int CARS_SIZE = 10;

    @BeforeEach
    void saveCarsToCarRepository() {
        List<String> carNames = createCarNames(CARS_SIZE);
        List<Car> cars = createCars(carNames);
        carRepository.saveAll(cars);
    }

    private List<String> createCarNames(int carSize) {
        List<String> carNames = new ArrayList<>();
        for (int i = 1; i <= carSize; i++) {
            carNames.add(String.valueOf(i));
        }
        return carNames;
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    @DisplayName("생성된 숫자와 자동차 경주 횟수에 따라 모든 자동차들이 예상한 값 만큼 전진 또는 정지 하는가?")
    @ParameterizedTest
    @CsvSource(value = {"1:5:0", "2:12:0", "4:5:5", "8:12:12"}, delimiter = ':')
    void doAllRaces(String generatedNumberStr, String racingTryTimeStr,
        String expectedFinalPositionStr) {
        int generatedNumber = Integer.parseInt(generatedNumberStr);
        int racingTryTime = Integer.parseInt(racingTryTimeStr);
        int expectedFinalPosition = Integer.parseInt(expectedFinalPositionStr);

        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(generatedNumber);
        CarRacing carRacing = new CarRacing(carRepository, fixedNumberGenerator);

        carRacing.doAllRaces(racingTryTime);

        assertAllCarsPositions(expectedFinalPosition);
    }

    private void assertAllCarsPositions(int expectedFinalPosition) {
        List<Car> allCars = carRepository.getAllCars();
        for (Car car : allCars) {
            Assertions.assertThat(car.getPosition()).isEqualTo(expectedFinalPosition);
        }
    }
}