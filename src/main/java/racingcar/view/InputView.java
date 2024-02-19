package racingcar.view;

import java.util.List;

public interface InputView {
    public List<String> readCarNames();
    public int readTryCount();
    public void closeResource();
}
