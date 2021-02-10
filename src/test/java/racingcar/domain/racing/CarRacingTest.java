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

class CarRacingTest {
    @DisplayName("생성자의 setCarsBeforeRacing(), getCars() 테스트")
    @Test
    void setCarsBeforeRacingInConstructorAndGetCars() {
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
        + "현재까지 완료된 경주 횟수 증가 (isEnd()로 검증) 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    void raceOneTimeAndIsEnd(String generatedNumberStr, String expectedPositionStr) {

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

    @DisplayName("생성된 숫자와 경주 시도 횟수에 따라 모든 자동차에 전진 혹은 정지 적용과,"
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

    @DisplayName("우승자 결정 - 우승자가 한 명일 때")
    @Test
    void getWinnersWhenSingleWinner() {
        List<String> carNames = CarsCreatorTestUtils.createCarNamesSizeOf(10);
        int racingTryTime = 5;

        CarRacingRequestDto carRacingRequestDto
            = new CarRacingRequestDto(carNames, racingTryTime);
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(6);

        CarRacing carRacing = new CarRacing(carRacingRequestDto, fixedNumberGenerator);
        List<Car> allCars = carRacing.getCars();

        Car winner = allCars.get(0);
        int goForwardNumber = 4;
        winner.goForwardDependsOnNumber(goForwardNumber);

        Assertions.assertThat(carRacing.getWinners().size()).isEqualTo(1);
        Assertions.assertThat(carRacing.getWinners().contains(winner)).isTrue();
    }

    @DisplayName("우승자 결정 - 우승자가 세 명일 때")
    @Test
    void getWinnersWhenMultiWinners() {
        List<String> carNames = CarsCreatorTestUtils.createCarNamesSizeOf(10);
        int racingTryTime = 5;

        CarRacingRequestDto carRacingRequestDto
            = new CarRacingRequestDto(carNames, racingTryTime);
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(6);

        CarRacing carRacing = new CarRacing(carRacingRequestDto, fixedNumberGenerator);
        List<Car> allCars = carRacing.getCars();

        Car winner1 = allCars.get(0);
        Car winner2 = allCars.get(3);
        Car winner3 = allCars.get(7);

        int goForwardNumber = 4;
        winner1.goForwardDependsOnNumber(goForwardNumber);
        winner2.goForwardDependsOnNumber(goForwardNumber);
        winner3.goForwardDependsOnNumber(goForwardNumber);

        Assertions.assertThat(carRacing.getWinners().size()).isEqualTo(3);
        Assertions.assertThat(carRacing.getWinners().contains(winner1)).isTrue();
        Assertions.assertThat(carRacing.getWinners().contains(winner2)).isTrue();
        Assertions.assertThat(carRacing.getWinners().contains(winner3)).isTrue();
    }

    private void assertAllCarsPosition(List<Car> allCars, int expectedCarPosition) {
        Assertions.assertThat(
            allCars.stream()
                .allMatch(car -> car.getPosition() == expectedCarPosition)
        ).isTrue();
    }
}