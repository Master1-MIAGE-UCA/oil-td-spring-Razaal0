package fr.miage.fr.dice;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Dice {

    public int roll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public List<Integer> rollMultiple(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("1 dé minimum");
        }
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(roll());
        }
        return results;
    }
}
