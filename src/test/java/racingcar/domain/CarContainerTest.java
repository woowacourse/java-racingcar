package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPositionDto;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarContainerTest {

    private MockRandomPicker mockRandomPicker;
    private CarContainer carContainer;

    @BeforeEach
    void setUp() {
        mockRandomPicker = new MockRandomPicker(List.of(4, 3, 4, 3, 4, 3, 4, 3, 4, 3, 4, 3, 4, 3, 4, 3));
        carContainer = new CarContainer("judy,nunu,pobi", mockRandomPicker);
    }

    @Test
    void move_함수를_호출했을때_진행이_되는_것을_확인() {
        carContainer.moveCars();

        List<CarPositionDto> carPositionDtos = carContainer.toDto();
        assertThat(carPositionDtos.get(0).getStatus()).isEqualTo(1);
        assertThat(carPositionDtos.get(0).getCarName()).isEqualTo("judy");

        assertThat(carPositionDtos.get(1).getStatus()).isZero();
        assertThat(carPositionDtos.get(1).getCarName()).isEqualTo("nunu");

        assertThat(carPositionDtos.get(2).getStatus()).isEqualTo(1);
        assertThat(carPositionDtos.get(2).getCarName()).isEqualTo("pobi");

    }

    @Test
    void findWinner_함수로_우승자들이_반환됨() {
        carContainer.moveCars();
        assertThat(carContainer.findWinner()).containsExactly("judy", "pobi");

        carContainer.moveCars();
        assertThat(carContainer.findWinner()).containsExactly("judy", "nunu", "pobi");

    }
}
