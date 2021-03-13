package s02.unit;

import s02.block.IBlock;

import java.util.*;

public class Unit {
    private final List<Compartment> compartments;
    private final List<IBlock> unprocessedBlocks;

    public Unit() {
        compartments = new ArrayList<>();
        unprocessedBlocks = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            compartments.add(new Compartment(i));
        }
    }

    public void addUnprocessedBlocks(List<IBlock> blocks){
        unprocessedBlocks.addAll(blocks);
    }


    public IBlock getRandomUnprocessedBlock(){
        Random random = new Random();
        int rand = random.nextInt(unprocessedBlocks.size());
        return unprocessedBlocks.get(rand);
    }

    public void processBlock(IBlock block){
        unprocessedBlocks.remove(block);
    }

    public Compartment getRandomCompartment(){
        Random random = new Random();
        int rand = random.nextInt(compartments.size());
        return compartments.get(rand);
    }

    public Compartment getCompartment(int i){
        return compartments.get(i);
    }

    public int getSizeUnprocessedItems(){
        return unprocessedBlocks.size();
    }


    public SortedMap<IBlock, Integer> mapBlockCompartments(){
        SortedMap<IBlock, Integer> map = new TreeMap<>();
        for (Compartment compartment : compartments) {
            if (compartment.amountItemsLeft() > 0) {
                map.put(compartment.getCurrentElement(), compartment.getId());
            }
        }
        return map;
    }

    public int amountItemsLeft(){
        int amount = 0;
        for (Compartment compartment : compartments) {
            amount = amount + compartment.amountItemsLeft();
        }
        return amount;
    }


    public List<Compartment> getCompartments() {
        return compartments;
    }
}
