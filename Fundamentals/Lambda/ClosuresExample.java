interface Process {
	void process(int i);
}

public class ClosuresExample {
	
	public static void main(String[] args) {
		// Effectively final with java8
		int a = 10;
		int b = 20;

		// With anonymous class
		doProcess(a, new Process() {
			@Override
			public void process(int i) {
				System.out.println(i + b);
			}
		});

		// With lambda function
		doProcess(a, (i) -> System.out.println(i + b));
	}

	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}