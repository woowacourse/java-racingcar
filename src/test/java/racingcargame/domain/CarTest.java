package racingcargame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("랜덤값이 4 이상이면 자동차의 position 증가 테스트")
    @Test
    void testIfRandomValueIs4ThenCarGo() {
        Engine engine = Engine.createEngineSetBy(5);
        Car car = new Car("pobi");
        car.go(engine);
        assertThat(car.isSameTo(1)).isEqualTo(true);
    }

    @Test
    void 포지션만큼출력() {
        Car car = new Car("pobi", 3);
        assertThat(car.printPosition()).isEqualTo("pobi : ---\n");
    }
}
