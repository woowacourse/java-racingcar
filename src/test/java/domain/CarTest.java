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
    void 자동차_객체_생성_5글자_초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            car = new Car("123456");
        });
    }

    @Test
    void 자동차_객체_생성_0길이_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            car = new Car("");                  // 길이가 0인 name을 입력 시 예외

        });
    }

    @Test
    void 자동차_객체_생성_null_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            car = new Car(null);                // null에 대한 예외
        });
    }

    @Test
    void 자동차_객체_생성_공백_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> {
            car = new Car(" ");                // 공백 입력 시 에외
        });
    }

    @Test
    void 자동차_포지션_변화_없음_확인() {
        car.increasePositionOrNot(3);
        assertThat(car.matchPosition(0)).isTrue();
    }

    @Test
    void 자동차_포지션_변화_확인() {
        car.increasePositionOrNot(4);
        assertThat(car.matchPosition(1)).isTrue();
    }

    @Test
    void 자동차_포지션_일치_확인() {
        assertThat(car.matchPosition(0)).isTrue();
    }

    @AfterEach
    void tearDown() {
        car = null;
    }
}