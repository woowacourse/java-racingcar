package view;

import domain.name.Names;
import domain.name.Name;
import domain.race.RaceCount;
import util.Splitter;

import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public Names inputCarNameCatalog() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String originalValue = scanner.next();
        List<String> splitValue = Splitter.splitWithComma(originalValue);


        List<Name> names = splitValue
                .stream()
                .map(Name::new)
                .toList();

        return new Names(names);
    }

    public RaceCount inputRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        Integer raceCount = scanner.nextInt();
        return new RaceCount(raceCount);
    }

}
