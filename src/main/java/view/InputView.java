package view;

import utils.Converter;
import vo.Name;
import vo.Trial;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public List<Name> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return Name.of(Arrays.asList(input.split(",")));
    }

    public Trial getTrial() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = scanner.nextLine();
        return Trial.of(Converter.convertStringToLong(input));
    }
}
