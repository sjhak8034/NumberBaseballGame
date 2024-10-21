package GameV1;

import java.util.*;

public class AnswerGenerator {
    private int digits;
    Random rand = new Random();
    private Set<Integer> answer = new HashSet<>();

    AnswerGenerator(int digits) {
        this.digits = digits;
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
