public class Main {
    public static void main(String[] args) {
        int length = 100000;
        int threads = 8;

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

        System.out.println("minimal " + min + ": index " + minIndex);
    }
}
