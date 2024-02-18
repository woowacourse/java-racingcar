package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 올바르면 Car 객체 생성")
    void createCar() {
        assertThatCode(() -> new Car("pobi")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과이면 예외")
    void createCarWithOverSize() {
        assertThatThrownBy(() -> new Car("pobipobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외")
    void createCarWithEmpty() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차는 전진할 수 있다")
    void move() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 간 전진 거리가 같음을 판단할 수 있다")
    void isSame() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        car1.move();
        car2.move();
        boolean expected = car1.isSame(car2);
        assertThat(expected).isTrue();
    }

    @Test
    @DisplayName("자동차 간 전진 거리를 같지 않음을 판단할 수 있다")
    void isNotSame() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        car1.move();
        boolean expected = car1.isSame(car2);
        assertThat(expected).isFalse();
    }

    @Test
    @DisplayName("자동차 간 전진 거리를 비교할 수 있다")
    void compareTo() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        car1.move();
        int expected = car1.compareTo(car2);
        assertThat(expected).isEqualTo(-1);
    }

    @Test
    @DisplayName("자동차 이름이 같으면 같은 자동차이다")
    void equals() {
        String name = "pobi";
        Car car1 = new Car(name);
        Car car2 = new Car(name);
        assertThat(car1).isEqualTo(car2);
    }

    @Test
    @DisplayName("자동차 이름이 다르면 다른 자동차이다")
    void notEquals() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        assertThat(car1).isNotEqualTo(car2);
    }
}
