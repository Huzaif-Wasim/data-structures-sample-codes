import java.util.LinkedList;

class Stack<T>{
    LinkedList<T> list = new LinkedList<T>();
    public void push(T data){
        list.addLast(data);
    }
    public T pop(){
        return list.removeLast();
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return(list.size()==0);
    }
}