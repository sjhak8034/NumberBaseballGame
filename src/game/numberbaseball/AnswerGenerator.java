package game.numberbaseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AnswerGenerator {


    Set<Integer> answer;

    AnswerGenerator(int digits) {
        this.answer = new HashSet<>();
        while (answer.size() < digits) {
            Random rand = new Random();
            answer.add(rand.nextInt(1,10));
        }

    }

    public List<Integer> generateAnswer() {
        return new ArrayList<>(this.answer);
    }

}
