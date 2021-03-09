import blasting.Blasting;
import blasting.E01;
import block.Rock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import truck.Fleet;
import truck.Truck;
import unit.Unit;
import unit.UnitMediator;

import static org.junit.jupiter.api.Assertions.*;


public class TestLoadLKW {

    private Blasting blaster;

    @BeforeEach
    public void init(){
        Rock rock = new Rock();
        blaster = new E01();
        blaster.setComposition();
        blaster.blast(rock);
    }

    @AfterEach
    @Test
    public void testAmountUnprocessedBlocks(){
        Unit unit = new Unit();
        unit.addUnprocessedBlocks(blaster.getBlock1s());
        unit.addUnprocessedBlocks(blaster.getBlock2s());
        unit.addUnprocessedBlocks(blaster.getBlock3s());
        int [] composition = blaster.getComposition();
        int sumExpected = composition[0] + composition[1] + composition[2];
        assertEquals(sumExpected, unit.getSizeUnprocessedItems());

        Fleet fleet = new Fleet();

        UnitMediator unitMediator = new UnitMediator(fleet, unit);
        unitMediator.startProcessing();
        assertEquals(0, unit.getSizeUnprocessedItems());
        for (Truck truck : fleet.getTrucks()){
            assertTrue(truck.getCurrentLoad() > 0 && truck.getCurrentLoad() < 100000);
        }
    }

    @Test
    public void testLoadingOfLKWs(){

    }

}
