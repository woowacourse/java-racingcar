package racingcar.view;

import java.util.List;

public class TestInputView implements InputView {
    public List<String> readCarNames() {
        return List.of("미아", "메이슨");
    }

    public int readTryCount() {
        return 3;
    }

    public void closeResource() {
    }
}
