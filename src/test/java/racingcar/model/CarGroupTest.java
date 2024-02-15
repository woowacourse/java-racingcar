package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGroupTest {
    private CarGroup carGroup;

    @BeforeEach
    void makeGroup() {
        carGroup = new CarGroup();
    }

    @Test
    @DisplayName("가장 멀리 움직인 자동차가 우승한다.")
    void findWinnerTest() {
        int moveNumber = 5;

        Car pedro = new Car("페드로");
        Car moly = new Car("몰리");
        Car neo = new Car("네오");

        carGroup.add(pedro);
        carGroup.add(moly);
        carGroup.add(neo);

        neo.move(moveNumber);
        neo.move(moveNumber);
        pedro.move(moveNumber);

        assertThat(carGroup.findWinners()).isEqualTo(List.of(neo));
    }

    @Test
    @DisplayName("모든 자동차가 이동하지 않을 경우 우승자는 없다.")
    void drawTest() {
        Car pedro = new Car("페드로");
        Car moly = new Car("몰리");
        Car neo = new Car("네오");

        carGroup.add(pedro);
        carGroup.add(moly);
        carGroup.add(neo);

        assertThat(carGroup.findWinners()).isEmpty();
    }
}
