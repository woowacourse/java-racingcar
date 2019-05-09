package racing.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputRegistrationTest {


    @Test
    void 입력을이름들로분리() {
        String string = "pobi,jinwook";
        assertThat(InputRegistration.splitNames(string)).contains("pobi","jinwook");
    }

    @Test
    void 빈입력인지확인() {
        String string = new String("");
        assertThat(InputRegistration.checkNoInput(InputRegistration.splitNames(string))).isTrue();
    }

    @Test
    void 입력에서중복된이름이있는지확인() {
        String string = "pobi,pobi";
        assertThat(InputRegistration.checkRepetition(InputRegistration.splitNames(string))).isTrue();
    }

    @Test
    void 길이제한을초과하는이름이있는지확인() {
        String string = "pobipobi,pobi,pobi";
        assertThat(InputRegistration.checkInvalidNameLength(InputRegistration.splitNames(string))).isTrue();
    }

    @Test
    void 잘못된라운드입력확인() {
        assertThrows(Exception.class, () -> {InputRegistration.getRoundNumber("aa");});
    }


}
