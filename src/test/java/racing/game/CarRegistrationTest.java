package racing.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarRegistrationTest {


    @Test
    void 입력을이름들로분리() {
        String string = " ,,, ";
        assertThat(CarRegistration.splitNames(string)).
                contains("jihoon", "pobi","gugu","jinwook");
    }

    @Test
    void 빈입력인지확인() {
        String string = new String("  , , ,  ");
        assertThat(CarRegistration.checkNoInput(CarRegistration.splitNames(string))).isTrue();
    }

}
