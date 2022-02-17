package racingcargame.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("입력된 자동차 이름이 없는 경우 테스트")
    @Test
    void checkValidateName_EmptyName() {
        String emptyName = "";

        assertThatThrownBy(() -> {
            Name name = new Name(emptyName);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 입력된 자동차 이름중 이름이 없는 자동차가 있습니다.");
    }

    @DisplayName("자동차 이름이 5자를 초과하는 경우 테스트")
    @Test
    void checkValidateName_ValidNameLength() {
        String carName = "토미데이비슨";

        assertThatThrownBy(() -> {
            Name name = new Name(carName);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 자동차 이름을 5자 이하로 입력해주세요.");
    }

    @DisplayName("자동차 이름이 올바른 입력일 경우 테스트")
    @Test
    void checkValidateName() {
        String carName = "하디베어";

        Name name = new Name(carName);
        assertThat(name.getName()).isEqualTo("하디베어");
    }
}