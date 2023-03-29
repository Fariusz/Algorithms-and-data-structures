package polsl.pl.DrzewaPrzeszukiwanBinarnych;

import java.util.List;

public interface IBST<T extends Comparable<T>> {
    //Najmniejsza wartość w drzewie
    T minimum();
    //Usun z drzewa wartość x
    T usun(T x);
    //Wstaw do drzewa wartość x
    void wstaw(T x);
    //Sprawdz czy w drzewie jest wartość x
    boolean czyJest(T x);
}