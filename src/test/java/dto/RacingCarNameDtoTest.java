package dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarNameDtoTest {
    @DisplayName("레이싱카 이름이 5글자 이하인지 확인한다.")
    @Test
    public void testCarNameLength() {
        String carNameOverThan5Length = "racingcar";

        Assertions.assertThatThrownBy(() -> new RacingCarNameDto(carNameOverThan5Length))
                .isInstanceOf(IllegalArgumentException.class);
    }
}