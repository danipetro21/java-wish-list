package org.lessons.java.christmas;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> listaRegali = new ArrayList<>();
        boolean exit = false;
        String scelta;
        System.out.println("Crea una lista di regali!");

        String regaloIn;

        do {
            System.out.print("aggiungi regalo: ");
            regaloIn = scan.nextLine();

            listaRegali.add(regaloIn);

            System.out.println("Lunghezza lista: " + listaRegali.size());
            System.out.print("Vuoi continuare ad aggiungere regali? s/n:  ");
            scelta = scan.nextLine();

            if(scelta.equals("n")){
                exit = true;
            }

        }while(!exit);


        Collections.sort(listaRegali);
        System.out.println(listaRegali);



    }
}
