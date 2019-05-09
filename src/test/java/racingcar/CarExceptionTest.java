package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CarExceptionTest {
    @Test
    void checkLimitTest(){
        String name = "asdas";
        assertThat(CarException.checkLimit(name)).isEqualTo(false);
    }

    @Test
    void isOverLimitTest(){
        List<String> nameList = new ArrayList<>(Arrays.asList("asddfdfd", "asd"));
        assertThat(CarException.isOverLimit(nameList)).isEqualTo(true);
    }

    @Test
    void isWhiteSpaceOnlyTest(){
        List<String> nameList = Arrays.asList("asd", "", "asd");
        assertThat(CarException.isWhiteSpaceOnly(nameList)).isEqualTo(true);
    }

    @Test
    void isDuplicateTest() {
        List<String> nameList = Arrays.asList("asd", "ddd", "asd");
        assertThat(CarException.isDuplicate(nameList)).isEqualTo(true);
    }


}
