import blasting.Blasting;
import blasting.E02;
import block.Rock;
import productionLine.*;
import unit.Unit;
import unit.UnitMediator;
import truck.Fleet;


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
