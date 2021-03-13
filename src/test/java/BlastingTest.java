import s02.blasting.E01;
import s02.blasting.E02;
import s02.block.IBlock;
import s02.block.Rock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class BlastingTest {


    @Test
    public void testCompositionE01(){
        E01 blaster = new E01();
        blaster.setComposition();
        int[] composition = blaster.getComposition();
        double percentage = (double) composition[2]/(composition[0] + composition[1] + composition[2])*100;
        assertTrue(percentage > 30.0 && percentage < 45.0);
    }

    @Test
    public void testCompositionE02(){
        E02 blaster = new E02();
        blaster.setComposition();
        int[] composition = blaster.getComposition();
        double percentage = (double) composition[2]/(composition[0] + composition[1] + composition[2])*100;
        assertTrue(percentage > 40.0 && percentage < 70.0);
    }


    @Test
    public void testCreationE01ListSize(){
        Rock rock = new Rock();
        E01 blaster = new E01();
        blaster.setComposition();
        int[] composition = blaster.getComposition();
        blaster.blast(rock);
        assertEquals(composition[0], blaster.getBlock1s().size());
        assertEquals(composition[1], blaster.getBlock2s().size());
        assertEquals(composition[2], blaster.getBlock3s().size());
    }

    @Test
    public void testCreationE02ListSize(){
        Rock rock = new Rock();
        E02 blaster = new E02();
        blaster.setComposition();
        int[] composition = blaster.getComposition();
        blaster.blast(rock);

        assertEquals(composition[0], blaster.getBlock1s().size());
        assertEquals(composition[1], blaster.getBlock2s().size());
        assertEquals(composition[2], blaster.getBlock3s().size());
    }

    @Test
    public void createCompleteBuildingWithCharsE01() {
        Rock rock = new Rock();
        E01 blaster = new E01();
        blaster.setComposition();
        List<IBlock> blocks1 = blaster.getBlock1s();
        List<IBlock> blocks2 = blaster.getBlock2s();
        List<IBlock> blocks3 = blaster.getBlock3s();
        blaster.blast(rock);
        for (IBlock block : blocks1) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    for (int k = 0; k < 20; k++) {
                        assertTrue(Character.isLetter(block.getContent()[i][j][k]));
                    }
                }
            }
        }
        for (IBlock block : blocks2) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 10; k++) {
                        assertTrue(Character.isLetter(block.getContent()[i][j][k]));
                    }
                }
            }
        }
        for (IBlock block : blocks3) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        assertTrue(Character.isLetter(block.getContent()[i][j][k]));
                    }
                }
            }
        }
    }


    @Test
    public void createCompleteBuildingWithCharsE02() {
        Rock rock = new Rock();
        E02 blaster = new E02();
        blaster.setComposition();
        List<IBlock> blocks1 = blaster.getBlock1s();
        List<IBlock> blocks2 = blaster.getBlock2s();
        List<IBlock> blocks3 = blaster.getBlock3s();
        blaster.blast(rock);
        for (IBlock block : blocks1) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    for (int k = 0; k < 20; k++) {
                        assertTrue(Character.isLetter(block.getContent()[i][j][k]));
                    }
                }
            }
        }
        for (IBlock block : blocks2) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 10; k++) {
                        assertTrue(Character.isLetter(block.getContent()[i][j][k]));
                    }
                }
            }
        }
        for (IBlock block : blocks3) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        assertTrue(Character.isLetter(block.getContent()[i][j][k]));
                    }
                }
            }
        }
    }


}
