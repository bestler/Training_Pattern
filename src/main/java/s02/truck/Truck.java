package s02.truck;

import s02.block.IBlock;

import java.util.ArrayList;
import java.util.List;

public class Truck {

    private final List<IBlock> load;
    private int currentLoad;

    public Truck() {
        load = new ArrayList<>();
        currentLoad  = 0;
    }

    public void addBlock(IBlock block){
        load.add(block);
        currentLoad = currentLoad + block.getSize();
    }

    public int getRemainingCapacity(){
        return 100000 - currentLoad;
    }

    public int numberOfBlocks(){
        return load.size();
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public List<IBlock> getLoad() {
        return load;
    }
}
