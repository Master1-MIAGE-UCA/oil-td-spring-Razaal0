package fr.miage.fr.dice.service;

import fr.miage.fr.dice.Dice;
import fr.miage.fr.dice.DiceRollLog;
import fr.miage.fr.dice.DiceRollLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DiceService {

    private final Dice dice;
    private final DiceRollLogRepository diceRollLogRepository;

    @Autowired
    public DiceService(Dice dice, DiceRollLogRepository diceRollLogRepository) {
        this.dice = dice;
        this.diceRollLogRepository = diceRollLogRepository;
    }

    public List<Integer> rollSingleDice() {
        List<Integer> results = new ArrayList<>();
        results.add(dice.roll());
        return results;
    }

    public List<Integer> rollMultipleDices(int count) {
        List<Integer> results = dice.rollMultiple(count);
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(count);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        diceRollLogRepository.save(log);
        return results;
    }

    public List<DiceRollLog> getDiceLogs() {
        return diceRollLogRepository.findAll();
    }
}
