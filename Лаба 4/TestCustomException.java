import java.util.ArrayList;
import java.io.*;

class CustomEmptyStackException extends Exception {
    public CustomEmptyStackException(String message) {
        super(message);
    }
}

class CustomStack<T> {
    private ArrayList<T> items;

    public CustomStack() {
        items = new ArrayList<>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() throws CustomEmptyStackException {
        if (isEmpty()) {
            throw new CustomEmptyStackException("Stack is empty. Method pop()");
        }
        return items.remove(items.size() - 1);
    }

    public T peek() throws CustomEmptyStackException {
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
        
        // stack.push(3);
        try {
            System.out.println(stack.pop()); 
        }
        catch (CustomEmptyStackException ce) {
            FileOutputStream fileOut = null;

            try {
                fileOut = new FileOutputStream("except_log.txt", true);
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