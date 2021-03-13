package s02.block;

import java.util.Random;

public class Rock {

	private final char[][][] content;

	public Rock() {
		content = new char[100][100][100];
		createRock();
	}

	public void createRock() {
		Random random = new Random();
		int countG = 0;
		int rand;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					if (countG < 10000){
						 rand = random.nextInt(5);
					}else {
						rand = random.nextInt(4);
					}
					switch (rand){
						default-> content[i][j][k] = 'A';
						case 1 -> content[i][j][k] = 'B';
						case 2 -> content[i][j][k] = 'C';
						case 3 -> content[i][j][k] = 'X';
						case 4 -> {
							content[i][j][k] = 'G';
							countG++;
						}
					}
				}
			}
		}
	}

	public char[][][] getContent() {
		return content;
	}
}