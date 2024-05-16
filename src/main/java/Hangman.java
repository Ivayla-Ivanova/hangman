import java.util.Arrays;

/**
 * Wording:
 * solution                 Lösung (Lösungswort)
 * partlyRevealedSolution   teilweise aufgedeckte Lösung (z.B. "ha--o")
 * hangmanPicture           Bild vom Galgenmännchen
 * guessedCharacter         geratener Buchstabe
 **/
public class Hangman {

    String DASH = "-";
    private String solution;
    private String guess;
    int triesLeft;





    public Hangman(String solution) {
        this.solution = solution;
        this.guess = DASH.repeat(this.solution.length());
        this.triesLeft = 10;
    }

    public String getSolution() {
        return solution;
    }

    public String getPartlyRevealedSolution() {
        return guess;

    }

    public void guessCharacter(char e) {

        StringBuilder temp = new StringBuilder(guess);

        char [] listOfchars = new char[this.solution.length()];

        for(int i = 0; i < listOfchars.length; i++){
            listOfchars[i] = this.solution.charAt(i);
        }
        if(!(this.solution.contains(Character.toString(e)))){
            triesLeft--;


            return;
        }

        for(int i=0; i<listOfchars.length;i++){
            if(listOfchars[i] == e){
                temp.replace(i,i+1, String.valueOf(e));
            }
        }

        guess = temp.toString();


    }

    public String getHangmanState() {
        int falseGuesses = 10 -  triesLeft;
        String picture = HangmanPictures.getPicture(falseGuesses);
        return picture;
    }

    public boolean checkForWinner() {

        if(!guess.contains("-")){
            return true;
        }

        return false;
    }
}
