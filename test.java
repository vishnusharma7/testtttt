import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        // Input for roadList
        int roadList_row = in.nextInt();
        int roadList_col = in.nextInt();
        int roadList[][] = new int[roadList_row][roadList_col];
        for (int idx = 0; idx < roadList_row; idx++) {
            for (int jdx = 0; jdx < roadList_col; jdx++) {
                roadList[idx][jdx] = in.nextInt();
            }
        }

        int[] result = maxTollRevenue(num, roadList);

        for (int idx = 0; idx < result.length - 1; idx++) {
            System.out.print(result[idx] + " ");
        }

        System.out.println(result[result.length - 1]);
    }

    public static int[] maxTollRevenue(int num, int[][] roadList) {
        int[] tolls = new int[num + 1]; // Array to store tolls collected by each city
        int[] result = new int[2]; // Array to store the pair of cities with maximum toll revenue
        
        for (int[] road : roadList) {
            int city1 = road[0];
            int city2 = road[1];
            tolls[city1]++; // Increment toll for city1
            tolls[city2]++; // Increment toll for city2
        }

        int maxToll = Integer.MIN_VALUE;

        for (int[] road : roadList) {
            int city1 = road[0];
            int city2 = road[1];
            int totalToll = tolls[city1] + tolls[city2]; // Total toll for this road
            
            if (totalToll > maxToll) {
                maxToll = totalToll;
                result[0] = Math.min(city1, city2); // Smaller city code first
                result[1] = Math.max(city1, city2);
            }
        }

        return result;
    }
}
