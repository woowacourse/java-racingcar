package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 카의스테이터스비교가잘되나요1() {
        Car car1 = new Car("Buddy", 10);
        Car car2 = new Car("Luffy", 3);
        assertThat(car1.compareTo(car2)).isEqualTo(1);
    }
    @Test
    void 카의스테이터스비교가잘되나요2() {
        Car car1 = new Car("Buddy", 3);
        Car car2 = new Car("Luffy", 10);
        assertThat(car1.compareTo(car2)).isEqualTo(-1);
    }
    @Test
    void 카의스테이터스비교가잘되나요3() {
        Car car1 = new Car("Buddy", 5);
        Car car2 = new Car("Luffy", 5);
        assertThat(car1.compareTo(car2)).isEqualTo(0);
    }
}