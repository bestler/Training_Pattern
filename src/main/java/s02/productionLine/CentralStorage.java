package s02.productionLine;

import s02.block.IBlock;

import java.util.ArrayList;
import java.util.List;

public class CentralStorage {
    private final List<IBlock> centralStorage;

    public CentralStorage() {
        centralStorage = new ArrayList<>();
    }

    public void storeBlock(IBlock block){
        centralStorage.add(block);
    }

    public List<IBlock> getCentralStorage() {
        return centralStorage;
    }
}
