package racingcar.domain.racing;


import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.domain.numbergenerator.FixedNumberGenerator;

class NumberApplicatorToCarTest {
    private final CarRepository carRepository = new CarRepository();
    private final int CARS_SIZE = 10;

    @BeforeEach
    void saveCarsToCarRepository() {
        List<String> carNames = createCarNames(CARS_SIZE);
        List<Car> cars = createCars(carNames);
        carRepository.saveAll(cars);
    }

    @AfterEach
    void deleteAllCars() {
        carRepository.deleteAll();
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

    @DisplayName("생성된 정수가 4 이상일 때, 모든 자동차들이 한 칸 전진하고, 4 미만이면 전진하지 않는다.")
    @ParameterizedTest
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    void applyGeneratedNumberToCar(String generatedFixedNumberStr, String expectedCarPositionStr) {
        int generatedFixedNumber = Integer.parseInt(generatedFixedNumberStr);
        int expectedCarPosition = Integer.parseInt(expectedCarPositionStr);

        FixedNumberGenerator fixedNumberGenerator
            = new FixedNumberGenerator(generatedFixedNumber);
        NumberApplicatorToCar numberApplicatorToCar
            = new NumberApplicatorToCar(carRepository, fixedNumberGenerator);

        numberApplicatorToCar.apply();

        assertAllCarsPosition(expectedCarPosition);
    }

    private void assertAllCarsPosition(int expectedCarPosition) {
        List<Car> allCars = carRepository.getAllCars();
        for (Car car : allCars) {
            Assertions.assertThat(car.getPosition()).isEqualTo(expectedCarPosition);
        }
    }
}