package game.numberbaseball;

import game.Game;
import game.log.GameLog;
import game.log.GameLogger;
import Input.Input;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballStarter implements Game<GameLogger> {

    private final int level;

    public NumberBaseballStarter() {
        Input input = new Input();
        this.level = input.getLevel();
    }

    private void getResult(GameLog gameLog, List<Integer> answer, ArrayList<Integer> userTry) {
        for (int i = 0; i < this.level; i++) {
            if (answer.get(i) == userTry.get(i)) {
                gameLog.incrementStrike();
            } else if (answer.contains(userTry.get(i))) {
                gameLog.incrementBall();
            }
        }

    }
    public boolean displayResult(GameLog gameLog) {
        if (gameLog.isCorrect()) {
            System.out.println("축하합니다 정답입니다!");
            System.out.println("");
            return true;
        } else if (gameLog.isOut()) {
            System.out.println("아웃");
            System.out.println("");

        } else {
            gameLog.printStrikeBall();
            System.out.println("");
        }
        return false;
    }
    @Override
    public GameLogger playGame() {
        GameLogger log = new GameLogger();
        Input input = new Input();
        AnswerGenerator answerGenerator = new AnswerGenerator(this.level);
        List<Integer> answer = answerGenerator.getAnswer();

        boolean finish = false;
        do {
            GameLog gameLog = new GameLog(level);
            ArrayList<Integer> userTry = input.getUserTry(this.level);

            getResult(gameLog, answer, userTry);
            log.append(gameLog);
            finish = displayResult(gameLog);
        }while (!finish);
        return log;
    }
}
