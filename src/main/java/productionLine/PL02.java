package productionLine;

import block.Block2;
import block.Block3;
import block.IBlock;

import java.util.ArrayList;
import java.util.List;

public class PL02 extends ProductionLine {

    public PL02() {
        this.setSuccessor(new PL03(new CentralStorage()));
    }

    public PL02(ProductionLine successor){
        this.setSuccessor(successor);
    }

    @Override
    public void processBlock(IBlock block) {
        if (canHandleBlock(block, 1000)){
            for (IBlock block1 : x03(block)){
                processBlock(block1);
            }
        }else super.processBlock(block);
    }


    public List<IBlock> x03(IBlock block){
        List<IBlock> blocks = new ArrayList<>();
        int count = 0;
        char [][][] processedContent = new char[5][5][5];
        char [][][] content = block.getContent();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    processedContent[count/25][(count/5)%5][count%5] = content[i][j][k];
                    count++;
                    if (count == 125){
                        count = 0;
                        blocks.add(new Block3(processedContent));
                    }
                }
            }
        }
        return blocks;
    }
}
