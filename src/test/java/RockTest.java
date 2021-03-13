import s02.block.Rock;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RockTest {
    @Test
    public void createRock(){
        Rock rock = new Rock();
        assertNotNull(rock.getContent());
    }

    @Test
    public void dimensionOfRock(){
        Rock rock = new Rock();
        char[][][] content = rock.getContent();
        assertEquals(100, content.length);
        assertEquals(100, content[0].length);
        assertEquals(100, content[0][0].length);
    }

    @Test
    public void testCharG1Percent(){
        Rock rock = new Rock();
        int countG = 0;
        char[][][] content = rock.getContent();
        for (char[][] chars : content) {
            for (int j = 0; j < content[0].length; j++) {
                for (int k = 0; k < content[0][0].length; k++) {
                    if (chars[j][k] == 'G') countG++;
                }
            }
        }
        assertEquals(10000,countG);
    }

    @Test
    public void testCompleteRockOfChars(){
        Rock rock = new Rock();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 20; k++) {
                    assertTrue(Character.isLetter(rock.getContent()[i][j][k]));
                }
            }
        }
    }
}
