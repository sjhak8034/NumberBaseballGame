package Games.NumberBaseballGame;

import Games.Game;
import Games.UserLogs.NumberBaseball_Log;
import UserInput.Input;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseball implements Game<NumberBaseball_Log> {

    private final int level;

    public NumberBaseball() {
        Input input = new Input();
        this.level = input.getLevel();
    }

    private void getResult(CurrentResult currentResult ,List<Integer> answer, ArrayList<Integer> userTry) {
        for (int i = 0; i < this.level; i++) {
            if (answer.get(i) == userTry.get(i)) {
                currentResult.incrementStrike();
            } else if (answer.contains(userTry.get(i))) {
                currentResult.incrementBall();
            }
        }

    }
    @Override
    public NumberBaseball_Log playGame() {
        NumberBaseball_Log log = new NumberBaseball_Log();
        Input input = new Input();
        AnswerGenerator answerGenerator = new AnswerGenerator(this.level);
        List<Integer> answer = answerGenerator.getAnswer();


        boolean finish = false;



        while (!finish) {
            CurrentResult currentResult = new CurrentResult(level);
            ArrayList<Integer> userTry = input.getUserTry(this.level);

            getResult(currentResult,answer, userTry);
            log.append(currentResult);
            if (currentResult.isCorrect()) {
                System.out.println("축하합니다 정답입니다!");
                System.out.println("");
                finish = true;
            }else if (currentResult.isOut()) {
                System.out.println("아웃");
                System.out.println("");
            }
            else {
                currentResult.printStrikeBall();
                System.out.println("");

            }


        }
        return log;
    }
}
