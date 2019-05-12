package racing.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racing.game.Car.checkInvalidNameLength;
import static racing.game.Car.checkNull;

public class CarTest {
    @Test
    void 기준점이상을_입력한_경우() {
        try {
            Car car = new Car("pobi");
            assertThat(car.move(4)).isTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void 기준점미만을_입력한_경우() {
        try {
            Car car = new Car("pobi");
            assertThat(car.move(3)).isFalse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void 차의_위치를_출력() {
        Car car = null;
        try {
            car = new Car("pobi");
        } catch (Exception e) {
            e.printStackTrace();
        }
        car.move(4);
        car.move(4);
        assertThat(car.toString()).isEqualTo("pobi : --");
    }

    @Test
    void 문자열이_NULL인지_확인() {
        String name = null;
        assertThat(checkNull(name)).isTrue();
    }

    @Test
    void 이름으로_NULL을_입력한_경우_객체생성시_오류확인() {
        String name = null;
        assertThrows(Exception.class, () -> new Car(name));
    }

    @Test
    void 문자열이_길이제한을_초과하는_경우() {
        String name = "pobipobi";
        assertThat(checkInvalidNameLength(name)).isTrue();
    }

    @Test
    void 문자열이_빈입력인_경우() {
        String name = "";
        assertThat(checkInvalidNameLength(name)).isTrue();
    }

    @Test
    void Car객체의_이름과_같은_문자열인_경우() {
        String name = "pobi";
        try {
            assertThat(new Car(name).matchCarName(name)).isTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void 같은이름이있는_리스트와_이름의중복을_비교하는_경우() {
        try {
            Car car = new Car("pobi");
            List<Car> cars = Arrays.asList(new Car[]{new Car("pobi"), new Car("crong")});
            assertThat(car.checkRepetition(cars)).isTrue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void 이름으로_제한값보다_긴값을_입력한_경우_객체생성시_에러확인() {
        String name = "pobipobi";
        assertThrows(Exception.class, () -> new Car(name));
    }

    @Test
    void 이름으로_빈값을_입력한_경우_객체생성시_에러확인() {
        String name = "";
        assertThrows(Exception.class, () -> new Car(name));
    }

    @Test
    void 같은이름을_입력한_경우_객체생성시_에러확인() {
        String name = "pobi";
        List<Car> cars = new ArrayList<>();
        try {
            cars = Arrays.asList(new Car[]{new Car("pobi"), new Car("crong")});
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Car> finalCars = cars;
        assertThrows(Exception.class, () -> new Car(name, finalCars));
    }

}
