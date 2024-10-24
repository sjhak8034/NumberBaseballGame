package game.numberbaseball;

import game.Game;
import game.log.GameLog;
import game.log.GameLogPrinterPrinter;
import Input.Input;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballStarter implements Game<GameLogPrinterPrinter> {
    private final int level;

    public NumberBaseballStarter() {
        Input input = new Input();
        this.level = input.getUserInputForLevel();
    }

    private void saveLog(GameLog gameLog, List<Integer> answer, ArrayList<Integer> userTry) {
        for (int i = 0; i < this.level; i++) {
            if (answer.get(i) == userTry.get(i)) {
                gameLog.incrementStrike();
            } else if (answer.contains(userTry.get(i))) {
                gameLog.incrementBall();
            }
        }

    }
    public void displayResult(GameLog gameLog) {
        if (gameLog.isCorrect()) {
            System.out.println("축하합니다 정답입니다!");
            System.out.println("");

        } else if (gameLog.isOut()) {
            System.out.println("아웃");
            System.out.println("");

        } else {
            gameLog.printStrikeBall();
            System.out.println("");
        }

    }
    @Override
    public GameLogPrinterPrinter playGame() {
        GameLogPrinterPrinter log = new GameLogPrinterPrinter();
        Input input = new Input();
        AnswerGenerator answerGenerator = new AnswerGenerator(this.level);
        List<Integer> answer = answerGenerator.getAnswer();

        boolean finish = false;
        while (!finish) {
            // 로그생성 -> 로그 프린터에 로그 클래스 저장
            ArrayList<Integer> userTry = input.getUserInputForTrial(this.level);
            GameLog gameLog = new GameLog(level, userTry, answer);
            saveLog(gameLog, answer, userTry);
            log.append(gameLog);
            displayResult(gameLog);
            finish = gameLog.isCorrect();
        }
        return log;
    }
}
