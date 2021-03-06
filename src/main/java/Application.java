import block.IBlock;
import compartment.Unit;
import compartment.UnitMediator;
import productionLine.CentralStorage;
import productionLine.PL01;
import productionLine.PL02;
import productionLine.PL03;
import truck.Fleet;

import java.util.List;
import java.util.Random;

/*Next steps: Handling Truck loading*/

public class Application {
    public static void main (String[] args){
        Rock rock = new Rock();
        Blasting blaster = new E02();
        blaster.setComposition();
        blaster.blast(rock);


        Unit unit = new Unit();
        unit.addUnprocessedBlocks(blaster.getBlock1s());
        unit.addUnprocessedBlocks(blaster.getBlock2s());
        unit.addUnprocessedBlocks(blaster.getBlock3s());

        Fleet fleet = new Fleet();

        UnitMediator mediator = new UnitMediator(fleet,unit);
        mediator.startProcessing();

        CentralStorage centralStorage = new CentralStorage();

        PL03 outputState = new PL03(centralStorage);
        PL02 middleState = new PL02(outputState);
        PL01 productionLine = new PL01(fleet, middleState);
        productionLine.start();
        System.out.println("Test");

    }
}
