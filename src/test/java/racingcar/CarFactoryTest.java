package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}