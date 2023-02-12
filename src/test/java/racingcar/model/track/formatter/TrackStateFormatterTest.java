package racingcar.model.track.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import racingcar.TestDataManager;
import racingcar.model.car.Cars;
import racingcar.model.car.formatter.CarPositionFormatter;
import racingcar.model.car.formatter.CarsPositionFormatter;

@TestInstance(Lifecycle.PER_CLASS)
class TrackStateFormatterTest {
    private TrackStateFormatter trackStateFormatter;
    @BeforeAll
    void setUp() {
        this.trackStateFormatter = new TrackStateFormatter(
                new CarsPositionFormatter(new CarPositionFormatter()));
    }

    @DisplayName("우승한 자동차 문구 출력 테스트")
    @Test
    void winnerCarsFormat() {
        //given
        Cars cars = TestDataManager.getCarsTestData();
        String expectedFormat = "pobi, eddy가 최종 우승했습니다.";

        //when
        cars.moveCars();
        String actual = trackStateFormatter.winnerCarsFormat(cars.getWinnerCars());

        //then
        assertThat(actual).isEqualTo(expectedFormat);
    }
}
