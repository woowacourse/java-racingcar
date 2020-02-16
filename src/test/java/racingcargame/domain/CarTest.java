package racingcargame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("랜덤값이 4 이상이면 자동차의 position 증가 테스트")
    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void testIfRandomValueIs4ThenCarGo() {
        Engine engine = Engine.createEngineSetBy(4);
        Car car = new Car("pobi");
        car.go(engine);
        assertThat(car.isSameToPosition(new Position(1))).isEqualTo(true);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 랜덤값이_기준_이하_일_경우_자동차의_position변화_없음_테스트() {
        Engine engine = Engine.createEngineSetBy(3);
        Car car = new Car("pobi");
        car.go(engine);
        assertThat(car.isSameToPosition(new Position(0))).isEqualTo(true);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 자동차이름이_같은지_확인() {
        Car car = new Car("pobi");
        String name = "pobi";
        boolean result = car.isSame(name);
        assertThat(result).isTrue();
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
