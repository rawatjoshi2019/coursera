import java.util.Scanner;

public class CarFueling {
	static int computeMinRefills(int dist, int tank, int[] stops) {
		int source = 0;
		int lastPos, currPos = source;
		int totalRefills = 0;
		int totalStops = stops.length - 2;
		while (currPos <= totalStops) {
			lastPos = currPos;
			while (currPos <= totalStops && (stops[currPos + 1] - stops[lastPos]) <= tank) {
				currPos++;
			}
			if (currPos == lastPos) {
				return -1;
			}
			if (currPos <= totalStops) {
				totalRefills++;
			}
		}
		return totalRefills;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dist = scanner.nextInt();
		int tank = scanner.nextInt();
		int n = scanner.nextInt();
		int stops[] = new int[n + 2];
		stops[0] = 0;
		for (int i = 1; i <= n; i++) {
			stops[i] = scanner.nextInt();
		}
		stops[n + 1] = dist;
		System.out.println(computeMinRefills(dist, tank, stops));
		scanner.close();
	}
}
