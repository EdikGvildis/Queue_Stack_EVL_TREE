import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack<>();
        stack.isEmpty();
        stack.isFull();
        stack.size();
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        System.out.println(stack.pop());
        stack.peek();
        MyQueue myQueue = new MyQueue(5);
        myQueue.enqueue(1);
        myQueue.dequeue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(8);
        myQueue.dequeue();
        myQueue.printQueue();
    }
}