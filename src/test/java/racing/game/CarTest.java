package racing.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racing.game.Car.checkInvalidNameLength;
import static racing.game.Car.checkNull;

public class CarTest {

    @Test
    void 차의위치를출력() {
        Car car = null;
        try {
            car = new Car("pobi");
        } catch (Exception e) {
            e.printStackTrace();
        }
        car.move();
        car.move();
        assertThat(car.showPosition()).isEqualTo("pobi : --");
    }

    @Test
    void 문자열이_NULL인지확인() {
        String name = null;
        assertThat(checkNull(name)).isTrue();
    }

    @Test
    void 이름으로_NULL을입력했을때_객체생성시오류확인() {
        String name = null;
        assertThrows(Exception.class, () -> new Car(name));
    }

    @Test
    void 문자열이길이제한을초과하는지확인() {
        String name = "pobipobi";
        assertThat(checkInvalidNameLength(name)).isTrue();
    }

    @Test
    void 문자열이빈입력인지확인() {
        String name = "";
        assertThat(checkInvalidNameLength(name)).isTrue();
    }

    @Test
    void 이름으로제한값보다긴값을입력했을때객체생성시오류확인() {
        String name = "pobipobi";
        assertThrows(Exception.class, () -> new Car(name));
    }

    @Test
    void 이름으로빈값을입력했을때객체생성시오류확인() {
        String name = "";
        assertThrows(Exception.class, () -> new Car(name));
    }

}
