package polsl.pl.DrzewaPrzeszukiwanBinarnych;

import java.util.ArrayList;
import java.util.List;

public class BST<T extends Comparable<T>> implements IBST<T> {

    private Node<T> korzen;

    @Override
    public T minimum() {

        Node<T> wezel = korzen;

        while(wezel.lewy != null){
            wezel = wezel.lewy;
        }
        return  wezel.wartosc;
    }

    @Override
    public boolean czyJest(T x) {

        Node<T> wezel = korzen;

        while(wezel != null && wezel.wartosc != x){

            if(wezel.wartosc.compareTo(x) > 0){
                wezel = wezel.lewy;
            }
            else {
                wezel = wezel.prawy;
            }
        }

        return wezel == x ? true : false;
    }

    @Override
    public void wstaw(T x) {
        korzen = wstaw(x, korzen);
    }

    private Node<T> wstaw(T x, Node<T> wezel){

        if(wezel != null){
            int cmp = wezel.wartosc.compareTo(x);
            if(cmp == 0){
                return wezel;
            }
            if(cmp > 0){
                wezel.lewy = wstaw(x, wezel.lewy);
                wezel.lewy.ojciec = wezel;
            }
            else{
                wezel.prawy = wstaw(x, wezel.prawy);
                wezel.prawy.ojciec = wezel;
            }
            return wezel;
        }else{
            return new Node<>(x);
        }
    }

    @Override
    public T usun(T x) {
        Node<T> wezel = korzen;

        if(czyJest(x)){

        }
        else{
            return null;
        }

        return null;
    }

    private List<String> wypisz(Node<T> wezel) {
        List<String> s = new ArrayList<String>();
        s.add("wartosc = " + wezel.wartosc);
        if (wezel.lewy != null) {
            List<String> tmp = wypisz(wezel.lewy);
            tmp.set(0, "--L:" + tmp.get(0));
            for (int i = 1; i < tmp.size(); i++) {
                tmp.set(i, "---" + tmp.get(i));
            }
            s.addAll(tmp);
        }
        if (wezel.prawy != null) {
            List<String> tmp = wypisz(wezel.prawy);
            tmp.set(0, "--P:" + tmp.get(0));
            for (int i = 1; i < tmp.size(); i++) {
                tmp.set(i,"---" + tmp.get(i));
            }
            s.addAll(tmp);
        }
        return s;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        List<String> ss = wypisz(korzen);
        ss.stream().forEach((t) -> {
            s.append(t + "\n");
        });
        return s.toString();
    }
}
