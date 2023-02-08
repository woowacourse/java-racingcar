# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

---
# 기능목록
- [ ] 자동차 이름을 입력받는 기능 InputView#readCarName
  - [ ] 이름 파싱 (쉼표로 구분한다) Parser#parsing
- [ ] 시도할 횟수를 입력받는 기능 InputView#readTryCount
- [ ] 경주 RacingCarGame
  - [ ] 랜덤 값 생성 (0~9 사이의 수) RandomNumberGenerator#getNumber
  - [ ] 전진 여부 판단 (4 이상일 경우 전진) AdvanceJudgement#getJudgementResult
  - [ ] 자동차 전진 (자동차 포인트 증가) RacingCar#advance
  - [ ] 실행 결과 출력 OutputView#printRoundResult
- [ ] 최종 결과 출력 OutputView#printGameResult

# 예외처리
- [ ] 자동차 이름을 입력받는 기능 
  - [ ] 이름은 1~5자만 가능하다
  - [ ] 중복
- [ ] 시도할 횟수를 입력받는 기능
  - [ ] 숫자만 가능 (자연수)