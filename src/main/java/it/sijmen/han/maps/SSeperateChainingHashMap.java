package it.sijmen.han.maps;

import java.util.*;

/**
 * Sijmens Super Seperate Chaning Hash Map
 *
 * Does not allow null keys
 *
 * not implemented methods are:
 *   * keySet
 *   * entrySet
 *   * values
 * Created by Sijmen on 17-2-2017.
 */
public class SSeperateChainingHashMap<K, V> implements Map<K,V> {

    private MapItem[] data;

    public SSeperateChainingHashMap() {
        this.data = new MapItem[10];
    }

    protected int getIndex(int hashCode){
        return hashCode % data.length;
    }

    @Override
    public int size() {
        int counter = 0;
        for(MapItem item : data)
            if(item != null)
                counter += item.size();
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if(key == null)
            throw new IllegalArgumentException();
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for(MapItem item : data)
            if(item != null)
                if(item.hasValue(value))
                    return true;
        return false;
    }

    /**
     * Gets a value with the given Key. returns null
     * if nothing is found.
     */
    @Override
    public V get(Object key) {
        if(key == null)
            throw new IllegalArgumentException();
        int hashCode = key.hashCode();
        int index = getIndex(hashCode);
        if(data[index] == null)
            return null;
        return (V) data[index].get(hashCode, key);
    }

    /**
     * Puts the key:value pair in the map overwriting any
     * existing value with this key. Returns the previous
     * value stored with this key or null if no previous
     * value was stored.
     */
    @Override
    public V put(K key, V value){
        if(key == null)
            throw new IllegalArgumentException();
        int hashCode = key.hashCode();
        int index = getIndex(hashCode);
        if(data[index] != null)
            return (V) data[index].set(hashCode, key, value);
        data[index] = new MapItem(hashCode, key, value);
        return null;
    }

    @Override
    public V remove(Object key) {
        if(key == null)
            throw new IllegalArgumentException();
        int hashCode = key.hashCode();
        int index = getIndex(hashCode);
        if(data[index] == null)
            return null;
        return (V) data[index].remove(hashCode, key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for(K key : m.keySet())
            put(key, m.get(key));
    }

    @Override
    public void clear() {
        for (int i = 0; i < data.length; i++)
            data[i] = null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keyset = new HashSet<>();
        for(MapItem i : getAllMapItems())
            keyset.add((K) i.key);
        return keyset;
    }

    protected List<MapItem> getAllMapItems(){
        List<MapItem> all = new LinkedList<>();
        for(MapItem item : data)
            if(item != null)
                all.addAll(item.getAll());
        return all;
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("SSeperateChainingHashMap{");
        for(MapItem item : data)
            if(item != null) {
                List<MapItem> all = item.getAll();
                for(MapItem i : all){
                    toString
                            .append("[")
                            .append(i.key)
                            .append(":")
                            .append(i.value)
                            .append("]");
                }
            }

        toString.append("}");
        return toString.toString();
    }

    static class MapItem {
        int hash = -1;
        Object key;
        Object value;
        MapItem next = null;

        public MapItem(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public boolean isEmpty() {
            return this.hash == -1;
        }

        /**
         * Sets the value in the tree
         * @return the old value or null if no previous value was set.
         */
        public Object set(int hash, Object key, Object value) {
            if(this.isEmpty()){
                this.hash = hash;
                this.key = key;
                this.value = value;
                return null;
            }
            if(this.hash == hash && this.key.equals(key)){
                Object oldValue = this.value;
                this.hash = hash;
                this.key = key;
                this.value = value;
                return oldValue;
            }
            if(next == null){
                next = new MapItem(hash, key, value);
                return null;
            }
            return next.set(hash, key, value);
        }

        public int size() {
            return (isEmpty() ? 0 : 1) + (next == null ? 0 : next.size());
        }

        public Object get(int hash, Object key) {
            if(this.isEmpty())
                return null;
            if(this.hash == hash && this.key.equals(key))
                return this.value;
            if(this.next != null)
                return this.next.get(hash, key);
            return null;
        }

        public boolean hasValue(Object value) {
            if (this.isEmpty())
                return false;
            if(this.value.equals(value))
                return true;
            if(this.next != null)
                return this.next.hasValue(value);
            return false;
        }

        public Object remove(int hash, Object key) {
            if(this.isEmpty())
                return null;
            if(this.hash == hash && this.key.equals(key)){
                Object prevValue = this.value;

                if(this.next != null && !this.next.isEmpty()){
                    this.key = this.next.key;
                    this.value = this.next.value;
                    this.hash = this.next.hash;
                    this.next = null;
                }else{
                    this.key = null;
                    this.value = null;
                    this.hash = -1;
                    this.next = null;
                }

                return prevValue;
            }
            if(this.next != null)
                return this.next.remove(hash, key);
            return null;
        }

        public List<MapItem> getAll(){
            List<MapItem> out = new ArrayList<>();
            if(this.isEmpty())
                return out;
            out.add(this);
            if(this.next != null)
                out.addAll(this.next.getAll());
            return out;
        }
    }
}
