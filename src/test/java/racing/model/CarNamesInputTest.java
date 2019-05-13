package racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNamesInputTest {
    @Test
    void 입력을이름들로분리() {
        assertThat(CarNamesInput.splitNames("pobi,jinwook")).contains("pobi","jinwook");
    }

    @Test
    void 빈입력() {
        assertThrows(Exception.class, ()-> {
            CarNamesInput.getCars("");
        });
    }

    @Test
    void 입력에서중복된이름이존재() {
        assertThat(CarNamesInput.checkRepetition
                (CarNamesInput.splitNames("pobi,pobi"))).isTrue();
    }

    @Test
    void 길이제한을초과하는이름이있는입력() {
        assertThrows(Exception.class, ()-> {
            CarNamesInput.getCars("pobipibi,pibi, pobi");
        });
    }

    @Test
    void 쉼표사이에이름이존재하지않는입력() {
        assertThrows(Exception.class, ()-> {
            CarNamesInput.getCars("pobi,,,,pob");
        });
    }

}
