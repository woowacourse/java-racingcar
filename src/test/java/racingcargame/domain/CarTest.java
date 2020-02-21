package racingcargame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("랜덤값이 4 이상이면 자동차의 position 증가 테스트")
    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void testIfRandomValueIs4ThenCarGo() {
        Car car = new Car("pobi", 0, new LimitEngine());
        car.go(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 랜덤값이_기준_이하_일_경우_자동차의_position변화_없음_테스트() {
        Car car = new Car("pobi", 0, new LimitEngine());
        car.go(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 자동차_생성() {
        String[] carNames = new String[]{"pobi", "jason"};
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        assertThat(carList.size()).isEqualTo(2);
    }
}
