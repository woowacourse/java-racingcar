# 문자열 계산기
1. 문자열 입력받기
2. 문자열 나누기
3. 부분 계산 하기
4. 전체 계산하기
5. 계산결과 출력하기


# java-racingcar 기능 구현 목록
### Model
1. Car
- 입력된 수에 따라서 이동

2. RacingGame
- String으로 입력된 자동차 목록 분리
- 분리된 자동차 목록으로 자동차 객체들 생성
- 1~9사이의 난수를 생성하여 4이상인지 판단하여 Car객체에 이동 요청

3. WinningCarsFinder
- 입력받은 자동차 목록에서 우승자들을 찾아 반환


### View
1. InputView
   - 사용자로부터 자동차 목록 입력받아 컨트롤러에 전달
   - 사용자로부터 시도할 횟수를 입력받아 컨트롤러에 전달
2. OutputView
   - 컨트롤러로 부터 받은 이름과 위치 출력
   - 컨트롤러로 부터 받은 우승자 이름 목록 출력
   
### Controller
- InputView에 자동차 목록 요청해서 RacingGame에 전달
- InputView에 시도할 횟수를 요청해서 RacingGame에 전달
- RacingGame에 경기 진행을 요청 후 받은 결과를 OutputView에 전달

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
