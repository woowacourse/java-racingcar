package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarFactoryTest {

    private CarFactory carFactory = new CarFactory();

    @Test
    @DisplayName("구분자가 없을 때 예외")
    void validSeparator() {
        String input = "우가.밀리";

        assertThatThrownBy(() -> carFactory.makeCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구분자(,)가 필요해요.");
    }

    @Test
    @DisplayName("경주 참가자가 한명이하일 때 예외")
    void validParticipants() {
        String input = "밀리,";

        assertThatThrownBy(() -> carFactory.makeCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 경주는 최소 두명이 필요해요.");
    }

    @Test
    @DisplayName("입력값을 받아서 자동차 리스트 생성 확인")
    void makeCars() {
        String input = "밀리,우가";

        List<Car> cars = carFactory.makeCars(input);

        assertThat(cars.get(0).getName()).isEqualTo("밀리");
        assertThat(cars.get(1).getName()).isEqualTo("우가");
    }
}