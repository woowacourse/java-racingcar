package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacerTest {

    @Test
    @DisplayName("이름이 공백으로 들어온 경우 예외처리")
    void emptyName() {
        assertThatThrownBy(() -> {
            new Racer(" ");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("이름으로 공백을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 1미만 5초과의 길이로 들어온 경우")
    void checkNameLength() {
        assertAll(
                () -> assertThatThrownBy(() -> {
                    new Racer("joanne");
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]")
                        .hasMessageContaining("이름은 1자 이상, 5자 이내만 가능합니다."),
                () -> assertThatThrownBy(() -> {
                    new Racer("");
                }).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]")
                        .hasMessageContaining("이름은 1자 이상, 5자 이내만 가능합니다.")
        );
    }
}
