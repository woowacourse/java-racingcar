package racingcar.view.outputview;

import racingcar.model.car.Cars;

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
    }

    abstract void initialCarsErrorMessage();

    abstract void initialCarErrorMessage();

    abstract void initialTrackErrorMessage();

    public abstract void printCurrentCarsPosition(Cars cars);

    public abstract void printWinnerCars(Cars cars);

    protected void insertErrorMessage(int errorNumber, String errorMessage) {
        errorMessageTable.put(errorNumber, errorMessage);
    }

    ;

    public void printErrorMessage(int errorNumber) {
        System.out.println(errorMessageTable.get(errorNumber));
    }

}
