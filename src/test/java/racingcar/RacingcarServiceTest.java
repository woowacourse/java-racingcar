package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingcarServiceTest {

    private RacingcarService racingcarService = new RacingcarService();

    @Test
    @DisplayName("구분자가 없을 때 예외")
    void validSeparator() {
        String input = "우가.밀리";

        assertThatThrownBy(() -> racingcarService.makeCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구분자(,)가 필요해요.");
    }

    @Test
    @DisplayName("경주 참가자가 한명이하일 때 예외")
    void validParticipants() {
        String input = "밀리,";

        assertThatThrownBy(() -> racingcarService.makeCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 경주는 최소 2명이 필요해요.");
    }

    @Test
    @DisplayName("입력값을 받아서 자동차 리스트 생성 확인")
    void makeCars() {
        String input = "밀리,우가";

        Cars cars = racingcarService.makeCars(input);
        assertAll(
                () -> assertEquals("밀리", cars.getCars().get(0).getName()),
                () -> assertEquals("우가", cars.getCars().get(1).getName())
        );
    }

    @Test
    @DisplayName("우승자 확인하기")
    void findWinner() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car2.move(5);
        car3.move(5);

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        List<Car> winners = racingcarService.findWinner(cars);

        assertThat(winners).containsExactly(car2, car3);
    }
}