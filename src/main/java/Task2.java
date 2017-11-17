import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Task2 {

  public static boolean[] used;
  public static int[] distance;

  public static class Graph {

    List<List<Integer>> adj;

    public Graph(int size) {
      adj = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        adj.add(i, new ArrayList<>());
      }
    }

    public List<Integer> adjacents(int v) {
      return adj.get(v);
    }

  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int cnt = in.nextInt();
    for (int i = 0; i < cnt; i++) {
      int n = in.nextInt();
      int m = in.nextInt();

      used = new boolean[n + 1];
      distance = new int[n + 1];
      Graph g = new Graph(n);

      for (int j = 0; j < m; j++) {
        int from = in.nextInt();
        int to = in.nextInt();
        from--;
        to--;
        g.adjacents(from).add(to);
        g.adjacents(to).add(from);
      }

      int s = in.nextInt() - 1;
      Queue<Integer> q = new LinkedList<>();
      q.add(s);
      distance[s] = 0;
      used[s] = true;

      while (!q.isEmpty()) {
        int v = q.poll();

        for (Integer w : g.adjacents(v)) {
          if (!used[w]) {
            used[w] = true;
            q.offer(w);
            distance[w] = distance[v] + 6;
          }
        }
      }

      for (int j = 0; j < n; j++) {
        if (j != s) {
          if (!used[j]) {
            System.out.printf("-1 ");
          } else {
            System.out.printf("%d ", distance[j]);
          }
        }
      }
      System.out.println();
    }


  }
}