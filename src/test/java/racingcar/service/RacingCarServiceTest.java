package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.dto.RacingCarNamesRequest;
import racingcar.dto.RacingCarStatusResponse;
import racingcar.dto.RacingCarWinnerResponse;

class RacingCarServiceTest {

    RacingCarService service;

    @BeforeEach
    void setUp() {
        service = new RacingCarService();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    @DisplayName("입력 값이 3 이하이면 자동차가 움직이면 안 된다.")
    void move_shouldNotMoveWhenNumberIsUnderThree(int input, int expected) {
        // given
        CustomMoveStrategy moveStrategy = new CustomMoveStrategy(input);
        service.createCars(RacingCarNamesRequest.of("car1"));
        service.moveCars(moveStrategy);

        // when
        List<RacingCarStatusResponse> carStatuses = service.getCarStatuses();

        // then
        assertThat(carStatuses.get(0).getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"car:1", "car1,car2:2", "car1,car2,car3:3"}, delimiter = ':')
    @DisplayName("자동차가 생성되어야 한다.")
    void car_create(String input, int expected) {
        // given
        service.createCars(RacingCarNamesRequest.of(input));

        // when
        List<RacingCarStatusResponse> carStatuses = service.getCarStatuses();

        // then
        assertThat(carStatuses.size()).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차의 정보가 정상적으로 반환되어야 한다.")
    void car_getStatues() {
        // given
        service.createCars(RacingCarNamesRequest.of("car1"));

        // when
        List<RacingCarStatusResponse> carStatuses = service.getCarStatuses();

        // then
        assertThat(carStatuses.get(0).getPosition()).isEqualTo(0);
        assertThat(carStatuses.get(0).getName()).isEqualTo("car1");
    }

    @Test
    @DisplayName("우승자의 이름이 정상적으로 반환되어야 한다.")
    void findWinners() {
        // given
        service.createCars(RacingCarNamesRequest.of("car1"));
        service.moveCars(new CustomMoveStrategy(5));

        // when
        service.createCars(RacingCarNamesRequest.of("car2"));

        // then
        RacingCarWinnerResponse winners = service.findWinners();
        assertThat(winners.getWinners().size())
                .isEqualTo(1);
        assertThat(winners.getWinners().get(0))
                .isEqualTo("car1");
    }
}