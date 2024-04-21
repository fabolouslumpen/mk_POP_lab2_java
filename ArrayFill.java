public class ArrayFill {
    public int[] fillArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 2001) - 1000;
        }
        return array;
    }
}
