package edu.eci.cvds;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
@Component
@ManagedBean(name = "guessBean")
@ApplicationScoped
public class guessBean implements Serializable{
    @Autowired
    GuessService guess;
    private int guessNumber;
    private int numberAttemp;
    private int attempts;
    private int prize;
    private int fullPrize;
    private String state;
    private ArrayList<Integer> numbers;
    public guessBean(){
        restart();
    }
    public int getAttempts(){
        return attempts;
    }
    public int getPrize(){
        return prize;
    }
    public int getGuessNumber(){
        return guessNumber;
    }
    public String getState(){
        return state;
    }
    public int getNumberAttemp(){
        return numberAttemp;
    }
    public void setNumberAttemp(int numberAttemps){
        numberAttemp = numberAttemps;
    }
    public void setAttempts(int newAttempt){
        attempts = newAttempt;
    }
    public void setPrize(int newPrize){
        prize = newPrize;
    }
    public void setGuessNumber(){
        Random random = new Random();
        guessNumber = random.nextInt(100) + 1;
    }
    public void setState(String newState){
        state = newState;
    }
    public void guess() {
        if (prize == 0) {
            state = "Reinicie el juego";
        }
        else if (numberAttemp == guessNumber) {
            state = "Has ganado " + String.valueOf(prize) + "$";
        }
        else {
            attempts++;
            numbers.add(numberAttemp);
            prize -= 10000;
            if (prize == 0) {
                state = "Has perdido";
            }
        }
    }
    public ArrayList<Integer> getNumbers(){
        return numbers;
    }
    @Bean
    public CommandLineRunner currentPrice() throws Exception {
        return args -> {
            guess.addGuess(new Guess("Premio","100000"));
            guess.getAllGuess().forEach(configutationB -> System.out.println(configutationB));
            fullPrize = Integer.parseInt(guess.getGuess("Premio").getValor());
            restart();
        };
    }
    public void restart() {
        attempts = 0;
        numbers = new ArrayList<>();
        prize = fullPrize;
        state = "Jugando";
        Random random = new Random();
        guessNumber = random.nextInt(100) + 1;
    }    
}