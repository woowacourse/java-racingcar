package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    //문자열 입력 -> 파싱 -> 밸리데이션 -> 리스트 스트링으로 반환
    private final Scanner scanner = new Scanner(System.in);//유틸로 빼기

    public List<String> readCarNames() {
        String carNames = scanner.nextLine();
        return Arrays.stream(carNames.split(",")).toList();
    }

    public String readTryCount() {//readme 추가 필요(숫자가 아닌 경우)
        return scanner.nextLine();
    }
}
