package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    public static final int MOVE_CONDITION = 10;
    public static final int STOP_CONDITION = 0;

    @Test
    @DisplayName("자동차에 기준값 보다 큰 값을 주면 전진 하는지 확인")
    public void 자동차_진행_테스트() {
        //given
        Car car = new Car("woo");

        //when
        car.progress(MOVE_CONDITION);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차에 기준값 보다 작은 값을 주면 정지 하는지 확인")
    public void 자동차_정지_테스트() {
        //given
        Car car = new Car("woo");

        //when
        car.progress(STOP_CONDITION);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 정해진 회수만큼 반복 진행시 정상적으로 동작하는지 확인")
    public void 자동차_반복_진행_테스트() {
        //given
        Car car = new Car("woo");
        int repeatCount = 5;

        //when
        for (int i = 0; i < repeatCount; i++) {
            car.progress(MOVE_CONDITION);
        }

        //then
        assertThat(car.getPosition()).isEqualTo(repeatCount);
    }
}