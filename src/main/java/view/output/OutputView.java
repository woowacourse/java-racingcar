package view.output;

public class OutputView {

    static private void print(PrintMessages message) {
        System.out.println(message.getContent());
    }

    static public void printEnterCarNames() {
        print(PrintMessages.ENTER_CAR_NAMES);
    }
}
