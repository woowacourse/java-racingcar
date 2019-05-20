package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNamesInputTest {
    @Test
    void 빈_입력() {
        assertThrows(Exception.class, () -> {
            new CarNamesInput("");
        });
    }

    @Test
    void 입력에서_중복된_이름이_존재() {
        assertThrows(Exception.class, () -> {
            new CarNamesInput("pobi, pobi");
        });
    }

    @Test
    void 길이제한을_초과하는_이름이_있는_입력() {
        assertThrows(Exception.class, () -> {
            new CarNamesInput("pobipibi,pibi, pobi");
        });
    }

    @Test
    void 쉼표_사이에_이름이_존재하지_않는_입력() {
        assertThrows(Exception.class, () -> {
            new CarNamesInput("pobi,,,,pob");
        });
    }

}
