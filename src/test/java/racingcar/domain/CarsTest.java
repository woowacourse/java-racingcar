package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.util.CarFactory;

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
    @DisplayName("이동 정책에 따른 차 이동")
    public void moveCars_twice() {
        Cars cars = new Cars(List.of(forky, kun, pobi));
        cars.moveCars(moveTwice);
        assertThat(forky.getPosition())
                .isEqualTo(kun.getPosition())
                .isEqualTo(1)
                .isGreaterThan(pobi.getPosition());
    }

    private MoveStrategy moveTwice = new MoveStrategy() {
        private int count = 0;

        @Override
        public boolean isMovable() {
            if (count > 1) {
                return false;
            }
            count++;
            return true;
        }
    };
}
