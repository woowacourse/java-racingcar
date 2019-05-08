package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarExceptionTest {
    @Test
    void checkLimit(){
        String name = "asdas";
        assertThat(CarException.checkLimit(name)).isEqualTo(false);
    }

    @Test
    void isOverLimit(){
        List<String> nameList = Arrays.asList("asd", "asd");
        assertThat(CarException.isOverLimit(nameList)).isEqualTo(true);
    }

    @Test
    void isWhiteSpaceOnly(){
        List<String> nameList = Arrays.asList("asd", "", "asd");
        assertThat(CarException.isWhiteSpaceOnly(nameList)).isEqualTo(true);
    }

    @Test
    void isDuplicate() {
        List<String> nameList = Arrays.asList("asd", "ddd", "asd");
        assertThat(CarException.isDuplicate(nameList)).isEqualTo(true);
    }

}
