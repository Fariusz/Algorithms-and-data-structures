package polsl.pl;

public interface Lista<E> {
    void dodaj(E e); // Dodanie nowego elementy na koncu listy

    E usun(int i); // Usunięcie i'tego elementu

    void wstaw(int i, E e); // Wstawienie nowego elementu w miejsce i

    int szukaj(E e); //Odnalezienie pierwszego elementu równego e

    E odczytaj(int i); //Odczytanie elementu z pozycji i

    int rozmiar(); //zwrocenie rozmiaru listy

}
