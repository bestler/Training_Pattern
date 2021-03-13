package s02;

import s02.blasting.Blasting;
import s02.blasting.E02;
import s02.block.Rock;
import s02.productionLine.*;
import s02.unit.Unit;
import s02.unit.UnitMediator;
import s02.truck.Fleet;


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
        PL01 productionLine = new PL01(fleet, middleState, ProductionType.X02);
        productionLine.start();
    }
}
