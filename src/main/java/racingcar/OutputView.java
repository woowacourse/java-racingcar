package racingcar;

public class OutputView {
    public void printResultPrompt() {
        System.out.println("실행 결과");
    }

    public void printResult(String name, int position) {
        System.out.println(name + " : " + "-".repeat(position));
    }

}
