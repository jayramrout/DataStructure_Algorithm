package jrout.tutorial.practice.facebook;

public class MovingZerosToLeft {
    public static void main(String[] args) {
        int number[] = {1,10,20,0,59,63,0,88,0};
        int expectedOutput[] = {0,0,0,1,10,20,59,63,88};

        int[] afterMove = moveZerosToLeft(number);
        for (int i = 0; i < expectedOutput.length; i++) {
            if (expectedOutput[i] != afterMove[i]) {
                System.err.println("failed !!");
                break;
            }
        }
    }

    /**
     * Runtime complexity: Linear, O(n)
     * Memory Complexity: Constant, O(1)
     * Keep two markers: read_index and write_index and point them to the end of the array. Let’s take a look at an overview of the algorithm.
     * While moving read_index towards the start of the array:
     * If read_index points to 0, skip.
     * If read_index points to a non-zero value, write the value at read_index to write_index and decrement write_index.
     * Assign zeros to all the values before the write_index and to the current position of write_index as well.
     * @param array
     * @return
     */
    //int number[] = {1,10,20,0,59,63,0,88,0};
    public static int[] moveZerosToLeft(int array[]) {
        if(array == null || array.length < 1)
            return array;

        int write_index = array.length - 1;
        int read_index = array.length - 1;
        while (read_index >= 0) {
            if (array[read_index] != 0) {
                array[write_index] = array[read_index];
                write_index--;
            }
            read_index--;
        }
        while (write_index >= 0) {
            array[write_index] = 0;
            write_index--;
        }

        return array;
    }
}
