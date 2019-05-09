package racing.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRegistrationTest {


    @Test
    void 입력을이름들로분리() {
        String string = "pobi,jinwook";
        assertThat(CarRegistration.splitNames(string)).contains("pobi","jinwook");
    }

    @Test
    void 빈입력인지확인() {
        String string = new String("");
        assertThat(CarRegistration.checkNoInput(CarRegistration.splitNames(string))).isTrue();
    }

    @Test
    void 입력에서중복된이름이있는지확인() {
        String string = "pobi,pobi";
        assertThat(CarRegistration.checkRepetition(CarRegistration.splitNames(string))).isTrue();
    }

    @Test
    void 길이제한을초과하는이름이있는지확인() {
        String string = "pobipobi,pobi,pobi";
        assertThat(CarRegistration.checkInvalidNameLength(CarRegistration.splitNames(string))).isTrue();
    }
}
