package racingcar.service;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.RacingCarNamesRequest;
import racingcar.dto.RacingCarStatusResponse;
import racingcar.dto.RacingCarWinnerResponse;
import racingcar.repository.CarRepository;

class RacingCarServiceTest {
    private static final CustomMoveStrategy MOVE_STRATEGY = new CustomMoveStrategy(5);

    private RacingCarService service;

    @BeforeEach
    void setUp() {
        service = new RacingCarService(new CarRepository());
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, Integer.MAX_VALUE})
    @DisplayName("입력 값이 4 이상이면 자동차가 움직여야 한다.")
    void moveCars_shouldMoveInputMoreThan4(int input) {
        // given
        CustomMoveStrategy moveStrategy = new CustomMoveStrategy(input);
        service.createCars(RacingCarNamesRequest.of("car1"));
        service.moveCars(moveStrategy);

        // when
        List<RacingCarStatusResponse> carStatuses = service.getCarStatuses();

        // then
        assertThat(carStatuses.get(0).getPosition())
                .isGreaterThan(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1, 0, -1, Integer.MIN_VALUE})
    @DisplayName("입력 값이 4 미만이면 자동차가 움직이면 안된다.")
    void moveCars_shouldNotMoveInputUnder4(int input) {
        // given
        CustomMoveStrategy moveStrategy = new CustomMoveStrategy(input);
        service.createCars(RacingCarNamesRequest.of("car1"));
        service.moveCars(moveStrategy);

        // when
        List<RacingCarStatusResponse> carStatuses = service.getCarStatuses();

        // then
        assertThat(carStatuses.get(0).getPosition())
                .isEqualTo(0);
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
        assertThat(carStatuses)
                .hasSize(expected);
    }

    @Test
    @DisplayName("자동차의 정보가 정상적으로 반환되어야 한다.")
    void car_getStatues() {
        // given
        service.createCars(RacingCarNamesRequest.of("car1"));

        // when
        List<RacingCarStatusResponse> carStatuses = service.getCarStatuses();

        // then
        assertThat(carStatuses.get(0).getPosition())
                .isEqualTo(0);
        assertThat(carStatuses.get(0).getName())
                .isEqualTo("car1");
    }

    @Test
    @DisplayName("우승자의 이름이 정상적으로 반환되어야 한다.")
    void findWinners() {
        // given
        service.createCars(RacingCarNamesRequest.of("car1"));
        service.moveCars(MOVE_STRATEGY);

        // when
        service.createCars(RacingCarNamesRequest.of("car2"));

        // then
        RacingCarWinnerResponse winners = service.findWinners();
        assertThat(winners.getWinners())
                .hasSize(1);
        assertThat(winners.getWinners().get(0))
                .isEqualTo("car1");
    }

    @Test
    @DisplayName("자동차를 생성하지 않고 우승자를 찾으면 예외가 발생해야 한다.")
    void findWinners_emptyCars() {
        // expect
        assertThatThrownBy(() -> service.findWinners())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("자동차를 생성하지 않고 자동차의 상태를 가져오면 비어있어야 한다.")
    void getCarStatuses_empty() {
        // given
        List<RacingCarStatusResponse> carStatuses = service.getCarStatuses();

        // expected
        assertThat(carStatuses)
                .isEmpty();
    }

    @Test
    @DisplayName("자동차를 생성하지 않고 자동차를 움직이면 예외가 발생해야 한다.")
    void moveCars_empty() {
        // expect
        assertThatThrownBy(() -> service.moveCars(MOVE_STRATEGY))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(EMPTY_CARS.getMessage());
    }
}
