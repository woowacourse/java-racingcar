package racingcar.domain.racing;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.racing.utils.CarsCreatorTestUtils;
import racingcar.dto.CarRacingRequestDto;
import racingcar.numbergenerator.FixedNumberGenerator;
import racingcar.numbergenerator.NumberGenerator;

class CarRacingTest {
    @DisplayName("생성자의 setCarsBeforeRacing() 테스트")
    @Test
    void setCarsBeforeRacingInConstructor() {
        List<String> carNames = CarsCreatorTestUtils.createCarNamesSizeOf(10);
        int racingTryTime = 5;
        CarRacingRequestDto carRacingRequestDto
            = new CarRacingRequestDto(carNames, racingTryTime);
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(6);
        CarRacing carRacing = new CarRacing(carRacingRequestDto, fixedNumberGenerator);
        List<Car> allCars = carRacing.getCars();
        Assertions.assertThat(
            allCars.stream()
                .allMatch(car -> carNames.contains(car.getName()))
        ).isTrue();
    }

    @DisplayName("raceOneTime() 실행 시,"
        + "생성된 숫자에 따라 모든 자동차에 전진 혹은 정지 적용과,"
        + "현재까지 완료된 경주 횟수 증가 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    void raceOneTime(String generatedNumberStr, String expectedPositionStr) {

        int generatedNumber = Integer.parseInt(generatedNumberStr);
        int expectedPosition = Integer.parseInt(expectedPositionStr);

        List<String> carNames = CarsCreatorTestUtils.createCarNamesSizeOf(10);
        final int racingTryTime = 1;
        CarRacingRequestDto carRacingRequestDto
            = new CarRacingRequestDto(carNames, racingTryTime);

        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(generatedNumber);
        CarRacing carRacing = new CarRacing(carRacingRequestDto, fixedNumberGenerator);

        carRacing.raceOneTime();

        assertAllCarsPosition(carRacing.getCars(), expectedPosition);
        Assertions.assertThat(carRacing.isEnd()).isTrue();
    }

    @DisplayName("raceOneTime() 실행 시,"
        + "생성된 숫자에 따라 모든 자동차에 전진 혹은 정지 적용과,"
        + "현재까지 완료된 경주 횟수 증가 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:5:0", "2:12:0", "4:5:5", "8:12:12"}, delimiter = ':')
    void doAllRaces(String generatedNumberStr, String racingTryTimeStr,
        String expectedFinalPositionStr) {

        int generatedNumber = Integer.parseInt(generatedNumberStr);
        int racingTryTime = Integer.parseInt(racingTryTimeStr);
        int expectedFinalPosition = Integer.parseInt(expectedFinalPositionStr);

        List<String> carNames = CarsCreatorTestUtils.createCarNamesSizeOf(10);
        CarRacingRequestDto carRacingRequestDto
            = new CarRacingRequestDto(carNames, racingTryTime);

        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(generatedNumber);
        CarRacing carRacing = new CarRacing(carRacingRequestDto, fixedNumberGenerator);

        while (!carRacing.isEnd()) {
            carRacing.raceOneTime();
        }

        assertAllCarsPosition(carRacing.getCars(), expectedFinalPosition);
    }

    private void assertAllCarsPosition(List<Car> allCars, int expectedCarPosition) {
        Assertions.assertThat(
            allCars.stream()
                .allMatch(car -> car.getPosition() == expectedCarPosition)
        ).isTrue();
    }
}