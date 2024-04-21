public class MinFinderThread extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int min = Integer.MAX_VALUE;
    private int minIndex = -1;

    public MinFinderThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
    }

    public int getMin() {
        return min;
    }

    public int getMinIndex() {
        return minIndex;
    }
}
