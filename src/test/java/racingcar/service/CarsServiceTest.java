package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.dto.CarStatusDto;
import racingcar.mock.MockNumberGenerator;
import racingcar.provider.TestProvider;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.domain.constant.CarConstant.INIT_POSITION;

class CarsServiceTest {

    private Cars testCars;

    private String testCarNames;

    private CarsService carsService;

    private MockNumberGenerator numberGenerator;

    @BeforeEach
    void init() {
        carsService = new CarsService();
        testCarNames = "pobi,crong,honux";
        numberGenerator = TestProvider.createMockNumberGenerator(false);
        testCars = TestProvider.createTestCars(testCarNames, numberGenerator);
    }

    @Test
    @DisplayName("사용자가 입력한 자동차의 이름만큼 자동차 리스트를 생성해야 한다.")
    void givenCarNames_thenReturnCars() {
        // when
        Cars carInfo = carsService.createCars(testCarNames, numberGenerator);
        List<Car> cars = carInfo.getCars();

        // then
        assertThat(cars.size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("모든 자동차의 초기 위치는 1이어야 한다.")
    void givenCars_whenInit_thenPositionIsOne() {
        // when
        int carCount = testCars.getCars().size();
        List<CarStatusDto> initStatus = carsService.getCarStatus(testCars);

        // then
        int normalPositionCarCount = (int) initStatus.stream()
                .filter(carRaceDto -> carRaceDto.getCarPosition() == INIT_POSITION.getValue())
                .count();

        assertThat(normalPositionCarCount)
                .isEqualTo(carCount);
    }

    @Test
    @DisplayName("우승한 자동차를 뽑는다.")
    void givenCarInfo_thenPickWinner() {
        // given
        MockNumberGenerator numberGenerator = TestProvider.createMockNumberGenerator(true);
        Cars testCars = TestProvider.createTestCars(testCarNames, numberGenerator);
        testCars.race();

        // when
        List<String> winners = carsService.pickWinnerNames(testCars);

        // then
        assertThat(winners.size())
                .isEqualTo(1);

        assertThat(winners)
                .isEqualTo(List.of("honux"));
    }

    @Test
    @DisplayName("우승한 자동차 리스트를 뽑는다.")
    void givenCarInfo_thenPickWinners() {
        // when
        testCars.race();
        List<String> winners = carsService.pickWinnerNames(testCars);

        // then
        assertThat(winners)
                .isEqualTo(List.of("pobi", "crong", "honux"));
    }
}