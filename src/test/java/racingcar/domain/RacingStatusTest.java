package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingStatusDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingStatusTest {
    private MockRandomPicker mockRandomPicker;
    private RacingStatus racingStatus;

    @BeforeEach
    void setUp() {
        mockRandomPicker = new MockRandomPicker();
        racingStatus = new RacingStatus("judy,nunu,pobi", mockRandomPicker);
    }

    @Test
    void move_함수를_호출했을때_진행이_되는_것을_확인() {
        racingStatus.moveCars();

        List<RacingStatusDto> racingStatusDtos = racingStatus.toDto();
        assertThat(racingStatusDtos.get(0).getStatus()).isEqualTo(1);
        assertThat(racingStatusDtos.get(0).getCarName()).isEqualTo("judy");

        assertThat(racingStatusDtos.get(1).getStatus()).isZero();
        assertThat(racingStatusDtos.get(1).getCarName()).isEqualTo("nunu");

        assertThat(racingStatusDtos.get(2).getStatus()).isEqualTo(1);
        assertThat(racingStatusDtos.get(2).getCarName()).isEqualTo("pobi");

    }

    @Test
    void findWinner_함수로_우승자들이_반환됨() {
        racingStatus.moveCars();
        assertThat(racingStatus.findWinner()).containsExactly("judy", "pobi");

        racingStatus.moveCars();
        assertThat(racingStatus.findWinner()).containsExactly("judy", "nunu", "pobi");

    }
}
