package racingcar.domain.racing;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.domain.numbergenerator.FixedNumberGenerator;
import racingcar.domain.racing.utils.CarsCreatorTestUtils;

class CarRacingTest {
    private final CarRepository carRepository = new CarRepository();

    @BeforeEach
    void saveCarsToCarRepository() {
        List<Car> cars = CarsCreatorTestUtils.createCars();
        carRepository.saveAll(cars);
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