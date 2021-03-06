package block;

public class Block2 implements IBlock,Comparable {

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

	@Override
	public int compareTo(Object o) {
		if (o instanceof IBlock) return ((IBlock) o).getSize() - size;
		else return 0;
	}

}