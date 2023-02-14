package racingcar.view.outputview;

import java.util.HashMap;

public abstract class OutputView {
    private HashMap<Integer, String> errorMessageTable = new HashMap<>();

    public OutputView() {
        initialErrorMessage();
    }

    protected void initialErrorMessage() {
        initialCarsErrorMessage();
        initialCarErrorMessage();
        initialTrackErrorMessage();
    };

    abstract void initialCarsErrorMessage();

    abstract void initialCarErrorMessage();

    abstract void initialTrackErrorMessage();

    protected void insertErrorMessage(int errorNumber, String errorMessage) {
        errorMessageTable.put(errorNumber, errorMessage);
    };

    public void printErrorMessage(int errorNumber) {
        System.out.println(errorMessageTable.get(errorNumber));
    }
}
