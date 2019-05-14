package racing.view;

import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class InputViewTest {

    @Test(expected = IllegalArgumentException.class)
    public void 구분자_쉼표_에러_확인() {
        InputView.checkIdentifier("andole:baedi");
    }

    @Test
    public void 정상_구분자() {
        String inputString = "andole,baedi";
        ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(input);
        assertEquals(inputString, InputView.inputCarNames());
    }
    
    @After
    public void tearDown() throws Exception {
        System.setIn(System.in);
    }
}
