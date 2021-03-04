package block;

public class Block2 implements IBlock {

	private final char[][][] content;
	private final int size;

	public Block2(char[][][] content) {
		this.content = content;
		this.size = 1000;
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