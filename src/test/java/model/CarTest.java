package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void car_create_test() {
        assertThat(new Car(new CarName("Aiden"))).isEqualTo(new Car(new CarName("Aiden"), 0));
    }

    @Test
    void car_move_test() {
        Car car = new Car(new CarName("Aiden"));
        car.move(4);
        assertThat(car).isEqualTo(new Car(new CarName("Aiden"), 1));
    }

    @Test
    void car_stop_test() {
        Car car = new Car(new CarName("Aiden"));
        car.move(3);
        assertThat(car).isEqualTo(new Car(new CarName("Aiden"), 0));
    }

    @Test
    void 자동차_복제() {
        Car sourceCar = new Car(new CarName("pobi"), 3);
        Car copyCar = sourceCar.copy();
        assertThat(sourceCar != copyCar).isTrue();
        assertThat(sourceCar.equals(copyCar)).isTrue();
    }
}