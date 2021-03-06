package compartment;

import block.IBlock;

import java.util.*;
import java.util.stream.Collectors;

public class Unit {
    private List<Compartment> compartments;
    private List<IBlock> unprocessedBlocks;

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
        for (int i = 0; i < compartments.size(); i++) {
            Compartment compartment = compartments.get(i);
            if (compartment.amountItemsLeft() > 0) {
                map.put(compartment.getCurrentElement(), compartment.getId());
            }
        }
        return map;
    }



    private List<IBlock> getCurrentAccessibleBlocks(){

        List<IBlock> blocks = new ArrayList<>();
        for (int i = 0; i < compartments.size(); i++) {
            blocks.add(compartments.get(i).getCurrentElement());
        }
        Comparator comparator = (o1, o2) -> {
            IBlock block1 = (IBlock) o1;
            IBlock block2 = (IBlock) o2;
            return block2.getSize()-block1.getSize();
        };
        blocks.sort(comparator);
        return blocks;
    }

    public int amountItemsLeft(){
        int amount = 0;
        for (int i = 0; i < compartments.size(); i++) {
            amount = amount + compartments.get(i).amountItemsLeft();
        }
        return amount;
    }


 /*   public IBlock getBiggestPossibleBlock(int capacity) {
        List<IBlock> blocks = getCurrentAccessibleBlocks();

    } */

    public List<Compartment> getCompartments() {
        return compartments;
    }
}
