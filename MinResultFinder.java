public class MinResultFinder {
    private MinFinderThread[] minFinderThreads;

    public MinResultFinder(MinFinderThread[] minFinderThreads) {
        this.minFinderThreads = minFinderThreads;
    }

    public int findMin() {
        int min = Integer.MAX_VALUE;
        for (MinFinderThread thread : minFinderThreads) {
            try {
                thread.join();
                int threadMin = thread.getMin();
                if (threadMin < min) {
                    min = threadMin;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return min;
    }

    public int findMinIndex() {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (MinFinderThread thread : minFinderThreads) {
            try {
                thread.join();
                int threadMin = thread.getMin();
                int threadMinIndex = thread.getMinIndex();
                if (threadMin < min) {
                    min = threadMin;
                    minIndex = threadMinIndex;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return minIndex;
    }
}
