package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    @Test
    @DisplayName("자동차 진행시 전진 혹은 정지 하는지 확인")
    public void 자동차_진행_테스트() throws Exception {
        //given
        Car car = new Car("woo");

        //when
        car.progress();

        //then
        assertThat(car.getPosition())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(1);
    }

    @Test
    @DisplayName("자동차 반복 진행시 정상 동작 확인")
    public void 자동차_반복_진행_테스트() throws Exception {
        //given
        Car car = new Car("woo");
        int count = 5;

        //when
        for (int i = 0; i < count; i++) {
            car.progress();
        }

        //then
        assertThat(car.getPosition())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(5);
    }
}