public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        String input;
        char guessedCharacter;

        while (true){
            game.getConsole().writeOutput("Enter your word, challenger: ");
            input = game.getConsole().readInput();

            if(game.checkIfValidInput(input)){
                break;
            }


        }
        game.getConsole().clear();
        game.getConsole().writeOutput("Word accepted. The guesser can start guessing.");

        game.setHangman(new Hangman(input.toLowerCase()));


        while (game.getHangman().triesLeft != 0) {

            game.getConsole().writeOutput("Enter a letter:");

            input = game.getConsole().readInput();
            if(!game.checkIfValidInput(input)){
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
            c1.writeOutput("The guesser wins the game!");
        } else{
            c1.writeOutput("The challenger wins the game!");
            c1.writeOutput("Solution: " + hangman.getSolution());
        }
    }


}
