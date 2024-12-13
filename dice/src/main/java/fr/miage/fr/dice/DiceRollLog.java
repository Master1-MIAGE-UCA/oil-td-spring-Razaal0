package fr.miage.fr.dice;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
public class DiceRollLog {
    @Id
    @GeneratedValue
    private int id;
    private int diceCount;

    @ElementCollection
    private List<Integer> results;
    private LocalDateTime timestamp;

    public DiceRollLog() {
    }

    public DiceRollLog(int diceCount, List<Integer> results, LocalDateTime timestamp) {
        this.diceCount = diceCount;
        this.results = results;
        this.timestamp = timestamp;
    }
}
