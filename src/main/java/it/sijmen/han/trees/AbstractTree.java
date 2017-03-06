package it.sijmen.han.trees;

import it.sijmen.han.trees.algos.SizeAlgo;
import it.sijmen.han.trees.algos.ToStringAlgo;

/**
 * Created by Sijmen on 6-3-2017.
 */
public abstract class AbstractTree<T> {

    public abstract AbstractTree<T>[] getNodes();

    public abstract T getValue();

    @Override
    public String toString() {
        ToStringAlgo<T> toString = new ToStringAlgo<>();
        return toString.apply(this);
    }

    public int getSize(){
        SizeAlgo<T> sizeAlgo = new SizeAlgo<>();
        return sizeAlgo.apply(this);
    }

}
