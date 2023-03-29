package polsl.pl.TablicaAsocjacyjna;

public interface ITablicaAsocjacyjna<K, V> {
    V odczytaj(K klucz);

    V usun(K klucz);

    void wstaw(K klucz, V wartosc);
}
