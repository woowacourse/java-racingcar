package util;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberGeneratorTest {
    @Test
    @DisplayName("0부터 주입한 숫자 사이 무작위 값을 생성한다.")
    void generate(){
        Integer maxNumber = 10;

        Integer generateNumber = NumberGenerator.generate(maxNumber);

        assertTrue(0<= generateNumber  && generateNumber <maxNumber);
    }
}
