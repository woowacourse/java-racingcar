# 🐣기능목록

## 자동차 이름 입력

- 예외 처리(5자 초과) - Controller#handleError()

## 횟수 입력

- 예외 처리 (문자, 음수, int 범위를 넘어가는 수 입력) - Controller#handleError()

## 로직

1. 0~9까지 random값을 뽑음 - RandomNumberPicker#pick()
2. random값이 4이상이면 전진한다 - RacingStatus#move()
3. (1),(2)를 차 개수만큼 반복 - Controller#raceOneTrack()
4. (4): 진행상황 출력 - OutputView#printStatus()
5. (3),(4)를 총 반복회수만큼 반복한다 - Controller#raceTracks()

## 결과 출력

- 우승자 출력 - OutputView#printWinner()




