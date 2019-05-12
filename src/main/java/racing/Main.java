/*
 * @(#)Main.java
 *
 * v 1.0.0
 *
 * 2019.05.09
 *
 * Copyright (c) 2019 MrKwon, imkimheejoo.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing;

import racing.domain.RacingGame;
import racing.domain.RacingGameResult;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 레이싱 게임의 Entry Point 가 있는 클래스
 *
 * @author imkimheejoo
 * @author MrKwon
 * @version 1.0.0
 * @see InputView
 */
public class Main {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.inputCarNames(), InputView.inputExecution());
        RacingGameResult racingGameResult = racingGame.playRacing();
        OutputView.printRacingResult(racingGameResult);
        OutputView.printAllWinners(racingGameResult);

//       List<A> aList = new ArrayList<>();
//        for(int i=0; i<5; i++){
//            List<Integer> list = new ArrayList<>();
//            list.add(i);
//            aList.add(new A(list));
//        }
//        System.out.println(aList.get(0).list);
//        System.out.println(aList.get(3).list);
    }
    static class A{
        List<Integer> list;

        A(List<Integer> list) {
            this.list = list;
        }
    }
}
