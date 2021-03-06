package compartment;

import block.IBlock;
import truck.Fleet;
import truck.Truck;

import java.util.List;
import java.util.SortedMap;

public class UnitMediator {

    private Fleet fleet;
    private Unit unit;

    private boolean compartmentRefillProcess;
    private boolean truckRefillProcess;

    private boolean truckFull;
    private boolean unitFull;

    public UnitMediator(Fleet LKWFleet, Unit unit) {
        compartmentRefillProcess = false;
        truckRefillProcess = false;
        this.fleet = LKWFleet;
        this.unit = unit;
    }

    public void fillTruck(){
        unitFull = false;
        Truck truck = new Truck();
        truckFull = false;
        List<Compartment> compartments = unit.getCompartments();
        SortedMap<IBlock, Integer> map;
        while (!truckFull && unit.amountItemsLeft() > 0){
            map = unit.mapBlockCompartments();
            boolean done = false;
            while (map.values().iterator().hasNext() && !done){
                int id = map.values().iterator().next();
                IBlock curBlock = unit.getCompartment(id).getCurrentElement();
                if (truck.getRemainingCapacity() > curBlock.getSize()){
                    truck.addBlock(unit.getCompartment(id).pollBlock());
                    done = true;
                }else{
                    truckFull = true;
                    done = true;
                }

            }
        }
        System.out.println("Truck is loaded with " + truck.numberOfBlocks() + " Blocks ("
                + truck.getCurrentLoad() + " chars)");

        fleet.addTruck(truck);
        truckFull = true;
        nextActivity();


        //TODO: Implement fill Truck
    }

    public void refillCompartments(){
        compartmentRefillProcess = true;
        int assignmentErrorCounter = 0;
        int counter = 0;
        while (assignmentErrorCounter < 10 && unit.getSizeUnprocessedItems() > 0){
            IBlock block = unit.getRandomUnprocessedBlock();
            Compartment compartment = unit.getRandomCompartment();
            if (compartment.fitInCompartment(block)){
                compartment.addBlock(block);
                unit.processBlock(block);
                //System.out.println("Stored block in compartment " + compartment.getId());
                counter++;
            }else{
                assignmentErrorCounter++;
            }
        }
        System.out.println("Stored " + counter + " Blocks in compartments!");
        System.out.println("Starting loading trucks ....");
        compartmentRefillProcess = false;
        unitFull = true;
        nextActivity();
    }

    private void nextActivity(){
        if (unitFull){
            fillTruck();
        } else {
            if (unit.getSizeUnprocessedItems() > 0){
                unitFull = false;
                refillCompartments();
            }else {
                System.out.println("All Blocks are processed! LKWs are driving to productionline.ProductionLine!");
            }


        }
    }

    public void startProcessing(){
        truckFull = false;
        unitFull = false;
        refillCompartments();
    }
}
