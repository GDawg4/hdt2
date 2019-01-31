import java.util.ArrayList;

public class myList<E> implements Stack<E> {

    protected ArrayList<E> data;

    public myList(){
        data = new ArrayList<E>();
    }

    @Override
    public void push(E item) {
        data.add(item);
    }

    @Override
    public E pop() {
        if (data.size() > 0) {
            return data.remove(size() - 1);
        }
        return null;
    }

    @Override
    public E peek() {
        if (data.size() > 0) {
            return data.get(size()-1);
        }
        return null;
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return data.size();
    }
}
