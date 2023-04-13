package seminars1;
import java.util.Arrays;
import java.util.Random;

public class MainService {
	
	public static void main(String args[]) {
		printArray(coinFlip(10));
		printDiceArray(rollingDice(10));
		
		System.out.println(Arrays.toString(generateArray(5, 1.3, 5.8)));
		System.out.println(getMean(generateArray(2, 1.3, 5.8)));
		
		double[][] doubleArray = generateMatrix(5);
		System.out.println("\n");
		for (int i = 0; i < doubleArray.length; i++) {
			printArray(doubleArray[i]);
			System.out.println();
		}
		
		System.out.println(getProduct(doubleArray, 1, 1));

		
		byte[] arr = {72, 101, 108, 108, 111, 33, 32, 77, 121, 32, 115, 107, 105, 108, 108, 115, 32, 97, 114, 101,
				32, 103, 114, 101, 97, 116, 32, 97, 108, 114, 101, 97, 100, 121, 33};
		System.out.println(getTextFromBytes(arr));


		
		
		
		
		
		
		
		
		
		
	}
	// factorial recursive task
	public static int factorialRecursive(int N) {
		if (N < 0) {
			return 0;
		}
		if (N > 0) {
			return N * factorialRecursive(N - 1);
		}
		return 1;
	}
	//task 3
	public static double[] generateArray(int N, double lower, double upper) {
		if (N > 0) {
			double[] result = new double[N];
			if (lower <= upper) {
				Random random = new Random();
				
				for (int i = 0; i < result.length; i++) {
					double temp = random.nextDouble() * (upper - lower) + lower;
					result[i] = temp;
				}
				return result;
			}
		} else {
			return new double[0];
		}
		return new double[0];
	}
	
	public static double getMean(double[] array) {
		if (array != null) {
			double result = 0;
			for (double temp : array) {
				result += temp;
			}
			return result / array.length;
		}
		return 0;
	}
	
	public static double getMin(double[] array) {
		if (array != null) {
			double min = Double.MAX_VALUE;
			for (double temp : array) {
				if (temp < min) {
					min = temp;
				}
			}
			return min;
		}
		return 0;
	}	
	
	public static double getMax(double[] array) {
		if (array != null) {
			double max = Double.MIN_VALUE;
			for (double temp : array) {
				if(temp > max) {
					max = temp;
				}
			}
			return max;
		}
		return 0;
	}

	// task 4
	public static double[][] generateMatrix(int N) {
		if (N > 0) {
			double[][] doubleArray = new double[N][N];
			for (int i = 0; i < N; i++) {
				doubleArray[i] = generateArray(N, 0, 10);
			}
			return doubleArray;
		}
		return new double[0][0];
	}
		
		public static double getProduct(double[][] matrix, int i, int j) {
			return matrix[i][j];
		}

	// task 5.1
	public static double[] coinFlip(int N) {
		if (N > 0) {
			double[] flips = new double[3];
			Random random = new Random();
			for (int i = 0; i < N; i++) {
				int rndNum = random.nextInt(2); // 0 - 1
			
				if (rndNum == 0) {
					flips[0]++;
				} else {
					flips[1]++;
				}
			}
			flips[2] = flips[0] / flips[1];
			
			return flips;
		}
		return new double[0];
	}	
	// task 5.1
	public static void printArray(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}
	// task 5.2
	public static int[] rollingDice(int N) {
		if (N > 0) {
			int[] diceResult = new int[6];
			Random random = new Random();
			for (int i = 0; i < N; i++) {
				int rndNum = random.nextInt(6); // 0 - 5
				
				switch(rndNum) {
					case 0:
						diceResult[0]++;
						break;
					case 1:
						diceResult[1]++;
						break;
					case 2:
						diceResult[2]++;
						break;
					case 3:
						diceResult[3]++;
						break;
					case 4:
						diceResult[4]++;
						break;
					case 5:
						diceResult[5]++;
						break;
				}
			}
			return diceResult;
		}
		return new int[0];
	}
	// task 5.2
	public static void printDiceArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}
	// task 5.3
	public static int roll2Dices() {
		Random random = new Random();
		int tryNum = 0;
		while ( (random.nextInt(6) + 1) + (random.nextInt(6) + 1) != 12) {
			tryNum++;
		}
		return tryNum;
	}
	// task 6 MY VERSION
	public static String getTextFromBytes(byte[] array) {
		String result = new String(array);
		return result;
	}
	// task 7
	public static String pascalsTriangle(int level) {
		return "0";
	}
	
	
}
