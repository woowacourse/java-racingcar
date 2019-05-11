package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-11
 */
class RaceTest {
    List<Car> cars;
    Race race;
    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("hello"));
        cars.add(new Car("my"));
        cars.add(new Car("name"));

        race = new Race(cars);
    }

    @Test
    void create_객체_생성() {
        assertThat(race).isEqualTo(new Race(cars));
    }

    @Test
    void getRaceCarNames_이름_확인() {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.toString());
        }
        assertThat(race.getRaceCarInfo()).isEqualTo(carNames);
    }

    @Test
    void getRaceWinners_그리고_setMaxPoint_확인() {
        cars.add(new Car("win",Const.CAR_OBJ_INIT_POSITION+1));
        cars.add(new Car("ner",Const.CAR_OBJ_INIT_POSITION+1));
        race = new Race(cars);
        assertThat(race.getRaceWinners()).isEqualTo("win,ner");
    }

    @Test
    void name() {
    }
}