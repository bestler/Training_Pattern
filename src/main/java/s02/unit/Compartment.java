package s02.unit;

import s02.block.IBlock;

import java.util.LinkedList;
import java.util.Queue;

public class Compartment implements Comparable<Compartment> {
    private final int id;
    private final Queue<IBlock> blocks;
    private int currentLoad;

    public Compartment(int id) {
        this.blocks = new LinkedList<>();
        this.currentLoad = 0;
        this.id = id;
    }

    boolean fitInCompartment(IBlock block){
        return block.getSize() < (20000 - currentLoad);
    }

    void addBlock(IBlock block){
        blocks.add(block);
        currentLoad = currentLoad + block.getSize();
    }

    public IBlock getCurrentElement(){
        return blocks.element();
    }

    public IBlock pollBlock(){
        currentLoad = currentLoad - blocks.element().getSize();
        return blocks.poll();

    }

    public int getId() {
        return id;
    }

    public int amountItemsLeft(){
        return blocks.size();
    }

    @Override
    public int compareTo(Compartment compartment) {
        return compartment.getId() - id;
    }
}
