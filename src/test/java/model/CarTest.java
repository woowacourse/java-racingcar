package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 차_전진_정지_검사() {
        Car car1 = new Car(new CarName("coogi"),3);
        car1.move(4);
        assertThat(new Car(new CarName("coogi"),4)).isEqualTo(car1);

        Car car2 = new Car(new CarName("coogi"));
        car2.move(0);
        assertThat(new Car(new CarName("coogi"))).isEqualTo(car2);

        Car car3 = new Car(new CarName("coogi"));
        car3.move(9);
        assertThat(new Car(new CarName("coogi"),1)).isEqualTo(car3);
    }
}