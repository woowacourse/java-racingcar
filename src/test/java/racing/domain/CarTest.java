package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void 자동차생성() {
        Car car = new Car("pobi");
        assertThat(car).isEqualTo(new Car("pobi"));
    }

    @Test
    void 전진() {
        Car car = new Car("brown");
        car.tryGoForward(new Move());
        assertThat(car).isEqualTo(new Car("brown", 1));
    }

    @Test
    void 정지() {
        Car car = new Car("brown");
        car.tryGoForward(new Stop());
        assertThat(car).isEqualTo(new Car("brown", 0));
    }

    @Test
    void 자동차비교() {
        Car car1 = new Car("a", 1);
        Car car2 = new Car("a", 2);
        Car car3 = new Car("a", 1);
        assertThat(car1.compareTo(car2) == -1).isTrue();
        assertThat(car2.compareTo(car1) == 1).isTrue();
        assertThat(car1.compareTo(car3) == 0).isTrue();
    }
}

class Move implements MovementStrategy {
    public int numberGenerate() {
        return 4;
    }
}

class Stop implements MovementStrategy {
    public int numberGenerate() {
        return 3;
    }
}