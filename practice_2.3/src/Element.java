public class Element<T> {
    private T element;
    private Element next;
    int nextIndex;
    int size;
    Element(T element, Element next){
        this.element = element;
        this.next = next;
    }
    public boolean hasNext() {
        return nextIndex < size;
    }
    public Element next(){
        return next;
    }
    public Element getNext() {
        return next;
    }
    public void setNext(Element next) {
        this.next = next;
    }
    public T getElement() {
        return element;
    }
    public void setElement(T element) {
        this.element = element;
    }
}
