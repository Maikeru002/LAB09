package edu.eci.cvds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuessService {
    private final GuessRepository guessRepository;
    @Autowired
    public GuessService(GuessRepository guessService){
        this.guessRepository = guessService;
    }
    public Guess addGuess(Guess guess){
        return guessRepository.save(guess);
    }
    public Guess getGuess (String Property){
        return guessRepository.findById(Property);
    }
    public List<Guess> getAllGuess(){
        return guessRepository.findAll();
    }
    public Guess updateGuess(Guess guess){
        if(guessRepository.existsById(guess.getId())){
            return guessRepository.save(guess);
        }
        return null;
    }

    public void deleteConfiguration(Long Property){
        guessRepository.deleteById(Property);
    }

}