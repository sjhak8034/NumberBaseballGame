package game.numberbaseball;

import Input.InputHelper;
import game.Game;
import game.log.GameLog;
import game.log.GameLogPrinter;

import java.util.List;

public class NumberBaseballStarter implements Game<GameLogPrinter> {
    private final int level;

    public NumberBaseballStarter() {
        InputHelper inputHelper = new InputHelper();
        this.level = inputHelper.getUserInputForLevel();
    }
    @Override
    public void saveLog(GameLog gameLog, List<Integer> answer, List<Integer> userTry) {
        for (int i = 0; i < this.level; i++) {
            if (answer.get(i) == userTry.get(i)) {
                gameLog.incrementStrike();
            } else if (answer.contains(userTry.get(i))) {
                gameLog.incrementBall();
            }
        }

    }
    @Override
    public void displayResult(GameLog gameLog) {
        if (gameLog.isCorrect()) {
            System.out.println("축하합니다 정답입니다!");

        } else if (gameLog.isOut()) {
            System.out.println("아웃");

        } else {
            gameLog.printStrikeBall();
        }
        System.out.println("");
    }
    @Override
    public GameLog createGameLog(List<Integer> answer, List<Integer> userTrial) {
        GameLog gameLog = new GameLog(level, userTrial, answer);
        saveLog(gameLog, answer, userTrial);
        return gameLog;
    }

    @Override
    public GameLogPrinter playGame() {
        GameLogPrinter log = new GameLogPrinter();
        InputHelper inputHelper = new InputHelper();
        AnswerGenerator answerGenerator = new AnswerGenerator(this.level);
        List<Integer> answer = answerGenerator.generateAnswer();


        while (true) {
            // 로그생성 -> 로그 프린터에 로그 클래스 저장
            List<Integer> userTrial = inputHelper.getUserInputForTrial(this.level);
            GameLog gameLog = createGameLog(answer, userTrial);

            log.append(gameLog);
            displayResult(gameLog);

            if(gameLog.isCorrect()){
                break;
            }
        }
        return log;
    }
}
