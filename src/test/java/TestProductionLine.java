import s02.blasting.Blasting;
import s02.blasting.E02;
import s02.block.Block1;
import s02.block.IBlock;
import s02.block.Rock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import s02.productionLine.*;
import s02.truck.Fleet;
import s02.unit.Unit;
import s02.unit.UnitMediator;

import static org.junit.jupiter.api.Assertions.*;

public class TestProductionLine {

    private Fleet fleet;


    @BeforeEach
    public void init(){
        Rock rock = new Rock();
        Blasting blaster = new E02();
        blaster.setComposition();
        blaster.blast(rock);


        Unit unit = new Unit();
        unit.addUnprocessedBlocks(blaster.getBlock1s());
        unit.addUnprocessedBlocks(blaster.getBlock2s());
        unit.addUnprocessedBlocks(blaster.getBlock3s());

        fleet = new Fleet();

        UnitMediator mediator = new UnitMediator(fleet,unit);
        mediator.startProcessing();
    }

    @Test
    public void testSuccessors(){
        CentralStorage centralStorage = new CentralStorage();
        PL03 outputState = new PL03(centralStorage);
        PL02 middleState = new PL02(outputState);
        PL01 productionLine = new PL01(fleet, middleState, ProductionType.X02);
        assertEquals(productionLine.getSuccessor(), middleState);
        assertEquals(middleState.getSuccessor(), outputState);
    }

    @Test
    public void testX01(){
        char[][][] rockContent = new char[20][20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 20; k++) {
                    rockContent[i][j][k] = 'a';
                }
            }
        }
        IBlock block = new Block1(rockContent);
        CentralStorage centralStorage = new CentralStorage();
        PL03 outputState = new PL03(centralStorage);
        PL02 middleState = new PL02(outputState);
        PL01 productionLine = new PL01(fleet, middleState, ProductionType.X01);
        assertEquals(8,productionLine.x01(block).size());

    }

    @Test
    public void testX02(){
        char[][][] rockContent = new char[20][20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 20; k++) {
                    rockContent[i][j][k] = 'a';
                }
            }
        }
        IBlock block = new Block1(rockContent);
        CentralStorage centralStorage = new CentralStorage();
        PL03 outputState = new PL03(centralStorage);
        PL02 middleState = new PL02(outputState);
        PL01 productionLine = new PL01(fleet, middleState, ProductionType.X02);
        assertEquals(64,productionLine.x02(block).size());

    }

    @Test
    public void testCompleteProduction(){
        CentralStorage centralStorage = new CentralStorage();
        PL03 outputState = new PL03(centralStorage);
        PL02 middleState = new PL02(outputState);
        PL01 productionLine = new PL01(fleet, middleState, ProductionType.X02);
        productionLine.start();
        assertEquals(8000, centralStorage.getCentralStorage().size());
    }

}
