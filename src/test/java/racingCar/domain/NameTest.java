package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.domain.car.Name;
import racingCar.exception.InvalidCarNameException;

public class NameTest {

    @Test
    public void create() {
        final Name name = new Name("jason");
        assertThat(name).isEqualTo(new Name("jason"));
    }

    @DisplayName("형식에 맞지 않는 이름인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"jaaaaaason", "po  bi"})
    @NullAndEmptySource
    public void 유효성_검사(String nameValue) {
        assertThatThrownBy(() -> {
            Name name = new Name(nameValue);
        }).isInstanceOf(InvalidCarNameException.class);
    }

}
