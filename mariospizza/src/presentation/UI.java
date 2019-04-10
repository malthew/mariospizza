package presentation;

import businesslogic.Bestilling;
import businesslogic.Pizza;
import java.util.ArrayList;

// @Author: Allan, Aske, Casper T. og Malthe

public interface UI { 

    public int[] vælgPizza(int menuKortLength);

    public void visPizzaValg(String string);

    public void visOrdrenummer(int ordrenummer);

    public void visMenukort(ArrayList<Pizza> menukort);

    public void visHovedmenu();

    public String hovedmenuValg();

    public void visBestillinger(ArrayList<Bestilling> aktiveOrdrer, boolean bypassRS);

    public int fjernBestilling(int arraySize);

    public void seHistorik(ArrayList<Bestilling> historik);

    public void notAnOption();

    public void skrivHistorik(ArrayList<Bestilling> historik);

    public String vælgTidspunkt();

    public String vælgNavn();

    public String vælgTlfno();
}
