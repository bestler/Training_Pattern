package block;

public class Block1 implements IBlock,Comparable<IBlock> {

	private final char[][][] content;
	private final int size;

	public Block1(char[][][] content) {
		this.content = content;
		this.size = 8000;
	}

	@Override
	public char[][][] getContent() {
		return content;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int compareTo(IBlock iBlock) {
		return iBlock.getSize() - size;
	}
}