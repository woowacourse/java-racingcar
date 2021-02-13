package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    @DisplayName("이름 검증 - 성공")
    void validateName_success() {
        CarName name = CarName.from("joy");

        assertThat(name).hasToString("joy");
    }
}