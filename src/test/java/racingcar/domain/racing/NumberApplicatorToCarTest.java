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

class NumberApplicatorToCarTest {
    private final CarRepository carRepository = new CarRepository();

    @BeforeEach
    void saveCarsToCarRepository() {
        List<Car> cars = CarsCreatorTestUtils.createCars();
        carRepository.saveAll(cars);
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