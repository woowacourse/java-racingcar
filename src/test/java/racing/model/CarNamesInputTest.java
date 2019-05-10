package racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNamesInputTest {
    @Test
    void 입력을이름들로분리() {
        String string = "pobi,jinwook";
        assertThat(CarNamesInput.splitNames(string)).contains("pobi","jinwook");
    }

    @Test
    void 빈입력인지확인() {
        String string = "";
        assertThat(CarNamesInput.checkNoInput(CarNamesInput.splitNames(string))).isTrue();
    }

    @Test
    void 입력에서중복된이름이있는지확인() {
        String string = "pobi,pobi";
        assertThat(CarNamesInput.checkRepetition(CarNamesInput.splitNames(string))).isTrue();
    }

    @Test
    void 길이제한을초과하는이름이있는지확인() {
        String string = "pobipobi,pobi,pobi";
        assertThrows(Exception.class, ()-> {
            CarNamesInput.getCars("pobipibi,pibi, pobi");
        });
    }

    @Test
    void 쉼표사이에이름이존재하지않는입력() {
        String string = "pobi,,,,pob";
        assertThrows(Exception.class, ()-> {
            CarNamesInput.getCars(string);
        });
    }

}
