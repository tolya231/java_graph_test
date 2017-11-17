import java.util.Scanner;

public class Solution {

  public static boolean[][] used;
  public static int[][] grid;
  public static int n;
  public static int m;

  public static int dfs(int cnt, int i, int j) {
    used[i][j] = true;
    if (grid[i][j] == 0) {
      return 0;
    }
    cnt++;
    for (int k1 = i - 1; k1 <= i + 1; k1++) {
      for (int k2 = j - 1; k2 <= j + 1; k2++) {
        if (k1 >= 0 && k2 >= 0 && k1 < n && k2 < m) {
          if (!used[k1][k2] && grid[k1][k2] == 1) {
            cnt += dfs(0, k1, k2);
          }
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    m = in.nextInt();

    used = new boolean[n][m];
    grid = new int[n][m];

    for (int grid_i = 0; grid_i < n; grid_i++) {
      for (int grid_j = 0; grid_j < m; grid_j++) {
        grid[grid_i][grid_j] = in.nextInt();
      }
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!used[i][j]) {
          max = Math.max(max, dfs(0, i, j));
        }
      }
    }

    System.out.println(max);

  }
}