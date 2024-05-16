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

    public static void main(String[] args) {
        // This is where the game starts. Add your code here.
        // Let your Hangman class control the game, let the Console class do the
        // communication with the players.

        Game game = new Game();
        String input;
        char guessedCharacter;

        while (true){
            game.getConsole().writeOutput(" Gebe dein Wort ein Herausfordender.");
            input = game.getConsole().readInput();

            if(checkIfValidInput(input)){
                break;
            }


        }
        game.getConsole().clear();
        game.getConsole().writeOutput("Wort akzeptiert. Ratender kann mit dem Raten beginnen");

        game.setHangman(new Hangman(input.toLowerCase()));


        while (game.getHangman().triesLeft != 0) {

            game.getConsole().writeOutput("Gebe ein Buchstabe ein");

            input = game.getConsole().readInput();
            if(!Game.checkIfValidInput(input)){
              continue;
            }

            guessedCharacter = Character.toLowerCase(input.charAt(0));
            game.getHangman().guessCharacter(guessedCharacter);

            game.getConsole().writeOutput(game.getHangman().getHangmanState());
            game.getConsole().writeOutput(game.getHangman().getPartlyRevealedSolution());

            if(game.getHangman().checkForWinner()){
                break;
            }
        }

        printGameOverMessage(game.getHangman(), game.getConsole());




    }

    public static void printGameOverMessage(Hangman hangman, Console c1){
        if(hangman.checkForWinner()){
            c1.writeOutput("Ratender gewinnt das Spiel");
        } else{
            c1.writeOutput("Herausforder gewinnt das Spiel");
            c1.writeOutput("Korrektes Wort: " + hangman.getSolution());
        }
    }

    public static boolean checkIfValidInput(String input) {
        if (input.matches(".*\\d.*")) {
            return false;
        }

        if ((input == null) || input.isBlank()) {
            return false;
        }
        return true;
    }


}