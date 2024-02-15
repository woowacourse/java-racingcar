package racingcar.mock;

import java.util.Arrays;
import java.util.Iterator;
import racingcar.view.InputView;

public class MockInputView extends InputView {

    public final Iterator<String> mockInputs;

    public MockInputView(String... mockInputs) {
        this.mockInputs = Arrays.stream(mockInputs).iterator();
    }

    @Override
    protected String readLine() {
        return mockInputs.next();
    }

}
