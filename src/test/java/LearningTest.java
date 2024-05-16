import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LearningTest {

    @Test
    public void executeCodeInConstructor() {
        // When a new instance of a class is created, the code in the constructor is executed.
        // Go to class "Car" and add code to the constructor to make the test pass.
        Car car = new Car();

        assertThat(car.getColor()).isEqualTo("red");
    }
    
    @Test
    public void changeValueOfField() {
        Car car = new Car();
        
        // Fields represent properties of objects.
        // For example the "Car" class has a field called "color".
        // As in real life, such properties may change.
        
        // Add code here to make the test pass.
        // Make sure all tests are still green.
        
        assertThat(car.getColor()).isEqualTo("blue");
    }

    @Test
    public void determineSecondCharacterOfWord() {
        String word = "island";
        // Make the test pass:
        // Change the code in the following line. Use the method charAt as in:
        //   "hello".charAt(0)
        char secondCharacter = 'X';

        assertThat(secondCharacter).isEqualTo('s');
    }

    @Test
    public void convertStringToListOfCharacters() {
        String word = "word";

        ArrayList<Character> wordAsList = new ArrayList<>();
        // Make the test pass:
        // Fill wordAsList with the Characters of word. Use a "for-each loop" and convert the
        // string word to an array via word.toCharArray().

        assertThat(wordAsList.get(0)).isEqualTo('w');
        assertThat(wordAsList.get(1)).isEqualTo('o');
        assertThat(wordAsList.get(2)).isEqualTo('r');
        assertThat(wordAsList.get(3)).isEqualTo('d');
    }

    @Test
    public void convertListOfCharactersToString() {
        List<Character> wordAsList = List.of('w', 'o', 'r', 'd');
        String word = "";
        // Make the test pass:
        // Create a string from the characters of wordAsList. Use a "for-each loop" and the "+ operator" to add
        // characters to the string "word".

        assertThat(word).isEqualTo("word");
    }

    @Test
    public void replaceCharacterInWord() {
        List<Character> wordAsList = new ArrayList<>(List.of('h', 'a', 't'));

        // Make the test pass:
        // Replace the first character in the word.
        // Use the method "set" as in wordAsList.set(2, 'm')

        assertThat(wordAsList.get(0)).isEqualTo('r');
        assertThat(wordAsList.get(1)).isEqualTo('a');
        assertThat(wordAsList.get(2)).isEqualTo('t');
    }

    @Test
    public void convertStringWithOneCharacterToChar() {
        String stringWithOneCharacter = "g";

        // Make the test pass:
        // Convert the stringWithOneCharacter to char, using the method "charAt".
        char character = 'n';

        assertThat(character).isEqualTo('g');
    }
}
