package racingcar.view;

public class OutputView {

    private static final String CAR_POSITION_SIGN = "-";
    private static final String COLON = " : ";
    public void printPosition(String name, int position) {
        System.out.print(name + COLON + CAR_POSITION_SIGN.repeat(position));
    }
}
