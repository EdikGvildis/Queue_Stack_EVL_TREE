import java.util.*;
public class MyLinkedList<T> {
    private Element <T> first;
    private int size;
    public MyLinkedList (){}
    public void add(T item){
        if(size == 0){
            Element element = new Element(item,null);
            first.setNext(element);
            size++;
        }else {
            addLast(item);
        }
    }
    public  void add(T item , int index){
        if(size == 0){
            addFirst(item);
        }else if(index == size -1){
            addLast(item);
        }else{
            checkingIndex(index);
            Element elementPrevious = whoNodeInIndex(index -1);
            Element elementNext = whoNodeInIndex(index +1);
            Element element = new Element<>(item , elementNext);
            elementPrevious.setNext(element);
            size++;
        }
    }
    public void addLast(T item){
        Element NodeInIndex = first;
        for(int i = 0; i<size;i++){
            NodeInIndex = NodeInIndex.getNext();
            if(NodeInIndex == null){
                Element element = new Element(item, null);
                NodeInIndex.setNext(element);
                size++;
                return;
            }
        }
    }
    public void addFirst(T item){
        Element firstElement = new Element(item , first);
        first = firstElement;
        size++;
    }
    public Element get(int index){
        checkingIndex(index);
        Element element = first;
        for(int i = 0; i<index;i++){
            element = element.getNext();
        }
        return element;
    }
    public Element getFirst(){
        return first;
    }
    public Element getLast(){
        checkingIndex(0);
        Element NodeInIndex = first;
        for(int i = 0; i<size;i++){
            NodeInIndex = NodeInIndex.getNext();
            if(NodeInIndex == null){
                return NodeInIndex;
            }
        }
        return NodeInIndex;
    }
    public void remove(int index){
        checkingIndex(index);
        if(size == 0 && index == 0){
            removeFirst();
        }else if(index == size -1){
            removeLast();
        }else{
            Element WhoIndexPrevious = whoNodeInIndex(index-1);
            Element WhoIndexNext = whoNodeInIndex(index+1);
            WhoIndexPrevious.setNext(WhoIndexNext);
            size--;
        }
    }
    public void removeFirst(){
        Element element = first.next();
        first = element;
    }
    public void removeLast(){
        Element NodeInIndex = first;
        Element NodeInPrevious = first;
        for(int i =0 ;i<size;i++){
            if(NodeInIndex.next() == null){
                NodeInPrevious.setNext(null);
                return;
            }
            NodeInIndex = NodeInIndex.getNext();
            if(i>0){
                NodeInPrevious = NodeInIndex.getNext();
            }
        }
    }
    public void set(T element , int index){
        checkingIndex(index);
        Element elementIndex = whoNodeInIndex(index);
        elementIndex.setElement(element);
    }
    public void checkingIndex(int index){
        if((!(index >= 0 && size < index)))
            throw new IndexOutOfBoundsException();
    }
    private Element whoNodeInIndex(int index){
        checkingIndex(index);
        Element NodeInIndex = first;
        for(int i = 0; i<index;i++){
            NodeInIndex = NodeInIndex.getNext();
        }
        return NodeInIndex;
    }
    public int size(){
        return size;
    }
    public int indexOf(T element){
        Element NodeInIndex = first;
        for(int i = 0; i<size;i++){
            if(NodeInIndex.next() == element){
                return i+1;
            }
            NodeInIndex = NodeInIndex.getNext();
        }
        return -1;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
