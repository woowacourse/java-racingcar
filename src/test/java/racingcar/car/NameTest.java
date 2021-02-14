package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Name;

public class NameTest {

    @Test
    @DisplayName("이름이 잘 들어갔는지 테스트")
    void nameEqualTest() {
        Name name = new Name("benz");
        assertThat(name).isEqualTo(new Name("benz"));
    }

    @Test
    @DisplayName("길이에 따른 에러 테스트")
    void nameLengthErrorTest() {
        assertThatThrownBy(() -> new Name("mungto"))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Name(""))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
