package racingcar.model.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("이름으로 자동차 생성 테스트")
    void carTest() {
        // given
        String testName = "test";

        // when
        Car car = new Car(testName);

        // then
        assertThat(car.getName()).isEqualTo(testName);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    @DisplayName("자동차 전진 테스트")
    void advanceTest(int number, int expected) {
        // given
        Car car = new Car("test");

        // when
        car.advance(number);

        // then
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @Test
    @DisplayName("포지션 동일성 테스트")
    void equalsPosition() {
        // given
        Car car = new Car("test");

        // when
        car.advance(4);

        // then
        assertTrue(car.isEqualPosition(1));
    }

    @Test
    @DisplayName("포지션 내림차순 테스트")
    void sortByPositionDesc() {
        // given
        Car pobi = new Car("pobi");
        pobi.advance(4);
        pobi.advance(4);

        Car hoho = new Car("hoho");
        hoho.advance(4);

        Car rich = new Car("rich");
        rich.advance(3);

        // when
        List<Car> cars = new ArrayList<>();
        cars.add(hoho);
        cars.add(rich);
        cars.add(pobi);
        Collections.sort(cars);

        // then
        assertThat(cars.get(0)).isEqualTo(rich);
        assertThat(cars.get(1)).isEqualTo(hoho);
        assertThat(cars.get(2)).isEqualTo(pobi);
    }
    
}
