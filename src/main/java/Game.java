public class Game {

    private Hangman hangman;
    private Console console;

    public Game(){
        this.console = new Console();
        this.hangman = null;
    }

    public Console getConsole() {
        return console;
    }

    public Hangman getHangman() {
        return hangman;
    }

    public void setHangman(Hangman hangman){
        this.hangman = hangman;
    }


    public boolean checkIfValidInput(String input) {
        if (input.matches(".*\\d.*")) {
            this.console.writeOutput("Input cannot contain numbers.");
            return false;
        }

        if ((input == null) || input.isBlank()) {
            this.console.writeOutput("Input is empty.");
            return false;
        }
        return true;
    }



}