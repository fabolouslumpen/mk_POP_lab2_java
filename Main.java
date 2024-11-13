public class Main {
    public static void main(String[] args) {
        int length = 100000000;
        int threads = 8;

        Timer timer = new Timer();
        timer.start();

        ArrayFill arrayFill = new ArrayFill();

        int[] array = arrayFill.fillArray(length);

        MinFinderThread[] minFinderThreads = new MinFinderThread[threads];
        int partLength = length / threads;
        for (int i = 0; i < threads; i++) {
            int start = i * partLength;
            int end = (i == threads - 1) ? length : (i + 1) * partLength;
            minFinderThreads[i] = new MinFinderThread(array, start, end);
            minFinderThreads[i].start();
        }

        MinResultFinder minResultFinder = new MinResultFinder(minFinderThreads);
        int min = minResultFinder.findMin();
        int minIndex = minResultFinder.findMinIndex();

        timer.stop();
        long timeElapsed = timer.getTimeElapsed();
        System.out.println("work time: " + timeElapsed + " ms");

        System.out.println("minimal " + min + ": index " + minIndex);
    }
}
