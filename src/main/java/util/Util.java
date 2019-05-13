package util;

import domain.Const;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 공통으로 사용되는 기능들을 모아놓은 클래스
 *
 * @author heebg
 * @version 1.0 2019-05-08
 */
public class Util {
    /**
     * 범위 내의 임의의 정수 반환
     * <br> 범위 : 0 ~ Const.RANGE_RAN_NUM
     *
     * @return 랜덤 숫자
     */
    public static int getRandomNumber() {
        return new Random().nextInt(Const.RANGE_RAN_NUM);
    }

    /**
     * 이름 유효성 검사 후 값 반환
     * <br> 유효성에서 문제가 있을 경우 예외 발생
     *
     * @param name 이름
     * @return 이름
     * @throws IllegalArgumentException 문제가 있을 경우
     */
    public static String checkCarNames(String name) {
        List<String> names = Arrays.asList(name.split(","));
        names.replaceAll(String::trim);
        checkStringListSize(names);
        checkDuplicatedStringList(names);
        checkCarNameRange(names);
        return name;
    }

    /**
     * 중복값이 있는지 확인
     * <br> 중복된 값이 있으면 예외 발생
     *
     * @param strList 확인할 데이터들
     * @throws IllegalArgumentException 중복이 있는 경우
     */
    public static void checkDuplicatedStringList(List<String> strList) {
        List<String> tempList = new ArrayList<>();
        for (String str : strList) {
            if (tempList.contains(str)) {
                throw new IllegalArgumentException(Const.EX_NAME_DUPLE);
            }
            tempList.add(str);
        }
    }

    /**
     * 길이가 0인지 확인
     * <br> 길이가 0이면 예외 발생
     *
     * @param stringList 확인할 데이터
     * @throws IllegalArgumentException 길이가 0일 경우
     */
    public static void checkStringListSize(List<String> stringList) {
        if (stringList.size() == Const.ZERO) {
            throw new IllegalArgumentException(Const.EX_NAME_LEN);
        }
    }

    /**
     * 이름 길이가 최소/최대값 이내인지 확인
     * <br> 범위에 없으면 예외 발생
     *
     * @param names 확인할 이름들
     * @throws IllegalArgumentException 범위에 없을 경우
     */
    public static void checkCarNameRange(List<String> names) {
        for (String name : names) {
            if (name.length() < Const.MIN_NAME_LEN || name.length() > Const.MAX_NAME_LEN) {
                throw new IllegalArgumentException(Const.EX_NAME_LEN);
            }
        }
    }

    /**
     * 횟수 유효성 확인 후 값 반환
     * <br> 유효성에 문제가 있을 시 예외 발생
     *
     * @param roundCount 횟수
     * @return 횟수
     * @throws IllegalArgumentException 유효성에 문제가 있을 경우
     */
    public static int checkRoundCount(int roundCount) {
        checkRoundCountRange(roundCount);
        return roundCount;
    }

    /**
     * 횟수가 최소 이하인지 확인
     * <br> 최소 이하면 예외 발생
     * <br> (최소 : Const.MIN_ROUND_COUNT)
     *
     * @param roundCnt 횟수
     * @throws IllegalArgumentException 최소 이하일 경우
     */
    public static void checkRoundCountRange(int roundCnt) {
        if (roundCnt <= Const.MIN_ROUND_COUNT) {
            throw new IllegalArgumentException(Const.EX_ROUND_COUNT);
        }
    }
}
