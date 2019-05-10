
단위테스트 강의 요약
- 테스트 코드는 프러덕션 코드와 동일한 디렉터리 구조를 가져야 한다. -> 굳이 임포트 안해도 되기 때문에 편리하다.
- psvm, sout 템플릿 -> boilerplate code shortcut
- assertThat() -> jUnit 보다 더 많은 기능을 제공. assertj 라는 외부 라이브러리로 사용 가능하다.
- static import 하면 클래스를 임포트 하지 않고 클래스의 static 메소드만 임포트 가능. -> import Assertions; Assertions.assertThat() vs import static Assertion.assertThat; assertThat()
- 불필요한 로컬 변수는 제거한다. (e.g., 한 번만 쓰이는 로컬 변수)
- 테스트코드 간에도 중복이 생길 수 있다. 중복을 없애라.
- 테스트코드 간의 의존관계가 존재해서는 안 된다. 모든 테스트케이스는 독립적이어야 한다. (BeforeEach, AfterEach 에서 each 가 의미하는 것.)
- 입력 출력은 단위테스트하지 않는다. (어려움)
- 입력이 잘 들어왔다고 가정하고 핵심 로직을 먼저 작성하고, 단위테스트를 추가한다.

# java-racingcar
자동차 경주 게임 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)