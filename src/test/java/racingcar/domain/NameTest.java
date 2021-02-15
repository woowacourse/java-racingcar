package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("같은 이름을 가진 객체를 비교하는 경우")
    void nameIsEquals() {
        String carName = "povi";
        Name name = new Name(carName);
        assertThat(name).isEqualTo(new Name(carName));
    }

    @Test
    @DisplayName("이름을 null 또는 빈문자로 주었을때")
    public void nameNullOrBlank() {
        String carName = "";
        assertThatThrownBy(() -> {
            Name name = new Name(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 한글 혹은 영어로 이루어지지 않은 경우")
    public void nameIncludeNonEngOrNonKOR() {
        String carName = "ab하#";
        assertThatThrownBy(() -> {
            Name name = new Name(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
