package racingcar.view;

public class ErrorView {
    public static void invalidText() {
        System.out.println("문자 외의 이름은 입력될 수 없습니다.");
    }

    public static void invalidNameLength(int maxLength) {
        System.out.println("길이는 1 이상 " + maxLength + " 이하이어야합니다.");
    }

    public static void duplicateName() {
        System.out.println("이름이 중복됩니다.");
    }

    public static void notEnoughCar(int number) {
        System.out.println("자동차가 " + number + "대 이상이어야 합니다.");
    }

    public static void invalidTime() {
        System.out.println("횟수는 자연수이어야합니다.\n");
    }
}
