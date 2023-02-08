package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.dto.RacingCarNamesRequest;
import racingcar.dto.RacingCarStatusResponse;

class RacingCarServiceTest {

    RacingCarService service;

    @BeforeEach
    void setUp() {
        service = new RacingCarService(new RandomMoveStrategy());
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    @DisplayName("입력 값이 3 이하이면 자동차가 움직이면 안 된다.")
    void move_shouldNotMoveWhenNumberIsUnderThree(int input, int expected) {
        // given
        service = new RacingCarService(new CustomMoveStrategy(input));
        service.createCars(RacingCarNamesRequest.of("car1"));
        service.moveCars();

        // when
        List<RacingCarStatusResponse> carStatuses = service.getCarStatuses();

        // then
        assertThat(carStatuses.get(0).getPosition()).isEqualTo(expected);
    }
}