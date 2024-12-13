package fr.miage.fr.dice;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;


@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
