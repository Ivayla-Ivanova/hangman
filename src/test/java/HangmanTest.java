
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HangmanTest {

    @Test
    public void getSolution_returnsSolution() {
        Hangman hangman = new Hangman("admin");
        String solution = hangman.getSolution();
        assertThat(solution).isEqualTo("admin");
    }


    @Test
    public void getPartlyRevealedSolution_returnsDashes_whenThereWereNoGuesses() {
        Hangman hangman = new Hangman("admin");
        String partlyRevealedSolution = hangman.getPartlyRevealedSolution();
        assertThat(partlyRevealedSolution).isEqualTo("-----");
    }

    @Test
    public void guessCharacter_doesNotChangePartlyRevealedSolution_onWrongGuess() {
        Hangman hangman = new Hangman("admin");
        hangman.guessCharacter('e');
        String partlyRevealedSolution = hangman.getPartlyRevealedSolution();
        assertThat(partlyRevealedSolution).isEqualTo("-----");
    }

    @Test
    public void guessCharacter_triesLeftDecrements_onWrongGuess(){
        Hangman hangman = new Hangman("admin");
        hangman.guessCharacter('e');
        assertThat(hangman.triesLeft).isEqualTo(9);
    }
    @Test
    public void checkIfValidInput_inputIsNumber_badInput(){
        String input = "d4d";
        Game game = new Game();
        assertThat(game.checkIfValidInput(input)).isEqualTo(false);

    }
    @Test
    public void checkIfValidInput_inputIsChar_corectInput(){
        String input = "d";
        Game game = new Game();
        assertThat(game.checkIfValidInput(input)).isEqualTo(true);
    }

    @Test
    public void checkIfValidInput_inputIsString_corectInput(){
        String input = "dadsawe";
        Game game = new Game();
        assertThat(game.checkIfValidInput(input)).isEqualTo(true);
    }

    @Test
    public void checkIfPicture_6falseGuesses_correctPicture(){
        Hangman hangman = new Hangman("admin");
        for(int i = 0; i < 6; i++){
            hangman.guessCharacter('e');
        }
        //triesLeft=9
        String erwartetBild = HangmanPictures.getPicture(6);
        assertThat(hangman.getHangmanState()).isEqualTo(erwartetBild);
    }
    @Test
    public void checkForWinner_Winner_correctGuess(){
        Hangman hangman = new Hangman("admin");
        hangman.guessCharacter('a');
        hangman.guessCharacter('d');
        hangman.guessCharacter('m');
        hangman.guessCharacter('i');
        hangman.guessCharacter('l');
        hangman.guessCharacter('n');
        assertThat(hangman.checkForWinner()).isEqualTo(true);

    }

    @Test
    public void checkForWinner_NoWinner_noTriesLeft(){
        Hangman hangman = new Hangman("admin");
        hangman.guessCharacter('a');
        hangman.guessCharacter('d');
        hangman.guessCharacter('m');
        hangman.guessCharacter('i');
        hangman.guessCharacter('l');
        hangman.guessCharacter('z');
        hangman.guessCharacter('d');
        hangman.guessCharacter('d');
        hangman.guessCharacter('d');
        hangman.guessCharacter('z');


        assertThat(hangman.checkForWinner()).isEqualTo(false);

    }



    // Test Driven Development:
    //       1) What else do you want Hangman to do? -> Formulate it as a test.
    //       2) Implement in Hangman what is needed to make the test green.
    //       3) Refactor.
    //       4) Continue at 1)

}
