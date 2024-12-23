import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "Olivia paints landsc04apes in bright colors and sells them for 25.33";

        try {
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(text);
    
            while (matcher.find()) {
                System.out.println(matcher.group()); //возвращает найденое совпадение
            }
        } catch (PatternSyntaxException e) {
            System.out.println(e);
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
    }
}

/*
 * Необходимо написать программу, которая будет искать все числа в 
заданном тексте и выводить их на экран. При этом программа должна 
использовать регулярные выражения для поиска чисел и обрабатывать 
возможные ошибки. 
 */