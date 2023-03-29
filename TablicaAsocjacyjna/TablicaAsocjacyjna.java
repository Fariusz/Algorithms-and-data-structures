package polsl.pl.TablicaAsocjacyjna;

import polsl.pl.ListaWskaznik.ListaWskaznik;

import java.util.Iterator;

public class TablicaAsocjacyjna<K, V> implements ITablicaAsocjacyjna<K, V>, Iterable {

    ListaWskaznik<IPair<K, V>>[] tablicaList;

    public TablicaAsocjacyjna(int rozmiar) {
        this.tablicaList = new ListaWskaznik[rozmiar];
    }

    @Override
    public V odczytaj(K klucz) {
        int hash = getHash(klucz);
        if (tablicaList[hash] == null) {
            return null;
        }
        for (Object tmp : tablicaList[hash]) {
            Pair<K, V> pair = (Pair<K, V>) tmp;
            if (pair.getKey() == klucz)
                return pair.getValue();
        }
        return null;
    }

    @Override
    public V usun(K klucz) {
        int hash = getHash(klucz);
        if (tablicaList[hash] == null) {
            return null;
        }
        int i = 0;
        for (Object tmp : tablicaList[hash]) {
            Pair<K, V> pair = (Pair<K, V>) tmp;
            if (pair.getKey() == klucz) {
                V v = pair.getValue();
                tablicaList[hash].usun(i);
                return v;
            }
            i++;
        }
        return null;
    }

    @Override
    public void wstaw(K klucz, V wartosc) {
        int hash = getHash(klucz);
        Pair pair = new Pair(klucz, wartosc);
        if (tablicaList[hash] == null) {
            tablicaList[hash] = new ListaWskaznik<>();
        }
        V foundWartosc = odczytaj(klucz);
        if (foundWartosc != null) {
            int found = tablicaList[hash].szukaj(new Pair<>(klucz, foundWartosc));
            if (found >= 0) {
                tablicaList[hash].usun(found);
            }
        }
        tablicaList[hash].dodaj(pair);
    }

    @Override
    public Iterator<IPair<K, V>> iterator() {
        return new TablicaAsocjacyjnaIterator(tablicaList);
    }

    private int getHash(Object klucz) {
        return klucz.hashCode() % tablicaList.length;
    }
}
