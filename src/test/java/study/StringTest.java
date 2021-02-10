package study;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    
    @Test
    void split() {
        
        // given
        String input = "1";
        
        // when
        String[] values = input.split(",");
        
        // then
        assertThat(values).containsExactly("1");
    }
    
    @Test
    void subString() {
        
        // given
        String input = "(1,2)";
        
        // when
        String subbedInput = input.substring(1, 4);
        
        // then
        assertThat(subbedInput).isEqualTo("1,2");
    }
    
    @Test
    void charAt() {
        
        // given
        String input = "abc";
        
        // when
        char charAt = input.charAt(0);
        
        // then
        assertThat(charAt).isEqualTo('a');
    }
    
    @Test
    void charAt_IndexOutOfBounds() {
        
        // given
        String input = "abc";
        
        // when
        ThrowableAssert.ThrowingCallable callable = () -> input.charAt(3);
        
        // then
        assertThatThrownBy(callable).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
