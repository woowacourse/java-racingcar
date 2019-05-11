package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.CarDto;
import com.woowacourse.javaracingcar.interfaces.OutputView;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    private boolean isResultTitlePrinted;

    public ConsoleOutputView() {
        isResultTitlePrinted = false;
    }

    @Override
    public void printResult(List<CarDto> cars) {
        // "실행 결과" 는 한번만 출력돼야 함.
        if (!isResultTitlePrinted) {
            System.out.println("실행 결과");
            isResultTitlePrinted = true;
        }

        for (CarDto c : cars) {
            System.out.println(carToString(c));
        }

        System.out.println();
    }

    public String carToString(CarDto car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append('-');
        }

        return sb.toString();
    }

    @Override
    public void printWinners(List<CarDto> winners) {
        String str = RacingcarUtil.joinCarNames(winners);
        System.out.println(str + "가 최종 우승했습니다.");
    }
}
