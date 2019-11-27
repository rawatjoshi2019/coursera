import java.text.DecimalFormat;
import java.util.Scanner;

public class FractionalKnapsack {
	private static double getOptimalValue(int capacity, int[] values, int[] weights) {
		double value = 0;
		if (capacity == 0) {
			return 0;
		}
		for (int i = 0; capacity > 0 && i < values.length; ++i) {
			int cap = max(capacity, weights[i]);
			value += ((double) values[i] / (double) weights[i]) * cap;
			capacity -= cap;
		}
		return value;
	}

	private static int max(int remainingWeight, int availableWeight) {
		return remainingWeight >= availableWeight ? availableWeight : remainingWeight;
	}

	static void sort(int values[], int[] weights) {
		int n = values.length;
		for (int i = 1; i < n; ++i) {
			int value = values[i];
			int weight = weights[i];
			double key = (double) value / (double) weight;
			int j = i - 1;

			while (j >= 0 && ((double) values[j] / (double) weights[j]) < key) {
				values[j + 1] = values[j];
				weights[j + 1] = weights[j];
				j = j - 1;
			}
			values[j + 1] = value;
			weights[j + 1] = weight;
		}
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		sort(values, weights);
		DecimalFormat df = new DecimalFormat("#.####");
		System.out.println(df.format(getOptimalValue(capacity, values, weights)));
		scanner.close();
	}
}
