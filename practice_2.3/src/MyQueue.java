import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Queue;
    //Через мастив
    public class MyQueue {
        private int[] items;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public MyQueue(int capacity) {
            this.capacity = capacity;
            items = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }
        public void enqueue (int NewItem){
            if(isFull()){        throw new IllegalStateException("queue is full");
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % capacity;
            items[rear] = NewItem;
            size++;
        }
        public int dequeue(){
            if(isEmpty()){        throw new NoSuchElementException("queue is empty");
            }
            int result = items[front];
            front =  (front + 1)%size;
            size--;
            return result;
        }
        public void printQueue() {
            if (isEmpty()) {
                System.out.println("NULL");
            } else {
                for (int i = 0; i < size; i++) {
                    System.out.print(items[(front + i) % capacity] + " ");
                }
                System.out.println();
            }
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public boolean isFull(){
            return size == capacity;
        }
    }