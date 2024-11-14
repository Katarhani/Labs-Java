import java.util.regex.*;

public class FindWords {
    public static void main(String[] args) {
        try {
            String text = "Michael plays soccer every Saturday";

            char begin = 'M';
            String regex = String.format("(?i)\\b%c[a-z]+", begin);

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e) {
            System.out.println(e);
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
    }
}

/*
 * Необходимо написать программу, которая будет искать все слова в 
заданном тексте, начинающиеся с заданной буквы, и выводить их на 
экран. При этом программа должна использовать регулярные выражения 
для поиска слов и обрабатывать возможные ошибки. 
 */