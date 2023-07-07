package Collections.Maps;

import Collections.Lists.LinkedList.LinkedList;

import java.util.Iterator;

public class MapIterator<K, V> implements Iterator<IPair<K, V>> {

    LinkedList<IPair<K, V>>[] linkedList;
    int iterTab;
    Iterator<IPair<K, V>> iterList;

    public MapIterator(LinkedList<IPair<K, V>>[] linkedList) {
        this.linkedList = linkedList;
        iterTab = 0;
        iterList = null;
        while (iterTab < linkedList.length) {
            if (linkedList[iterTab] != null) {
                iterList = linkedList[iterTab].iterator();
                break;
            }
            iterTab++;
        }
    }

    @Override
    public boolean hasNext() {
        if (iterList.hasNext()) return true;
        iterTab++;
        while (iterTab < linkedList.length) {
            if (linkedList[iterTab] != null && linkedList[iterTab].iterator().hasNext()) {
                iterList = linkedList[iterTab].iterator();
                return true;
            }
            iterTab++;
        }
        return false;
    }

    @Override
    public IPair<K, V> next() {
        return iterList.next();
    }
}
