package Games.NumberBaseballGame;

import java.util.*;

public class AnswerGenerator {

    Random rand = new Random();
    private final Set<Integer> answer = new HashSet<>();

    AnswerGenerator(int digits) {

        while (answer.size() < digits) {
            answer.add(rand.nextInt(1,10));
        }

    }

    public List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>(this.answer);
        Collections.shuffle(answer);
        return answer;
    }

}
