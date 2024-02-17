package domain;

public class MoveStrategy {

    private final static int MIN_MOVABLE_DIGIT = 4;

    public MoveStrategy() {
    }

    /**
     * int 를 파라미터로 받으면 어떨까??
     * + 테스트하기 편하다.
     *  -> 왜?? -> 제어할 수 있는 값을 넣어주면 되니까.
     *
     * - 그러면 굳이 MoveStrategy 를 구현할 필요가 있나??
     *  -> 왜?? -> int 값에 따라 전진 유무를 결정할거면 굳이 인터페이스로 만들어둘 필요가 있나?
     *  -> 전략은 어떻게 달라질까??
     *      -> 4 이상시 전진이 아니라, 짝수인 경우 전진??
     *      -> 정수가 아닌 값인, 소수 등으로 전진 유무 판단??
     * - 그러면 객체 이름에서 Random 을 빼야한다.
     *  -> Random 여부는 외부에서 받을 것이기 때문에 이 객체에서는 Random 과 관련이 없다.
     *  -> 그러면 이 객체가 존재하는 이유는 무엇일까??
     *      -> 4 이상인 경우에만 전진하는 객체를 만들기 위해??
     *      -> 그러면 굳이 MIN_MOVABLE_DIGIT 으로 상수로 만들 필요가 없을 것이다.(X)
     *          -> 변경사항이 없다면 상수로 만드는 것이 더 좋다.
     */
    public boolean isMove(int target) {
        return MIN_MOVABLE_DIGIT <= target;
    }
}
