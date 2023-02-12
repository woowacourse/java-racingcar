package racinggame.domain;

import racinggame.domain.Car;
import racinggame.domain.Winner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnerTest {
    private static Car car1;
    private static Car car2;
    private static Car car3;
    private static Winner winner;

    @BeforeAll
    static void setup() {
        car1 = new Car("jerry", 4);
        car2 = new Car("jena", 3);
        car3 = new Car("poby", 4);
        List<Car> cars = Arrays.asList(car1, car2, car3);
        winner = new Winner();
        winner.makeWinnerNames(cars);
    }

    @Test
    @DisplayName("winner 목록이 옳게 생성되었는지 확인하는 테스트")
    void make_winner_names_success() {
        assertThat(winner.getWinnerNames()).isEqualTo(Arrays.asList(car1.getName(), car3.getName()));
    }
}
