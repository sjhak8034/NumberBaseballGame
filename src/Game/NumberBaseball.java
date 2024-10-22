package Game;

import GameV1.GetInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberBaseball implements Game {

    private int level;

    public NumberBaseball() {
        GetInput getInput = new GetInput();
        this.level = getInput.setLevel();
    }

    private Map<String, Integer> getResult(Map<String, Integer> tempresult, List<Integer> answer, ArrayList<Integer> userTry) {
        Map<String, Integer> result = new HashMap<>(tempresult);

        for (int i = 0; i < this.level; i++) {

            if (answer.get(i) == userTry.get(i)) {
                int temp = result.get("스트라이크");
                result.replace("스트라이크", temp + 1);
            } else if (answer.contains(userTry.get(i))) {
                int temp = result.get("볼");
                result.replace("볼", temp + 1);
            }
        }
        if (result.get("스트라이크") == 0 && result.get("볼") == 0) {
            result.replace("아웃", 1);
        }
        return result;
    }
    @Override
    public Integer playGame() {
        GetInput getInput = new GetInput();
        AnswerGenerator answerGenerator = new AnswerGenerator(this.level);
        List<Integer> answer = answerGenerator.getAnswer();
        Map<String, Integer> tempresult = java.util.Map.of("스트라이크", 0, "볼", 0, "아웃", 0);
        boolean finish = false;
        int count = 0;
        Map<String, Integer> result = new HashMap<>();
        while (finish == false) {
            count++;
            ArrayList<Integer> userTry = getInput.getUserTry(this.level);

            result = getResult(tempresult, answer, userTry);
            if (result.get("스트라이크") == level) {
                System.out.println("축하합니다 정답입니다!");
                System.out.println("");
                finish = true;
            }
            else if (result.get("아웃") != 1) {
                System.out.println(result.get("볼") + " 볼 " + result.get("스트라이크") + " 스트라이크");
                System.out.println("");

            } else if (result.get("아웃") == 1) {
                System.out.println("아웃");
                System.out.println("");
            }

        }
        return count;
    }
}
