package calculator;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

public class ExtractorTest {

    @Test
    void ExtractorClassTest() {
        List<String> test = Arrays.asList("2", "+", "3", "*");
        assertThrows(IllegalArgumentException.class, ()-> {
            Extractor extractor = new Extractor(test);
        });
    }

    @Test
    void ExtractorClassTest2() {
        List<String> test = Arrays.asList("a", "+", "b");
        assertThrows(IllegalArgumentException.class, ()-> {
            Extractor extractor = new Extractor(test);
        });
    }

    @Test
    void ExtractorClassTest3() {
        List<String> test1 = Arrays.asList("1", "+", "3");
        List<String> test2 = Arrays.asList("1", "+", "3");
        assertThat(new Extractor(test1)).isEqualTo(new Extractor(test2));
    }

}
