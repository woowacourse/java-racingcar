package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Car forky;
    private Car kun;
    private Car pobi;

    @BeforeEach
    public void initialize_cars() {
        forky = new Car("forky");
        kun = new Car("kun");
        pobi = new Car("pobi");
    }

    @Test
    @DisplayName("차 이름 중복일 때 exception 발생")
    public void duplicated_car_name_exception() {
        assertThatThrownBy(() -> new Cars(CarFactory.of("forky,forky")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR] 차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("최대 위치값이 1일 때 maxPosition 구하기")
    public void getMaxPosition_1() {
        forky.move(true);
        Cars cars = new Cars(List.of(forky, kun, pobi));
        assertThat(cars.getMaxPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("위치값이 1인 car 구하기")
    public void matchPosition_1() {
        forky.move(true);
        Cars cars = new Cars(List.of(forky, kun, pobi));
        assertThat(cars.matchPosition(1)).containsExactly(forky);
    }
}
