# java-racingcar
자동차 경주 게임 미션 저장소



## 1. TDD - 문자열 덧셈 계산기

### 기능목록

1. 문자열 계산 : 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열이 있다. 이 문자열을 구분자로 분리하고 각 숫자의 합을 반환한다.

2. 커스텀 구분자 지정 : 앞의 구분자(쉼표, 콜론)외에도 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

   > 예시 : "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

3. 예외 처리 : 문자열 계산기에 숫자 이외에 값 또는 음수를 전달할 경우 RuntimeException 예외를 throw한다.

### 프로그래밍 요구사항

1. indent depth : 1단계.
2. 메소드 크기의 최대 라인 : 10라인.
3. else문 사용 금지.



## 2. 자동차 경주 게임 요구사항

### 기능 요구사항

1. 주어진 횟수동안 n대의 자동차는 전진할 수 있다. 
2. 주어진 횟수동안 n대의 자동차는 멈출 수 있다.
3. 각 자동차에 이름을 부여할 수 있다. 
4. 자동차의 이름은 쉼표(,)를 기준으로 구분한다.
5. 자동차의 이름은 5자 이하만 가능하다.
6. 전진하는 자동차를 출력할 수 있다. 자동차를 출력할 때, 자동차 이름을 같이 출력한다.
7. 사용자는 몇 번의 이동을 할 것인지 입력할 수 있어야 한다.
8. 0에서 9사이에서 random 값을 구한다.
9. random값이 4이상일 경우 전진한다. 
10. random값이 3이하일 경우 멈춘다.
11. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
12. 시작 문구를 출력한다.
    - 시작 문구는 '경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).'이다.
13. 사용자의 입력을 받는다.



### 프로그래밍 요구사항

1. 모든 로직에 단위테스트를 구현한다. 단, UI로직은 제외한다.

2. 자바 코드 컨벤션을 지키면서 프로그래밍한다.

3. indent(들여쓰기) depth를 3을 넘지 않도록 구현한다. 2까지만 허용한다.

4. else 예약어를 쓰지 않는다.

5. 함수의 길이가 15라인을 넘어가지 않도록 구현한다.

   

### 기능 목록 및 commit 로그 요구사항

1. 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
2. git의 commit 단위는 앞 단계에서 REAME.md 파일에 정리한 기능 목록 단위로 추가한다.



## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)