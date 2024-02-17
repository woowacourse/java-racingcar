package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarNamesTest {
    @DisplayName("레이싱카 이름이 5글자 이하인지 확인한다.")
    @Test
    public void testCarNameLength() {
        String carNameOverThan5Length = "racingcar";

        Assertions.assertThatThrownBy(() -> new RacingCarNames(carNameOverThan5Length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자 이하만 가능합니다.");
    }

    @DisplayName("레이싱카 이름이 중복되는 지 확인한다.")
    @Test
    public void testCarNameDuplication() {
        String duplicatedNames = "rac,rac,bito";

        Assertions.assertThatThrownBy(() -> new RacingCarNames(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

}
