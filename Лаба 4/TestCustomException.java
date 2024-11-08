import java.io.*;
import java.util.ArrayList;

class CustomEmptyStackException extends Exception {
    public CustomEmptyStackException(String message) {
        super(message);
    }
}
//стек = буфер обмена (очень грубо обозвала временное хранилище)
class CustomStack<K> {
    private ArrayList<K> items;

    public CustomStack() {
        items = new ArrayList<>();
    }

    public void push(K item) {
        items.add(item);
    }

    public K pop() throws CustomEmptyStackException {
        if (isEmpty()) {
            throw new CustomEmptyStackException("Stack is empty. Method pop()");
        }
        return items.remove(items.size() - 1);
    }

    public K peek() throws CustomEmptyStackException {
        if (isEmpty()) {
            throw new CustomEmptyStackException("Stack is empty. Method peek()");
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}

public class TestCustomException {
    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();
        
        try {
            System.out.println(stack.pop()); 
        }
        catch (CustomEmptyStackException ce) {
            FileOutputStream fileOut = null;
            //добав, а не перезаписывается
            try {
                fileOut = new FileOutputStream("D:\\Apps\\Работы по вузу\\ИТ 2  семак\\Лабы\\Лаба 4\\except_log.txt", true);
                fileOut.write((ce.getMessage() + '\n').getBytes());
                fileOut.close();
            }
            catch (IOException e) {
                System.out.println(e);
            }

            System.out.println(ce.getMessage());
        }
    }
}