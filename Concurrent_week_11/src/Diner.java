public class Diner implements Runnable {
	private Fork left, right;
	private String name;

	Diner(Fork left, Fork right, String name) {
		this.left = left;
		this.right = right;
		this.name = name;
	}

	public void run() {
		while (true) {
			try {
				if (left.get() && right.get()) {
					System.out.println("Eating " + name);
					Thread.sleep(3000);
				} else {
					System.out.println("CANT GET LOCK " + name);
				}
				left.release();
				right.release();
				Thread.sleep(1000);

			} catch (InterruptedException e) {
			}
		}
	}
}
