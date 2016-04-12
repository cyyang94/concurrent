import java.util.ArrayList;

public class GameBoard implements Runnable {
	private Integer[][] map = new Integer[8][8];

	public GameBoard() {
		reset();
	}

	public static coordinate[] getSurroundings(coordinate position) {
		ArrayList<coordinate> possible_places = new ArrayList<coordinate>();
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (position.getX() + i >= 0
						&& position.getX() + i <= 7
						&& position.getY() + j >= 0
						&& position.getY() + j <= 7
						&& !position.equals(position.getX() + i,
								position.getY() + j)) {
					possible_places.add(new coordinate(position.getX() + i,
							position.getY() + j));
				}
			}
		}
		return possible_places.toArray(new coordinate[possible_places.size()]);
	}

	public void setRobot(coordinate position) {
		synchronized (map) {
			reset();
			map[position.getX()][position.getY()] = 1;
		}
	}

	public void reset() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				map[i][j] = 0;
			}
		}
	}

	public void print() {
		synchronized (map) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(" " + map[i][j] + " ");
				}
				System.out.println("");
			}
			System.out.println("___________________________________________________");
		}
	}

	public void run() {
		while (true) {
			print();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
