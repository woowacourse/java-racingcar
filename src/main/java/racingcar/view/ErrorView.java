package racingcar.view;

public class ErrorView {
    public static void invalidText() {
        System.out.println("문자 외의 이름은 입력될 수 없습니다.\n");
    }

    public static void invalidNameLength(int maxLength) {
        System.out.println("길이는 1 이상 " + maxLength + " 이하이어야합니다.\n");
    }
}
