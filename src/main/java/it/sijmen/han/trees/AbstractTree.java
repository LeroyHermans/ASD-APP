package it.sijmen.han.trees;

import it.sijmen.han.trees.algos.SizeAlgo;
import it.sijmen.han.trees.algos.ToStringAlgo;
import it.sijmen.han.trees.algos.HeightAlgo;

/**
 * Created by Sijmen on 6-3-2017.
 */
public abstract class AbstractTree<T> {

    public abstract AbstractTree<T>[] getNodes();

    public abstract T getValue();

    public abstract void setValue(T v);

    @Override
    public String toString() {
        ToStringAlgo<T> toString = new ToStringAlgo<>();
        return toString.apply(this);
    }

    public int getSize(){
        SizeAlgo<T> sizeAlgo = new SizeAlgo<>();
        return sizeAlgo.apply(this);
    }

    public int getHeight() {
        HeightAlgo<T> heightAlgo = new HeightAlgo<>();
        return heightAlgo.apply(this);
    }
}
