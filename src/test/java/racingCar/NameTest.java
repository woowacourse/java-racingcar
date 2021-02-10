package racingCar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    public void name_length() {
        Name name = new Name("aaa");

        assertThat(name).isEqualTo(new Name("aaa"));
    }

}