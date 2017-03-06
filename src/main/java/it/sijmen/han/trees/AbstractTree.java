package it.sijmen.han.trees;

/**
 * Created by Sijmen on 6-3-2017.
 */
public abstract class AbstractTree<T> {

    public abstract AbstractTree<T>[] getNodes();

    public abstract T getValue();

    @Override
    public String toString() {
        TreeToString<T> toString =  new TreeToString<>();
        return toString.treeToString(this);
    }

}
