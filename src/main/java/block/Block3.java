package block;

public class Block3 implements IBlock {

	private char content[][][];
	private int size;


	public Block3(char[][][] content) {
		this.content = content;
		this.size = 125;
	}

	@Override
	public char[][][] getContent() {
		return content;
	}

	@Override
	public int getSize() {
		return size;
	}
}