package org.lessons.java.christmas;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> listaRegali = new ArrayList<>();
        boolean exit = false;
        String scelta;

        readFile("wishList.txt");

        System.out.println("Crea una lista di regali!");

        String regaloIn;

        do {
            System.out.print("aggiungi regalo: ");
            regaloIn = scan.nextLine();

            listaRegali.add(regaloIn);

            System.out.println("Lunghezza lista: " + listaRegali.size());
            System.out.print("Vuoi continuare ad aggiungere regali? s/n:  ");
            scelta = scan.nextLine();

            if (scelta.equals("n")) {
                exit = true;
            }

        } while (!exit);


        Collections.sort(listaRegali);
        System.out.println(listaRegali);


        //scrittura su file
        scritturaSuFile(listaRegali);

    }


    public static void scritturaSuFile(ArrayList listaRegali) {
        try {
            File file = new File("wishList.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < listaRegali.size(); i++) {
                bufferedWriter.write("Regalo: " + (i + 1) + " " + listaRegali.get(i) + "\n");
            }

            bufferedWriter.close();
            System.out.println("Scrittura completata.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la scrittura del file.");
            e.printStackTrace();
        }
    }


    public static void readFile(String nameList) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(nameList));
        String line;
        System.out.println("I regali della vecchia lista sono:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line );
        }

    }
}
