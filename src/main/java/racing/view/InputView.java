package racing.view;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    static private String requestString() {
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println("잘못된 문자열 입력입니다.");
            return requestString();
        }
    }

    static private int requestInt() {
        try {
            return Integer.parseInt(requestString());
        } catch (Exception e) {
            System.out.println("잘못된 정수 입력입니다.");
            return requestInt();
        }
    }

    static public List<String> requestNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String namesString = requestString();
        List<String> namesList = Arrays.asList(namesString.split(",")).stream()
                .map(s -> s.trim())
                .collect(Collectors.toList());

        try {
            validateNamesString(namesString);
            validateNamesList(namesList);
            return namesList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return requestNames();
        }
    }

    static private boolean validateNamesString(String userInput) {
        // ","가 두개 이상 연달아 있으면 안 된다.
        if (userInput.contains(",,")) {
            throw new IllegalArgumentException("','가 두개 이상 연달아 있으면 안 됩니다.");
        }

        return true;
    }

    static private boolean validateNamesList(List<String> names) {
        // 이름이 공백으로만 이루어지면 안 된다.
        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            String s = it.next();
            if (s.length() == 0) {
                throw new IllegalArgumentException("이름이 공백으로만 이루어질 수 없습니다.");
            }
        }
        return true;
    }

    static public int requestNumTrials(){
        System.out.println("시도할 회수는 몇회인가요?");
        return requestInt();

    }
}
