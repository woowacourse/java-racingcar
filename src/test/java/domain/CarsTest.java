package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    @Test
    @DisplayName("중복된 자동차 이름이 있으면 예외가 발생한다.")
    void validateDuplicateCarNameTest() {
        List<String> duplicateCarNames = new ArrayList<>(List.of("leo", "leo"));

        assertThrows(IllegalArgumentException.class,
                () -> new Cars(duplicateCarNames));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 없으면 예외가 발생하지 않는다.")
    void validateNonDuplicateCarNameTest() {
        List<String> nonDuplicateCarNames = new ArrayList<>(List.of("leo", "mint"));

        assertThatCode(() -> new Cars(nonDuplicateCarNames))
                .doesNotThrowAnyException();
    }
}
