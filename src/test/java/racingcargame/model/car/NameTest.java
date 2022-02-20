package racingcargame.model.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargame.model.car.vo.CarName;

class NameTest {

    @DisplayName("입력된 자동차 이름이 없는 경우 테스트")
    @Test
    void checkValidateName_EmptyName() {
        final String emptyName = "";

        assertThatThrownBy(() -> {
            final CarName carName = new CarName(emptyName);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 입력된 자동차 이름중 이름이 없는 자동차가 있습니다.");
    }

    @DisplayName("자동차 이름이 5자를 초과하는 경우 테스트")
    @Test
    void checkValidateName_ValidNameLength() {
        final String carName = "토미데이비슨";

        assertThatThrownBy(() -> {
            final CarName name = new CarName(carName);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 자동차 이름을 5자 이하로 입력해주세요.");
    }

    @DisplayName("자동차 이름이 올바른 입력일 경우 테스트")
    @Test
    void checkValidateName() {
        final String carName = "하디베어";

        final CarName name = new CarName(carName);
        assertThat(name.getName()).isEqualTo("하디베어");
    }
}