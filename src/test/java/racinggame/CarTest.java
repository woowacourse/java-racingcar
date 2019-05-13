package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;
    Car car2;

    @BeforeEach
    void setUp() {
        car = new Car("bongjin");
        car2 = new Car("sloth", 3);
    }

    @Test
    void 자동차_이름_확인() {
        String result = car.getName();
        assertThat(result).isEqualTo("bongjin");
    }

    @Test
    void 최대_이동_거리_미달_확인() {
        boolean result = car.isMaxInstance(2);
        car.move(2);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void 최대_이동_거리_도달_확인() {
        car.move(4);
        car.move(4);
        car.move(4);
        boolean result = car.isMaxInstance(3);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 최대_이동_거리_도달_확인_생성자_이용() {
        boolean result = car2.isMaxInstance(3);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 자동차_이동_거리_출력_확인() {
        car.move(4);
        String result = car.toString();
        assertThat(result).isEqualTo("bongjin : -");
    }

    @Test
    void 자동차_이동_거리_출력_확인_생성자_이용() {
        String result = car2.toString();
        assertThat(result).isEqualTo("sloth : ---");
    }
}
