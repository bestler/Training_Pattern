import block.Block1;
import block.Block2;
import block.Block3;

import java.util.ArrayList;
import java.util.List;

public abstract class Blasting {

    protected List<Block1> block1s;
    protected List<Block2> block2s;
    protected List<Block3> block3s;

    protected int x;
    protected int y;
    protected int z;

    protected int numberOfBlock1;
    protected int numberOfBlock2;
    protected int numberOfBlock3;


    public Blasting() {
        block1s = new ArrayList<>();
        block2s = new ArrayList<>();
        block3s = new ArrayList<>();
        x = y = z = 0;
    }

    void blast(Rock rock){
        //TODO: Bei Zeit mal drüber schauen, was Problem mit falschen Indizes sein könnte
        for (int i = 0; i < numberOfBlock1; i++) {
            block1s.add(createBlock1(rock));
        }
        for (int i = 0; i < numberOfBlock2; i++) {
            block2s.add(createBlock2(rock));
        }
        for (int i = 0; i < numberOfBlock3; i++) {
            block3s.add(createBlock3(rock));
        }

    }


    abstract void setComposition();



    protected Block1 createBlock1(Rock rock){
        int count = 0;
        char[][][] block = new char[20][20][20];
        for (int i = x; i < 100; i++) {
            for (int j = y; j < 100; j++) {
                for (int k = z; k < 100; k++) {
                        block[count/400][(count/20)%20][count%20] = rock.getContent()[i][j][k];
                        count++;
                    if (count == 8000){
                        setRunVariables(i,j,k);
                        count = 0;
                        return new Block1(block);
                    }
                }
                if (y<99) z=0;
            }
            if (x<99) y=0;
        }
        return new Block1(block);
    }

    protected Block2 createBlock2(Rock rock){
        int count = 0;
        char[][][] block = new char[10][10][10];
        for (int i = x; i < 100; i++) {
            for (int j = y; j < 100; j++) {
                for (int k = z; k < 100; k++) {
                        block[count/100][(count/10)%10][count%10] = rock.getContent()[i][j][k];
                        count++;
                    if (count == 1000){
                        setRunVariables(i,j,k);
                        count = 0;
                        return new Block2(block);
                    }
                }
                if (y<99) z=0;
            }
            if (x<99) y=0;
        }
        return new Block2(block);
    }


    protected Block3 createBlock3(Rock rock){
        int count = 0;
        char[][][] block = new char[5][5][5];
        for (int i = x; i < 100; i++) {
            for (int j = y; j < 100; j++) {
                for (int k = z; k < 100; k++) {
                        block[count/25][(count/5)%5][count%5] = rock.getContent()[i][j][k];
                        count++;
                    if (count == 125){
                        setRunVariables(i,j,k);
                        count = 0;
                        return new Block3(block);
                    }
                }
                if (y<99) z=0;
            }
            if (x<99) y=0;
        }
        return new Block3(block);
    }


    private void setRunVariables(int x, int y ,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

}