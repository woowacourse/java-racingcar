package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    @DisplayName("Name 객체 생성")
    void create() {
        final Name name = new Name("pobi");
        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @Test
    @DisplayName("Name 유효성 검사")
    void validateName() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    new Name("python");
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    new Name("");
                })
        );
    }
}