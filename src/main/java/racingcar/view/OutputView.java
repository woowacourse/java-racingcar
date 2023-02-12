package racingcar.view;

public class OutputView {

    private static OutputView outputView;
    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printOutputFormat(String format) {
        System.out.println(format);
    }
}
