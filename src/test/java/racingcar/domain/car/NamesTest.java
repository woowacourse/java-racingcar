package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {

    @Test
    @DisplayName("이름들을 받아서 CarNames 생성")
    void createTest() {
        assertAll(
                () -> assertThat(Names.create("pobi,jason,java").toList().size()).isEqualTo(3)
        );
    }
}