package view;

import java.io.IOException;

import static constant.Constants.READ_CAR_NAMES;

public class OutputView {
    public void readCarNames() {
        print(READ_CAR_NAMES);
    }

    public void printException(IOException ioException) {
        print(ioException.getMessage());
    }

    private void print(String value) {
        System.out.println(value);
    }
}
