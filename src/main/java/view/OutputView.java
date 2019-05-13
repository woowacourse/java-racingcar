package view;

import domain.Const;

import java.util.List;

/**
 * 출력 View 클래스
 *
 * @author heebg
 * @version 1.0 2019-05-08
 */
public class OutputView {
    /**
     * 실행 결과 타이틀 출력
     * <br> Const.OUTPUT_GAME_RESULT
     */
    public static void outputGameResultTile() {
        System.out.println(Const.OUTPUT_GAME_RESULT);
    }

    /**
     * 게임 결과 출력
     *
     * @param carsInfo 자동차들 정보
     */
    public static void outputGameResult(List<String> carsInfo) {
        for (String carInfo : carsInfo) {
            System.out.println(carInfo);
        }
        System.out.println();
    }

    /**
     * 우승차 이름 출력
     *
     * @param winners 우승차들 이름
     */
    public static void outputWinners(String winners) {
        System.out.println(winners + Const.OUTPUT_WINNER);
    }
}
