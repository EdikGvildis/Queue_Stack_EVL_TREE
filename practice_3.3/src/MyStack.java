import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack <T> {
    private int [] storage =  new int [10];
     private int top = -1;
    MyStack(){};
    public boolean push(int item){
        if(isFull()) throw new ArrayIndexOutOfBoundsException();
        top++;
        storage[top] = item;
        return true;
    }

    public int pop(){
        storage[top] = 0;
        top--;
        return storage[top];
    }
    public int peek (){
        if(top!= -1) {
            return storage[top];
        }
        return -1;
    }
    public int size (){
        return storage.length;
    }
    public boolean isEmpty() {
         return top >= 0;
    }
    public boolean isFull() {
        return top == storage.length - 1;
    }
}
