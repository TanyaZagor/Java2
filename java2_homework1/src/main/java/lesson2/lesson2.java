package lesson2;

public class lesson2 {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arr = {
                {"1", "g", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"} };
        try {
            int sum = calculateSum(arr);
            System.out.println(sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }
    static int calculateSum(String [][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length !=4 || arr[0].length != 4) throw new MyArraySizeException("Array size exception. Expected array[4][4].");
        int sum = 0;
        int i = 0;
        int j = 0;
        try {
            for (i = 0; i < 4; i++) {
                for (j = 0; j < 4; j++) {
                    sum += Integer.parseInt(arr[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            String msg = "arr[" + i + "][" + j + "] - not a number.";
            throw new MyArrayDataException(msg);
        }
        return sum;
    }
}
