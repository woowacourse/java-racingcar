package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Name name = new Name("pobi");
    Car car = new Car(name);
    MoveController alwaysMoveGenerator = () -> 9;

    @Test
    void 전진하기() {
        assertThat(car.movePosition(alwaysMoveGenerator)).isEqualTo(1);
    }

    @Test
    void 현재_위치_가져오기() {
        car.movePosition(alwaysMoveGenerator);
        assertThat(car.getCurrentPosition()).isEqualTo("pobi : -");
    }

    @Test
    void Winner와_position이_같은지_테스트() {
        Car car1 = new Car(new Name("pobi"));
        Car car2 = new Car(new Name("elly"));
        car1.movePosition(alwaysMoveGenerator);
        car2.movePosition(alwaysMoveGenerator);
        car1.isSamePositionWith(car2);
    }
}