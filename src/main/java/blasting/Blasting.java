package blasting;

import block.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Blasting {

    protected List<IBlock> block1s;
    protected List<IBlock> block2s;
    protected List<IBlock> block3s;

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

    public void blast(Rock rock){
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


    public abstract void setComposition();

    public abstract int[] getComposition();



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

    public List<IBlock> getBlock1s() {
        return block1s;
    }

    public List<IBlock> getBlock2s() {
        return block2s;
    }

    public List<IBlock> getBlock3s() {
        return block3s;
    }
}
