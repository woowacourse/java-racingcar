package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("hello");
    }

    @Test
    void 자동차_객체_생성() {
        assertThat(car).isEqualTo(new Car("hello"));
    }

    @Test
    void 자동차_객체_생성_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            car = new Car("123456");            // 5글자 초과 이름 입력 시 예외
        });

        assertThrows(IllegalArgumentException.class, () -> {
            car = new Car("");                  // 길이가 0인 name을 입력 시 예외

        });

        assertThrows(IllegalArgumentException.class, () -> {
            car = new Car(null);                // null에 대한 예외
        });

        assertThrows(IllegalArgumentException.class, () -> {
            car = new Car(" ");                // 공백 입력 시 에외
        });
    }

    @Test
    void 자동차_포지션_변화() {
        car.increasePositionOrNot(3);
        assertThat(car.matchPosition(0)).isTrue();
    }

    @Test
    void 자동차_포지션_일치_확인() {
        assertThat(car.matchPosition(0)).isTrue();
    }

    @Test
    void 자동차_포지션_비교() {
        assertThat(car.isGreaterThanMaxPosition(3)).isFalse();
    }

    @Test
    void 자동차_포지션_차이() {
        assertThat(car.getPositionGap(2)).isEqualTo(-2);
    }

    @AfterEach
    void tearDown() {
        car = null;
    }
}