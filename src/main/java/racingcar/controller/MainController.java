package racingcar.controller;

import racingcar.view.Input;

import java.util.Arrays;
import java.util.List;

public class MainController {
    public MainController() {
    }

    public void play(){
        String names = Input.inputCarNames();
        System.out.println(names);

        String tryValue = Input.inputTry();
        System.out.println(tryValue);

        // 검증 (1자 이상, 5자 이하)
        // 배열로 별환
    }

    private List<String> convertNamesToList(String names){
        List<String> splitNames = Arrays.asList(names.split(","));
        for (String name : splitNames) {
            if (name.length() >= 1 && name.length() <= 5) {
                //검증을 하고, 다 통과하면 배열이 정상 반환
            }
        }
        return splitNames;
    }
}
