package block;

public interface IBlock extends Comparable<IBlock> {

	int getSize();

	char[][][] getContent();

}