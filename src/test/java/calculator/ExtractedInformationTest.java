package calculator;

import calculator.model.ExtractedInformation;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

public class ExtractedInformationTest {

    @Test
    void 식과_숫자수가_맞지_않을때_테스트() {
        List<String> test = Arrays.asList("2", "+", "3", "*");
        assertThrows(IllegalArgumentException.class, ()-> {
            ExtractedInformation extractedInfo = new ExtractedInformation(test);
        });
    }

    @Test
    void 숫자가_아닐때_테스트() {
        List<String> test = Arrays.asList("a", "+", "b");
        assertThrows(IllegalArgumentException.class, ()-> {
            ExtractedInformation extractedInfo = new ExtractedInformation(test);
        });
    }

    @Test
    void 영_으로_나눌때_테스트() {
        List<String> test = Arrays.asList("3", "/", "0");
        assertThrows(IllegalArgumentException.class, ()-> {
            ExtractedInformation extractedInfo = new ExtractedInformation(test);
        });
    }

    @Test
    void 생성_테스트() {
        List<String> test1 = Arrays.asList("1", "+", "3");
        List<String> test2 = Arrays.asList("1", "+", "3");
        assertThat(new ExtractedInformation(test1)).isEqualTo(new ExtractedInformation(test2));
    }

}
