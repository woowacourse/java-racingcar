package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private CarMoveRule rule = new CarMoveRule();

    @Test
    public void 자동차_객체_생성_테스트() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    public void 자동차_전진전략_이동_테스트() {
        Car car = new Car("pobi");
        for (int i=0; i<10; i++) {
            car.move(rule.alwaysMoveRule());
        }
        assertThat(car.getPosition()).isEqualTo(10);
    }

    @Test
    public void 자동차_정지전략_이동_테스트() {
        Car car = new Car("pobi");
        for (int i=0; i<10; i++) {
            car.move(rule.noMoveRule());
        }
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
