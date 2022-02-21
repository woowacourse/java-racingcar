package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingCar.domain.dto.CarDto;
import racingCar.domain.moveStrategy.MovableNumGenerator;
import racingCar.domain.moveStrategy.NumGenerator;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setup() {
        cars = new Cars(Arrays.asList("hunch", "judi"));
    }

    @Test
    void getMaxPosition_0_검사() {
        assertThat(cars.getMaxPosition()).isEqualTo(0);
    }

    @Test
    void getSamePositionCars_이동없을때_검사() {
        assertThat(cars.getSamePositionCarsDto(0))
                .containsOnly("hunch", "judi");
    }

    @Test
    void get_같은값이_나오는지_검사() {
        CarDto hunchDTO = new CarDto(new Car("hunch", 0));
        CarDto judiDTO = new CarDto(new Car("judi", 0));

        assertThat(cars.getDto())
                .isEqualTo(Arrays.asList(hunchDTO, judiDTO));
    }

    @Nested
    @DisplayName("2번_이동시_테스트")
    class GoTwoTest {
        @BeforeEach
        void set() {
            //given
            NumGenerator numGenerator = new MovableNumGenerator();

            //when
            cars.go(numGenerator);
            cars.go(numGenerator);
        }

        @Test
        void getMaxPosition_2_검사() {
            //then
            assertThat(cars.getMaxPosition()).isEqualTo(2);
        }

        @Test
        void getSamePositionCars_2_검사() {
            //then
            assertThat(cars.getSamePositionCarsDto(2))
                    .containsOnly("hunch", "judi");
        }
    }
}