package it.sijmen.hanasdapp.datalgos.lists;

/**
 * Sijmens Super Queue
 * #untested
 * Created by Sijmen on 4-3-2017.
 */
public class SArrayQueue<T> {

    private SArrayList<T> list = new SArrayList<>();

    /**
     * Toevoegen aan het einde, teruggegeven of hij vol is.
     */
    public boolean insert(T item){
        if(isFull())
            return false;
        list.add(item);
        return true;
    }

    /**
     * eerste verwijderen uit lijst en teruggeven
     */
    public T remove(){
        if(isEmpty())
            return null;
        return list.removeAt(0);
    }

    /**
     * eerste teruggeven, NIET verwijderen uit lijst
     */
    public T peek(){
        if(isEmpty())
            return null;
        return list.get(0);
    }

    /**
     * Is hij leeg?
     */
    public boolean isEmpty(){
        return list.length() == 0;
    }

    /**
     * Is hij vol?
     */
    boolean isFull(){
        return list.length() == Integer.MIN_VALUE;
    }

    @Override
    public String toString() {
        return "SArrayQueue{" +
                "list=" + list.arrayToString() +
                ", length=" + list.length() +
                '}';
    }
}
