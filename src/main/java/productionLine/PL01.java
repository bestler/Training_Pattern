package productionLine;

import block.Block2;
import block.Block3;
import block.IBlock;
import truck.Fleet;
import truck.Truck;

import java.util.ArrayList;
import java.util.List;

public class PL01 extends ProductionLine {

    private final Fleet fleet;
    
    public PL01(Fleet fleet) {
        //TODO: Implement random change ProductionProcess
        //Random random = new Random();
        this.fleet = fleet;
        //this.setSuccessor(new PL02());
        this.setSuccessor(new PL02());
    }

    public PL01(Fleet fleet, ProductionLine successor){
        this.fleet = fleet;
        this.setSuccessor(successor);
    }

    public void start(){
        for (Truck truck : fleet.getTrucks()){
            for (IBlock block : truck.getLoad()){
                processBlock(block);
            }
        }
    }

    @Override
    public void processBlock(IBlock block){
        if (canHandleBlock(block, 8000)){
            for (IBlock block2 : x01(block)){
                processBlock(block2);
            }
        }else super.processBlock(block);
    }

    public List<IBlock> x01(IBlock block){
        List<IBlock> blocks = new ArrayList<>();
        int count = 0;
        char [][][] processedContent = new char[10][10][10];
        char [][][] content = block.getContent();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 20; k++) {
                    processedContent[(count/100)][(count/10)%10][count%10] = content[i][j][k];
                    count++;
                    if (count == 1000){
                        count = 0;
                        blocks.add(new Block2(processedContent));
                    }
                }
            }
        }
        return blocks;
    }

    public List<IBlock> x02(IBlock block){
        List<IBlock> blocks = new ArrayList<>();
        int count = 0;
        char [][][] processedContent = new char[5][5][5];
        char [][][] content = block.getContent();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 20; k++) {
                    processedContent[(count/25)][(count/5)%5][count%5] = content[i][j][k];
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
