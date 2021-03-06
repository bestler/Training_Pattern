package compartment;

import block.IBlock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Compartment implements Comparable {
    private int id;
    private Queue<IBlock> blocks;
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

    public int getSizeOFCurrentElement(){
        return blocks.element().getSize();
    }

    public int getId() {
        return id;
    }

    public int amountItemsLeft(){
        return blocks.size();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Compartment) return ((Compartment) o).getId() - id;
        return 0;
    }
}
