package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import movestrategy.MoveStrategy;
import movestrategy.RandomPowerMoveStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private final MoveStrategy moveStrategy = new RandomPowerMoveStrategy();

    @Test
    @DisplayName("자동차 이름 정상 입력")
    void carNames_ok() {
        Assertions.assertAll(
            () -> new RacingGame("a", moveStrategy),
            () -> new RacingGame("a,bb,cCc,dDdD,eeeee", moveStrategy),
            () -> new RacingGame("a  , bb  , cCc ,    dDdD ,eeeee", moveStrategy)
        );
    }

    @Test
    @DisplayName("자동차 이름 정상 입력: 경계값 입력 - 자동차 100대")
    void carNames_ok_boundaryTest_hundredCases() {
        new RacingGame(
            "a    ,b    ,c    ,d    ,e    ,f    ,g    ,h    ,i    ,j    ,"
                + "k    ,l    ,m    ,n    ,o    ,p    ,q    ,r    ,s    ,t    ,"
                + "u    ,v    ,w    ,x    ,y    ,z    ,aa   ,bb   ,cc   ,dd   ,"
                + "ee   ,ff   ,gg   ,hh   ,ii   ,jj   ,kk   ,ll   ,mm   ,nn   ,"
                + "oo   ,pp   ,qq   ,rr   ,ss   ,tt   ,uu   ,vv   ,ww   ,xx   ,"
                + "yy   ,zz   ,aaa  ,bbb  ,ccc  ,ddd  ,eee  ,fff  ,ggg  ,hhh  ,"
                + "iii  ,jjj  ,kkk  ,lll  ,mmm  ,nnn  ,ooo  ,ppp  ,qqq  ,rrr  ,"
                + "sss  ,ttt  ,uuu  ,vvv  ,www  ,xxx  ,yyy  ,zzz  ,aaaa ,bbbb ,"
                + "cccc ,dddd ,eeee ,ffff ,gggg ,hhhh ,iiii ,jjjj ,kkkk ,llll ,"
                + "mmmm ,nnnn ,oooo ,pppp ,qqqq ,rrrr ,ssss ,tttt ,uuuu ,vvvv"
            , moveStrategy);
    }

    @Test
    @DisplayName("자동차 이름 예외 입력: 자동차 이름에 중복이 있어서는 안 된다.")
    void carNames_exception_noDuplication() {
        assertThatThrownBy(() -> new RacingGame("aa,aa,bb", moveStrategy))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 예외 입력: 입력이 비어 있으면 안 된다.")
    void carNames_exception_noEmptyInput() {
        Assertions.assertAll(
            () -> assertThatThrownBy(() -> new RacingGame("", moveStrategy))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new RacingGame(" ", moveStrategy))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 예외 입력: 쉼표만 입력하면 안 된다.")
    void carNames_exception_onlyComma() {
        assertThatThrownBy(() -> new RacingGame(",,", moveStrategy))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름 예외 입력: 이름은 하나의 쉼표로 구분되어야 한다.")
    void carNames_exception_delimiterViolation() {
        Assertions.assertAll(
            () -> assertThatThrownBy(() -> new RacingGame("a,b.c", moveStrategy))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new RacingGame("a,b,c,,d", moveStrategy))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new RacingGame("a,,b,c,d", moveStrategy))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new RacingGame(",,,a,b", moveStrategy))
                .isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new RacingGame("a,b,,,", moveStrategy))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 예외 입력(5): 1~100개의 이름만 입력 가능하다.")
    void carNames_exception_rangeViolation() {
        assertThatThrownBy(() -> new RacingGame(
            "a    ,b    ,c    ,d    ,e    ,f    ,g    ,h    ,i    ,j    ,"
                + "k    ,l    ,m    ,n    ,o    ,p    ,q    ,r    ,s    ,t    ,"
                + "u    ,v    ,w    ,x    ,y    ,z    ,aa   ,bb   ,cc   ,dd   ,"
                + "ee   ,ff   ,gg   ,hh   ,ii   ,jj   ,kk   ,ll   ,mm   ,nn   ,"
                + "oo   ,pp   ,qq   ,rr   ,ss   ,tt   ,uu   ,vv   ,ww   ,xx   ,"
                + "yy   ,zz   ,aaa  ,bbb  ,ccc  ,ddd  ,eee  ,fff  ,ggg  ,hhh  ,"
                + "iii  ,jjj  ,kkk  ,lll  ,mmm  ,nnn  ,ooo  ,ppp  ,qqq  ,rrr  ,"
                + "sss  ,ttt  ,uuu  ,vvv  ,www  ,xxx  ,yyy  ,zzz  ,aaaa ,bbbb ,"
                + "cccc ,dddd ,eeee ,ffff ,gggg ,hhhh ,iiii ,jjjj ,kkkk ,llll ,"
                + "mmmm ,nnnn ,oooo ,pppp ,qqqq ,rrrr ,ssss ,tttt ,uuuu ,vvvv ,"
                + "aaaaa"
            , moveStrategy)).isInstanceOf(IllegalArgumentException.class);
    }
}
