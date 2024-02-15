package view;

import domain.CarNameCatalog;
import domain.Name;
import domain.RaceCount;
import util.Splitter;

import java.util.List;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public CarNameCatalog inputCarNameCatalog(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String originalValue = scanner.next();
        List<String> splitValue = Splitter.splitWithComma(originalValue);


        List<Name> names = splitValue
                .stream()
                .map(Name::new)
                .toList();

        return new CarNameCatalog(names);
    }

    public RaceCount inputRaceCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        Integer raceCount= scanner.nextInt();
        return new RaceCount(raceCount);
    }

}
