public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;

        try {
            for (int index = 0; index < arr.length; ++index) {
                sum += arr[index];
            }
            sum = sum/arr.length;
            System.out.println(sum);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        catch(NumberFormatException e) {
            System.out.println(e);
        }
    }
}