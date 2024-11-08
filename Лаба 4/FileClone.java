import java.io.*;

public class FileClone {
    public static void main(String[] args) {
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;

        try {
            fileIn = new FileInputStream("D:\\Apps\\Работы по вузу\\ИТ 2  семак\\Лабы\\Лаба 4\\file.txt");
            fileOut = new FileOutputStream("D:\\Apps\\Работы по вузу\\ИТ 2  семак\\Лабы\\Лаба 4\\copied_file.txt");
            int k;
            
            while ((k = fileIn.read()) != -1) {
                fileOut.write(k);
            }
        }
        catch (FileNotFoundException o) {
            System.out.println(o);
        }
        catch (SecurityException o) {
            System.out.println(o);
        }
        catch (IOException o) {
            System.out.println(o);
        }
        // безусловно выполняется
        finally {
            try {
                fileIn.close();
            }
            catch (IOException o) {
                System.out.println(o);
            }

            try {
                fileOut.close();
            }
            catch (IOException o) {
                System.out.println(o);
            }
        }
    }
}
