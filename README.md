# 문자열 계산기

- 입력
    + 올바른 입력인지 검사
        - [예외처리] 시작과 끝은 숫자 -> 다시 요청
        - [예외처리]( 숫자 - 연산자 - 숫자 .... 순서로 ) -> 다시 요청
    + 올바른 입력이면 Queue에 삽입
    
- 계산
    + Queue 처리 과정
        + 먼저 Queue에서 3개를 뽑아서 계산
        + 다음부터는 Queue가 empty할 때까지 2개씩 뽑아서 계산 처리
    + '+'일 경우 덧셈처리
    + '-'일 경우 뺄셈처리
    + '*'일 경우 곱셈처리
    + '/'일 경우 나눗셈처리   
    + [예외처리] 0으로 나눌 때 에러 메세지 전달 후 종료
 
- 결과
    + 계산한 결과 출력

# 자동차 경주 게임
[기능 구현 목록]
- 자동차 이름을 입력받는 기능
    + [예외처리] 입력받은 이름들에 대해 중복, 공백, null, 길이 검사
- 시도할 횟수를 받는 기능
    + [예외처리] 1이상의 정수인지 검사
- 입력받은 이름들로 각각의 Car객체를 생성하여 CarList객체에 List로 저장하는 기능
- 각 시도별로 결과를 출력해주는 기능
    + Random값에 따라 Car의 Position을 이동해주는 기능
    + 이동한 결과를 출력해주는 기능
- 결과 출력 기능
    + maxPosition 구하는 메소드
    + maxPosition에 있는 Car 출력

[TEST목록]
- Car class
    + 자동차 이름 Blank와 Null 검사
    + 자동차 이름 Alphabet 검사
    + 자동차 이름 Length 검사
    + 올바른 자동차 이름 생성 검사
    + 자동차 정지
    + 자동차 이동
    + 자신의 Position이 maxPosition이 맞을 경우
    + 자신의 Position이 maxPosition이 아닐 경우
    + 승리한 차가 List에 추가가 되는지 검사
- WinningCars class
    + 우승한 차의 이름들이 저장되는지 확인
    + 우승하지 않은 차들의 이름들이 저장되지 않는지 확인
- CarList class
   + 자동차 이름 중복 확인
   + 올바른 CarList 생성 확인
- Random class
   + 랜덤수가 0부터 9까지인지 검사


# java-racingcar
자동차 경주 게임 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)