package racingGame.controller;

import racingGame.view.OutputView;

import java.util.List;

public class Output {
    public static void makeCarLog(String name, int position){
        StringBuilder log = new StringBuilder(name);
        log.append(" : ");
        for(int i=0;i<position;i++){
            log.append("-");
        }
        OutputView.printLog(log.toString());
    }

    public static void makeWinnerNames(List<String> names){
        String winnerNames = String.join(",", names);
        OutputView.printWinners(winnerNames);
    }
}
