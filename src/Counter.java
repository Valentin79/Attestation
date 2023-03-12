public class Counter {
    private static int count = 0;
    public static void add() {
        try {
            count++;
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Counter.count = count;
    }
}
