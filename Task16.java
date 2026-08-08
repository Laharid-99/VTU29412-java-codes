import java.util.*;

public class Task16{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            deque.addLast(num);
            set.add(num);

            // Keep window size exactly m
            if (deque.size() > m) {
                int removed = deque.removeFirst();

                // If removed element is not present elsewhere,
                // remove it from the set
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }

            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, set.size());
            }
        }

        System.out.println(maxUnique);
        sc.close();
    }
}