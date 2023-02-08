package view;

import java.io.IOException;

import static constant.Constants.READ_CAR_NAMES;
import static constant.Constants.READ_NUMBER_OF_TRY;

public class OutputView {
    public void readCarNames() {
        print(READ_CAR_NAMES);
    }

    public void readNumberOfTry() {
        print(READ_NUMBER_OF_TRY);
    }

    public void printException(IOException ioException) {
        print(ioException.getMessage());
    }

    private void print(String value) {
        System.out.println(value);
    }
}
