package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class CarTest {

    @Test
    @DisplayName("자동차에 기준값 보다 큰 값을 주면 전진 하는지 확인")
    public void 자동차_진행_테스트() {
        //given
        Car car = new Car("woo");

        //when
        car.progress(() -> true);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차에 기준값 보다 작은 값을 주면 정지 하는지 확인")
    public void 자동차_정지_테스트() {
        //given
        Car car = new Car("woo");

        //when
        car.progress(() -> false);

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
            car.progress(() -> true);
        }

        //then
        assertThat(car.getPosition()).isEqualTo(repeatCount);
    }

    @Test
    @DisplayName("한 글자 미만의 자동차 이름 테스트")
    public void 한글자_미만의_자동차_이름_테스트() {
        //given
        String name = "";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @Test
    @DisplayName("다섯 글자 초과의 자동차 이름 테스트")
    public void 다섯글자_초과의_자동차_이름_테스트() {
        //given
        String name = "wooteco";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @Test
    @DisplayName("자동차 이름에 공백이 포함되어있는지 테스트")
    public void 자동차_이름_공백_테스트() {
        //given
        String name = "woo   te   co";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }
}