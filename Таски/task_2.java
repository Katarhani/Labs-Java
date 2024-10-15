import java.util.Arrays;

public class task_2 {
//1
    public static String duplicateChars(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        
       
        for (char c : str1.toCharArray()) {

            if (str2.indexOf(c) == -1) {
                result.append(c);
            }
        }
        
        return result.toString();
    }
//2
    public static int dividedByThree(int[] array) {
        int count = 0; 

        for (int num : array) {
            
            if (num % 2 != 0 && num % 3 == 0) {
                count++; 
            }
        }

        return count; 
    }
//3
    public static String getInitials(String s) {
        String[] arr = s.split(" ");
        String a = arr[1].toUpperCase().charAt(0) + "." + arr[2].toUpperCase().charAt(0) + ".";
        for (int i = 0; i < arr[0].length(); i++) {
            if (i == 0) {
                a += arr[0].toUpperCase().charAt(i);
                continue;
            }
            a += arr[0].charAt(i);
        }
        return a;
    }
//4
    public static double[] normalizator(double[] numbers) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        
        for (double num : numbers) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        double[] normalized = new double[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (max == min) {
                normalized[i] = 0.0; 
            } else {
                normalized[i] = (numbers[i] - min) / (max - min);
            }
        }

        return normalized;
    }
//5
     public static int[] compressedNums(double[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                a++;
            }
        }
        int[] nums2 = new int[nums.length - a];
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                continue;
            }
            nums2[j] = (int) nums[i];
            j++;
        }
        Arrays.sort(nums2);
        return nums2;

    }
//6
    public static String camelToSnake(String camelCase) {
        // Добавление _ и уменьшение всех заглавных буков 
        String snakeCase = camelCase.replaceAll("([A-Z])", "_$1").toLowerCase();

        return snakeCase.startsWith("_") ? snakeCase.substring(1) : snakeCase;
    }
//7
    public static int secondBiggest(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 2];
    }
//8
    public static  String localReverse(String str, char b) {
        String[] arr = str.split(String.valueOf(b));
        int j = (str.charAt(0) == b ? 0 : 1);
        for (int i = j; i < arr.length; i++){
            StringBuilder temp = new StringBuilder();
            temp.append(arr[i]).reverse();
            str = str.replace(arr[i], temp.toString());
        }
        return str;
    }
//9
    public static int equal(int a, int b, int c) {
        int count = 0;

        if (a == b) count++;
        if (b == c) count++;
        if (a == c) count++;
        return count;
    }
//10
    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.replaceAll("[\\s!.,?]", "").toLowerCase();
        str2 = str2.replaceAll("[\\s!.,?]", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }


    public static void main(String[] args) {
        // №1
        System.out.println("==============");
        String result = duplicateChars("Barack", "Obama");
        System.out.println(result);
        System.out.println("==============");

        //№2
        int[] numbers = {3, 12, 7, 81, 52};
        int f = dividedByThree(numbers);
        System.out.println(f);
        System.out.println("==============");

        //№3
        System.out.println(getInitials("simonov sergei evgenievich"));
        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));
        System.out.println("==============");

        //№4
        double[] d = normalizator(new double[]{3.5, 7.0, 1.5, 9.0, 5.5});
        System.out.println(Arrays.toString(d)); 
        double[] d1 = normalizator(new double[]{10.0, 10.0, 10.0, 10.0});
        System.out.println(Arrays.toString(d1));
        System.out.println("==============");

        //№5
        int[] compressed = compressedNums(new double[]{1.6, 0, 212.3, 34.8, 0, 27.5});
        System.out.println(Arrays.toString(compressed)); 
        System.out.println("==============");

        //№6
        String example1 = "helloWorld";
        String example2 = "camelCaseToSnakeCase";
        System.out.println(camelToSnake(example1)); 
        System.out.println(camelToSnake(example2));
        System.out.println("==============");

        //№7
        System.out.println(secondBiggest(new int[]{3, 5, 8, 1, 2, 4}));
        System.out.println("==============");

        //№8
        System.out.println(localReverse("baobab", 'b'));
        System.out.println(localReverse("Hello, I'm under the water, please help me", 'e'));
        System.out.println("==============");

        //№9
        System.out.println(equal(8, 1, 8)); 
        System.out.println(equal(5, 5, 5)); 
        System.out.println(equal(4, 9, 6)); 
        System.out.println("==============");
        //№10
        System.out.println(isAnagram("LISTEN", "silent")); 
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!")); 
        System.out.println(isAnagram("hello", "world"));
    }
}
