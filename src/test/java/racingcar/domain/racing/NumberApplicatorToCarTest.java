//package racingcar.domain.racing;
//
//
//import java.util.List;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import racingcar.domain.Car;
//import racingcar.domain.Cars;
//import racingcar.domain.racing.utils.CarsCreatorTestUtils;
//import racingcar.numbergenerator.FixedNumberGenerator;
//
//class NumberApplicatorToCarTest {
//    private final Cars cars = new Cars();
//
//    @DisplayName("생성된 정수가 4 이상일 때, 모든 자동차들이 한 칸 전진하고, 4 미만이면 전진하지 않는다.")
//    @ParameterizedTest
//    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
//    void applyGeneratedNumberToCar(String generatedFixedNumberStr, String expectedCarPositionStr) {
//        List<Car> cars = CarsCreatorTestUtils.createCarsSizeOf(10);
//        this.cars.saveAll(cars);
//
//        int generatedFixedNumber = Integer.parseInt(generatedFixedNumberStr);
//        int expectedCarPosition = Integer.parseInt(expectedCarPositionStr);
//
//        FixedNumberGenerator fixedNumberGenerator
//            = new FixedNumberGenerator(generatedFixedNumber);
//        NumberApplicatorToCar numberApplicatorToCar
//            = new NumberApplicatorToCar(this.cars, fixedNumberGenerator);
//
//        numberApplicatorToCar.apply();
//
//        assertAllCarsPosition(this.cars, expectedCarPosition);
//    }
//
//    private void assertAllCarsPosition(Cars carRepository, int expectedCarPosition) {
//        List<Car> allCars = carRepository.getAllCars();
//        Assertions.assertThat(
//            allCars.stream()
//                .allMatch(car -> car.getPosition() == expectedCarPosition)
//        ).isTrue();
//    }
//}