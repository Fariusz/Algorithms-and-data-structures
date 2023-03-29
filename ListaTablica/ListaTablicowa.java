package polsl.pl.ListaTablica;

import polsl.pl.Lista;

import java.util.Iterator;

public class ListaTablicowa<E> implements Lista, Iterable {
    Object[] tablica;
    int c = 0;

    public ListaTablicowa() {
        this(10);
    }

    public ListaTablicowa(int i) {
        tablica = new Object[i];
    }

    private Object[] rozszerzonaTablica() {
        Object[] tmpTab = new Object[tablica.length * 2];
        for (int i = 0; i < c; i++) {
            tmpTab[i] = tablica[i];
        }
        return tmpTab;
    }

    @Override
    public void dodaj(Object o) {
        if (c >= tablica.length) {
            tablica = rozszerzonaTablica();
        }
        tablica[c] = o;
        c++;
    }

    @Override
    public Object usun(int i) {
        if (i < c) {
            Object u = tablica[i];
            for (int j = i; j < c - 1; j++) {
                tablica[j] = tablica[j + 1];
            }
            c--;
            tablica[c] = null;
            return u;
        }
        return null;
    }

    @Override
    public void wstaw(int i, Object o) {
        if (c >= tablica.length) {
            tablica = rozszerzonaTablica();
        }
        for (int j = c; j > i; j--) {
            tablica[j] = tablica[j - 1];
        }
        tablica[i] = o;
        c++;
    }

    @Override
    public int szukaj(Object o) {
        for (int i = 0; i < c; i++) {
            if (tablica[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object odczytaj(int i) {
        if (i < c)
            return tablica[i];
        return -1;
    }

    @Override
    public int rozmiar() {
        return c;
    }

    @Override
    public Iterator iterator() {
        return new TablicaIterator(tablica);
    }
}
