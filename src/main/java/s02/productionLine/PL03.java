package s02.productionLine;

import s02.block.IBlock;

public class PL03 extends ProductionLine{

    CentralStorage centralStorage;


    public PL03(CentralStorage centralStorage) {
        this.centralStorage = centralStorage;
    }

    @Override
    public void processBlock(IBlock block) {
        if (canHandleBlock(block, 125)){
            centralStorage.storeBlock(block);
        }else {
            System.out.println("Something went wrong!");
        }
    }

    public CentralStorage getCentralStorage() {
        return centralStorage;
    }
}
