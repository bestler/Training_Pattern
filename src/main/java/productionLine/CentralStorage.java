package productionLine;

import block.IBlock;

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
