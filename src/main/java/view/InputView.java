package view;

import utils.Converter;
import vo.Name;
import vo.Trial;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String ASKING_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).";
    public static final String SEPARATOR = ",";
    public static final String ASKING_TRIAL_MESSAGE = "시도할 횟수는 몇회인가요?";
    Scanner scanner = new Scanner(System.in);

    public List<Name> getCarNames() {
        System.out.println(ASKING_CAR_NAMES_MESSAGE);
        String input = scanner.nextLine();
        return Name.of(Arrays.asList(input.split(SEPARATOR)));
    }

    public Trial getTrial() {
        System.out.println(ASKING_TRIAL_MESSAGE);
        String input = scanner.nextLine();
        return Trial.of(Converter.convertStringToLong(input));
    }
}
