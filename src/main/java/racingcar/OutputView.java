package racingcar;

public class OutputView {

    public static void printDuplicatedCarName(){
        System.out.println("중복된 이름은 안됩니다.\n다시 입력해 주세요.");
    }

    public static void printUnderNameLength() {
        System.out.println("글자 수는 1글자 이상이여야 합니다.\n다시 입력해 주세요.");
    }

    public static void printOverNameLength() {
        System.out.println("글자 수는 5글자 이내여야 합니다.\n다시 입력해 주세요.");
    }
}
