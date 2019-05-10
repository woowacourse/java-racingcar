# 문자열 계산기
1. 문자열 입력받기
2. 문자열 나누기
3. 부분 계산 하기
4. 전체 계산하기
5. 계산결과 출력하기


# java-racingcar 기능 구현 목록

### View에 필요한 메소드

- InputView
   - 사용자로부터 자동차 목록 입력받아 컨트롤러에 전달
   - 사용자로부터 시도할 횟수를 입력받아 컨트롤러에 전달
- OutputView
   - 컨트롤러로 부터 받은 이름과 위치 출력
   - 컨트롤러로 부터 받은 우승자 이름 목록 출력

### Controller에 필요한 메소드

- InputView에 자동차 목록 요청하기
- RacingGame 객체에 자동차 목록 만들기
- InputView에 시도할 횟수를 요청
- 레이싱 게임 진행
    - RacingGame 객체에 레이싱 게임 진행 하도록 요청
- WinningCarsFinder에 우승자 목록 요청
- OutputView에 우승자 목록 출력 요청

### Model에 필요한 메소드
- Car
    - Car객체의 이름 글자 수 제한(5자) 판단
    - Car객체의 position 1증가시키기 (랜덤넘버 받아서)
    - 현재 위치와 비교하기
        - 같은 위치
        - 더 먼 위치
- RacingGame
    - 받은 입력에서 공백 제거
    - 연속된 콤마일 경우 예외 처리
    - 콤마를 기준으로 String 분리
    - 최소 입력 횟수 예외 처리
    - 각 실행 횟수에 대한 리스트 저장
        - 난수 생성 후 전진/정지

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
