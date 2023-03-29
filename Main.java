package polsl.pl;

import polsl.pl.DrzewaPrzeszukiwanBinarnych.BST;
import polsl.pl.DrzewaPrzeszukiwanBinarnych.IBST;
import polsl.pl.Sortowanie.Sortowanie;
import polsl.pl.TablicaAsocjacyjna.IPair;
import polsl.pl.TablicaAsocjacyjna.TablicaAsocjacyjna;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List lista = new ArrayList();

        for(int i = 0; i <= 100; i++){
            lista.add(i);
        }

        System.out.println(lista.size());
    }

    public static void testSort() {
        int[] tab = {2, 4, 3, 1, 7, 5, 6};
        System.out.println("Nieposortowana");
        for (int i : tab) {
            System.out.println(i);
        }
        tab = Sortowanie.szybkie(tab);
        System.out.println("Posortowana");
        for (int i : tab) {
            System.out.println(i);
        }
    }

    public static void test9() {
        IBST<Integer> bst = new BST<>();
        int[] tab = { 7, 15, 5, 1, 9, 10, 2, 6, 20 };
        for(int i : tab)
        {
            bst.wstaw(i);
        }
        System.out.println(bst.toString());

        System.out.println("Odnajdywanie");
        System.out.println("-------Odnajdywanie wartości 8, nie występuje-------");
        System.out.println(bst.czyJest(8));
        System.out.println("-------Odnajdywanie wartości 6, obecna na liście-------");
        System.out.println(bst.czyJest(6));
        System.out.println("-------Minimum-------");
        System.out.println(bst.minimum());
        System.out.println("-------Następnik-------");
        int doUsuniecia = 7;
        System.out.println("-------Usuwanie " + doUsuniecia + "-------");
        System.out.println("Usunąłem: " + bst.usun(doUsuniecia));
        System.out.println("-------Drzewo po usunięciu-------");
        System.out.println(bst);
        doUsuniecia = 9;
        System.out.println("-------Usuwanie " + doUsuniecia + "-------");
        System.out.println("Usunąłem: " + bst.usun(doUsuniecia));
        System.out.println("-------Drzewo po usunięciu-------");
        System.out.println(bst);
    }

    static void test5() {
        TablicaAsocjacyjna<String, Integer> tabAso = new TablicaAsocjacyjna<>(7);
        System.out.println("====== Wstawianie ========");
        String k;
        int v;
        k = "A";
        v = 1;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "B";
        v = 2;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "C";
        v = 3;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "D";
        v = 4;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "E";
        v = 5;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
//        k = "F";
//        v = 6;
//        tabAso.wstaw(k, v);
//        System.out.println("Wstawiam: [" + k + ":" + v + "]");
//        k = "G";
//        v = 7;
//        tabAso.wstaw(k, v);
//        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "H";
        v = 8;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "I";
        v = 9;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        System.out.println("====== Odczyt ========");
        k = "A";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "B";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "C";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "D";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "E";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "F";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "G";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "H";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "I";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        System.out.println("====== Wstawianie ========");
        k = "A";
        v = 10;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "H";
        v = 11;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "I";
        v = 12;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        System.out.println("====== Odczyt ========");
        k = "A";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "B";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "C";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "D";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "E";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "F";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "G";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "H";
        System.out.println(k + " : " + tabAso.odczytaj(k));
        k = "I";
        System.out.println(k + " : " + tabAso.odczytaj(k));
    }

    static void test6() {
        TablicaAsocjacyjna<String, Integer> tabAso = new TablicaAsocjacyjna<>(7);
        System.out.println("====== Wstawianie ========");
        String k;
        int v;
        k = "A";
        v = 1;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "B";
        v = 2;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "C";
        v = 3;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "D";
        v = 4;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "E";
        v = 5;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
//        k = "F";
//        v = 6;
//        tabAso.wstaw(k, v);
//        System.out.println("Wstawiam: [" + k + ":" + v + "]");
//        k = "G";
//        v = 7;
//        tabAso.wstaw(k, v);
//        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "H";
        v = 8;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "I";
        v = 9;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        System.out.println("====== Odczyt ForEach ========");
        for (Iterator<IPair<String, Integer>> i = tabAso.iterator(); i.hasNext(); ) {
            IPair<String, Integer> pair = i.next();
            System.out.println(pair.getKey() + "  " + pair.getValue());
        }
/*        for (IPair<String, Integer> para : tabAso) {
            System.out.println(para.getKey() + "  " + para.getValue());
        }*/
        System.out.println("====== Wstawianie ========");
        k = "A";
        v = 10;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "H";
        v = 11;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        k = "I";
        v = 12;
        tabAso.wstaw(k, v);
        System.out.println("Wstawiam: [" + k + ":" + v + "]");
        System.out.println("====== Odczyt ForEach========");
        for (Iterator<IPair<String, Integer>> i = tabAso.iterator(); i.hasNext(); ) {
            IPair<String, Integer> pair = i.next();
            System.out.println(pair.getKey() + "  " + pair.getValue());
        }
        /*for (IPair<String, Integer> para : tabAso) {
            System.out.println(para.getKey() + "  " + para.getValue());
        }*/
    }
}
