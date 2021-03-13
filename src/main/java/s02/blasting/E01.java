package s02.blasting;

import s02.block.Rock;

import java.util.Random;

public class E01 extends Blasting {


    public E01() {
        super();
        //Base Case
        numberOfBlock1 = 101;
        numberOfBlock2 = 177;
        numberOfBlock3 = 120;
    }


    @Override
    public void setComposition(){
        Random random = new Random();
        int rand = random.nextInt(7);
        numberOfBlock2 = numberOfBlock2 - rand;
        numberOfBlock3 = numberOfBlock3 + rand*8;


        double percentage =  ((double) numberOfBlock3/(numberOfBlock1 + numberOfBlock2 + numberOfBlock3))*100.0;
        System.out.println("The percentage of Block 3's is " + String.format("%.2f", percentage) + "%");
    }

    @Override
    public int[] getComposition() {
        return new int[]{numberOfBlock1, numberOfBlock2, numberOfBlock3};
    }

    @Override
    public void blast(Rock rock) {
        super.blast(rock);
    }
}
