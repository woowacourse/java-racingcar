package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private static final int MOVE = 10;
    private static final int STOP = 0;

    Car car1 = new Car("gavi");
    Car car2 = new Car("jude");
    Car car3 = new Car("pobi");

    Cars cars = new Cars(List.of(car1, car2, car3));

    @BeforeEach
    void setUp(){
        car1.move(MOVE);
        car1.move(MOVE);
        car1.move(MOVE);

        car2.move(MOVE);
        car2.move(MOVE);
        car2.move(MOVE);
    }

    @Test
    @DisplayName("우승자 확인 성공 테스트")
    void getWinnerSuccessTest() {
        assertThat(cars.getWinnerNames()).isEqualTo(List.of("gavi", "jude"));
    }

    @Test
    @DisplayName("우승자 확인 실패 테스트")
    void getWinnerFailTest() {
        assertThat(cars.getWinnerNames()).isNotEqualTo(List.of("gavi"));
    }

}