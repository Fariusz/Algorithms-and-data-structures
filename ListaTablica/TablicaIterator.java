package polsl.pl.ListaTablica;

import java.util.Iterator;

public class TablicaIterator<E> implements Iterator {

    E[] tablica;
    int i;

    public TablicaIterator(E[] tablica) {
        this.tablica = tablica;
        i = -1;
    }

    @Override
    public boolean hasNext() {
        return (tablica[i + 1] != null && i + 1 < tablica.length);
    }

    @Override
    public E next() {
        if (i + 1 < tablica.length) {
            i++;
            return tablica[i];
        } else return null;
    }
}
