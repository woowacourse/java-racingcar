package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPositionDto;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    private MockRandomPicker mockRandomPicker;
    private Cars cars;

    @BeforeEach
    void setUp() {
        mockRandomPicker = new MockRandomPicker(List.of(4, 3, 4, 3, 4, 3, 4, 3, 4, 3, 4, 3, 4, 3, 4, 3));
        cars = new Cars(List.of("judy", "nunu", "pobi"));
    }

    @Test
    void move_함수를_호출했을때_진행이_되는_것을_확인() {
        cars.moveCars(mockRandomPicker);

        List<CarPositionDto> carPositionDtos = cars.toDto();
        assertAll(() -> assertThat(carPositionDtos.get(0).getStatus()).isEqualTo(1),
                () -> assertThat(carPositionDtos.get(0).getCarName()).isEqualTo("judy"),
                () -> assertThat(carPositionDtos.get(1).getStatus()).isZero(),
                () -> assertThat(carPositionDtos.get(1).getCarName()).isEqualTo("nunu"),
                () -> assertThat(carPositionDtos.get(2).getStatus()).isEqualTo(1),
                () -> assertThat(carPositionDtos.get(2).getCarName()).isEqualTo("pobi")
        );


    }

    @Test
    void findWinner_함수로_우승자들이_반환됨() {
        cars.moveCars(mockRandomPicker);
        assertThat(cars.findWinner()).containsExactly("judy", "pobi");

        cars.moveCars(mockRandomPicker);
        assertThat(cars.findWinner()).containsExactly("judy", "nunu", "pobi");

    }

    @Test
    void 생성시_중복된_이름이_있으면_예외발생() {
        assertThatThrownBy(() -> new Cars(List.of("judy", "judy")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름이 존재합니다.");
    }
}
