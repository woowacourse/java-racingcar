package racing.view;

import racing.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
     private static final String RESULT = "실행 결과";

     public void printResult(List<String> result){
         System.out.println(RESULT);
         System.out.println(String.join("\n", result));
     }
}
