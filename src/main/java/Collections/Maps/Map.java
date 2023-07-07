package Collections.Maps;

import Collections.Lists.LinkedList.LinkedList;

import java.util.Iterator;

public class Map<K, V> implements IMap<K, V>, Iterable {

    LinkedList<IPair<K, V>>[] listArray;

    public Map(int length) {
        this.listArray = new LinkedList[length];
    }

    @Override
    public V get(K key) {
        int hash = getHash(key);
        if (listArray[hash] == null) {
            return null;
        }
        for (Object tmp : listArray[hash]) {
            Pair<K, V> pair = (Pair<K, V>) tmp;
            if (pair.getKey() == key) return pair.getValue();
        }
        return null;
    }

    @Override
    public V delete(K key) {
        int hash = getHash(key);
        if (listArray[hash] == null) {
            return null;
        }
        int i = 0;
        for (Object tmp : listArray[hash]) {
            Pair<K, V> pair = (Pair<K, V>) tmp;
            if (pair.getKey() == key) {
                V v = pair.getValue();
                listArray[hash].delete(i);
                return v;
            }
            i++;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        int hash = getHash(key);
        Pair pair = new Pair(key, value);
        if (listArray[hash] == null) {
            listArray[hash] = new LinkedList<>();
        }
        V foundvalue = get(key);
        if (foundvalue != null) {
            int found = listArray[hash].find(new Pair<>(key, foundvalue));
            if (found >= 0) {
                listArray[hash].delete(found);
            }
        }
        listArray[hash].add(pair);
    }

    @Override
    public Iterator<IPair<K, V>> iterator() {
        return new MapIterator<>(listArray);
    }

    private int getHash(Object key) {
        return key.hashCode() % listArray.length;
    }

    public static void main(String[] args) {
        Map<String, Integer> lnkdLst = new Map<>(7);
        System.out.println("====== add ========");
        String k;
        int v;
        k = "A";
        v = 1;
        lnkdLst.add(k, v);
        System.out.println("add: [" + k + ":" + v + "]");
        k = "B";
        v = 2;
        lnkdLst.add(k, v);
        System.out.println("add: [" + k + ":" + v + "]");
        k = "C";
        v = 3;
        lnkdLst.add(k, v);
        System.out.println("add: [" + k + ":" + v + "]");
        k = "D";
        v = 4;
        lnkdLst.add(k, v);
        System.out.println("add: [" + k + ":" + v + "]");
        k = "E";
        v = 5;
        lnkdLst.add(k, v);
        System.out.println("add: [" + k + ":" + v + "]");
//        k = "F";
//        v = 6;
//        lnkdLst.add(k, v);
//        System.out.println("add: [" + k + ":" + v + "]");
//        k = "G";
//        v = 7;
//        lnkdLst.add(k, v);
//        System.out.println("add: [" + k + ":" + v + "]");
        k = "H";
        v = 8;
        lnkdLst.add(k, v);
        System.out.println("add: [" + k + ":" + v + "]");
        k = "I";
        v = 9;
        lnkdLst.add(k, v);
        System.out.println("add: [" + k + ":" + v + "]");
        System.out.println("====== read ========");
        k = "A";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "B";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "C";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "D";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "E";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "F";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "G";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "H";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "I";
        System.out.println(k + " : " + lnkdLst.get(k));
        System.out.println("====== adding ========");
        k = "A";
        v = 10;
        lnkdLst.add(k, v);
        System.out.println("added: [" + k + ":" + v + "]");
        k = "H";
        v = 11;
        lnkdLst.add(k, v);
        System.out.println("added: [" + k + ":" + v + "]");
        k = "I";
        v = 12;
        lnkdLst.add(k, v);
        System.out.println("added: [" + k + ":" + v + "]");
        System.out.println("====== reading ========");
        k = "A";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "B";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "C";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "D";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "E";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "F";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "G";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "H";
        System.out.println(k + " : " + lnkdLst.get(k));
        k = "I";
        System.out.println(k + " : " + lnkdLst.get(k));
    }
}
