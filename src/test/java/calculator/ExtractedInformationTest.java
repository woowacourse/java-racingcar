package calculator;

import calculator.model.ExtractedInformation;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

public class ExtractedInformationTest {

    @Test
    void ExtractorClassTest() {
        List<String> test = Arrays.asList("2", "+", "3", "*");
        assertThrows(IllegalArgumentException.class, ()-> {
            ExtractedInformation extractedInfo = new ExtractedInformation(test);
        });
    }

    @Test
    void ExtractorClassTest2() {
        List<String> test = Arrays.asList("a", "+", "b");
        assertThrows(IllegalArgumentException.class, ()-> {
            ExtractedInformation extractedInfo = new ExtractedInformation(test);
        });
    }

    @Test
    void ExtractorClassTest3() {
        List<String> test = Arrays.asList("0", "/", "3");
        assertThrows(IllegalArgumentException.class, ()-> {
            ExtractedInformation extractedInfo = new ExtractedInformation(test);
        });
    }

    @Test
    void ExtractorClassTest4() {
        List<String> test1 = Arrays.asList("1", "+", "3");
        List<String> test2 = Arrays.asList("1", "+", "3");
        assertThat(new ExtractedInformation(test1)).isEqualTo(new ExtractedInformation(test2));
    }

}
