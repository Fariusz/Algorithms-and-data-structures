package polsl.pl.TablicaAsocjacyjna;

import polsl.pl.ListaWskaznik.ListaWskaznik;

import java.util.Iterator;

public class TablicaAsocjacyjnaIterator<K, V> implements Iterator<IPair<K, V>> {


    ListaWskaznik<IPair<K, V>>[] listaWskaznikowa;
    int iterTab;
    Iterator<IPair<K, V>> iterList;

    public TablicaAsocjacyjnaIterator(ListaWskaznik<IPair<K, V>>[] listaWskaznikowa) {
        this.listaWskaznikowa = listaWskaznikowa;
        iterTab = 0;
        iterList = null;
        while (iterTab < listaWskaznikowa.length) {
            if (listaWskaznikowa[iterTab] != null) {
                iterList = listaWskaznikowa[iterTab].iterator();
                break;
            }
            iterTab++;
        }
    }

    @Override
    public boolean hasNext() {
        if (iterList.hasNext())
            return true;
        iterTab++;
        while (iterTab < listaWskaznikowa.length) {
            if (listaWskaznikowa[iterTab] != null && listaWskaznikowa[iterTab].iterator().hasNext()) {
                iterList = listaWskaznikowa[iterTab].iterator();
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
