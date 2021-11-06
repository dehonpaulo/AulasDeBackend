import model.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro cachorro1 = new Cachorro("Olaf", 2);
        Cachorro cachorro2 = new Cachorro("Fiona", 8);
        Cachorro cachorro3 = new Cachorro("Hermione", 1);

        cachorros.add(cachorro1);
        cachorros.add(cachorro2);
        cachorros.add(cachorro3);

        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("ListaCachorros.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

            objOut.writeObject(cachorros);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Para ler um arquivo
        List<Cachorro> cachorros2 = null;
        FileInputStream fileInput;
        try {
            fileInput = new FileInputStream("ListaCachorros.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);

             cachorros2 = (ArrayList) objInput.readObject();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        for(Cachorro cachorro : cachorros2) {
            System.out.println("Nome: " + cachorro.getNome() + "\nIdade: " + cachorro.getIdade() + "\n");
        }
    }
}
