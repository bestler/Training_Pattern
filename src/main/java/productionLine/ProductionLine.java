package productionLine;

import block.IBlock;

public abstract class ProductionLine {
    private ProductionLine successor;


    public void setSuccessor(ProductionLine successor) {
        this.successor = successor;
    }

    public ProductionLine getSuccessor() {
        return successor;
    }


    public void processBlock(IBlock block){
        if (getSuccessor() != null){
            getSuccessor().processBlock(block);
        }else{
            System.out.println("Processing error!");
        }
    }

    protected boolean canHandleBlock(IBlock block, int size){
        return block.getSize() == size;
    }

}
