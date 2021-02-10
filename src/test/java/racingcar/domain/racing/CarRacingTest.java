package racingcar.domain.racing;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.domain.racing.utils.CarsCreatorTestUtils;
import racingcar.dto.CarRacingRequestDto;
import racingcar.numbergenerator.FixedNumberGenerator;

class CarRacingTest {
    @DisplayName("생성된 숫자와 자동차 경주 횟수에 따라 모든 자동차들이 예상한 값 만큼 전진 또는 정지 하는가?")
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