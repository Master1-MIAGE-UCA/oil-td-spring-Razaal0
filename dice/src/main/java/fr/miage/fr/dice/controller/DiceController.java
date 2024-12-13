package fr.miage.fr.dice.controller;


import fr.miage.fr.dice.Dice;
import fr.miage.fr.dice.DiceRollLog;
import fr.miage.fr.dice.DiceRollLogRepository;
import fr.miage.fr.dice.service.DiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/dice")
public class DiceController {

    private final DiceService diceService;

    @Autowired
    public DiceController(Dice dice, DiceRollLogRepository diceRollLogRepository, DiceService diseService, DiceService diceService) {
        this.diceService = diceService;
    }

    @GetMapping("/rollDice")
    public List<Integer> rollDice() {
        return diceService.rollSingleDice();
    }

    @GetMapping("/rollDices/{count}")
    public List<Integer> rollMultipleDices(@PathVariable int count) {
        return diceService.rollMultipleDices(count);
    }

    @GetMapping("/diceLogs")
    public List<DiceRollLog> getAllDiceLogs() {
        return diceService.getDiceLogs();
    }
}
