package Games.NumberBaseballGame;

import Games.Game;
import UserInput.GetInput;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseball implements Game {

    private int level;

    public NumberBaseball() {
        GetInput getInput = new GetInput();
        this.level = getInput.setLevel();
    }

    private void getResult(CurrentResult currentResult ,List<Integer> answer, ArrayList<Integer> userTry) {


        for (int i = 0; i < this.level; i++) {

            if (answer.get(i) == userTry.get(i)) {
                currentResult.incrementStrike();
            } else if (answer.contains(userTry.get(i))) {
                currentResult.incrementBall();
            }
        }
        if (currentResult.getStrike() == 0 && currentResult.getBall() == 0) {
            currentResult.incrementOut();
        }
        currentResult.incrementScore();

    }
    @Override
    public Integer playGame() {
        GetInput getInput = new GetInput();
        AnswerGenerator answerGenerator = new AnswerGenerator(this.level);
        List<Integer> answer = answerGenerator.getAnswer();
        CurrentResult currentResult = new CurrentResult();

        boolean finish = false;



        while (finish == false) {

            ArrayList<Integer> userTry = getInput.getUserTry(this.level);

            getResult(currentResult,answer, userTry);
            if (currentResult.getStrike() == level) {
                System.out.println("축하합니다 정답입니다!");
                System.out.println("");
                finish = true;
            }
            else if (currentResult.getOut() != 1) {
                System.out.println(currentResult.getBall() + " 볼 " + currentResult.getStrike() + " 스트라이크");
                System.out.println("");

            } else if (currentResult.getOut() == 1) {
                System.out.println("아웃");
                System.out.println("");
            }
            currentResult.resetSBO();

        }
        return currentResult.getScore();
    }
}
