package Logica;

import static Ficheros.Ficheros.*;
import Parametros.Param;
import java.io.*;
import java.util.ArrayList;

public class Camping {

    ArrayList<Parcela> camping;
    ArrayList<Parcela> checkOuts;
    
    public Camping() {
        camping = new ArrayList<>();
        checkOuts = new ArrayList<>();
        File fichero = new File(Param.rutaCamping);
        if (!fichero.exists()) {
            inicializarCamping();
            guardarCamping(camping);
        } else {
            camping=cargarCamping();
        }
    }

    public ArrayList<Parcela> getCheckOuts() {
        return checkOuts;
    }

    /*
    public void guardarCamping() {
        try (FileOutputStream fos = new FileOutputStream(Param.rutaCamping, false);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            for (Parcela x : camping) {
                oos.writeObject(x);
            }

        } catch (IOException ex) {
            System.err.println("Error al guardar:" + ex.getMessage());
        }

    }

    public void cargarCamping() {
        camping.clear();
        boolean eof = false;
        File fichero = new File(Param.rutaCamping);
        try (FileInputStream fis = new FileInputStream(fichero);
                BufferedInputStream bufis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bufis)) {
            while (!eof) {
                camping.add((Parcela) ois.readObject());
            }
        } catch (EOFException e) {
            eof = true;
        } catch (IOException ex) {
            System.err.println("Error:" + ex.getMessage());
        }catch (ClassNotFoundException ex) {
            System.err.println("Error:" + ex.getMessage());
        }

    }
*/
    public void inicializarCamping() {
        int cont =1;
        // Añado 10 tiendas
        for (int i = 0; i < Param.TOTAL_TIENDAS; i++) {
            camping.add(new Tienda(cont));
            cont++;
        }

        // Añado 20 caravanas
        for (int i = 0; i < Param.TOTAL_CARAVANAS; i++) {
            camping.add(new Caravana(cont));
            cont++;
        }

        // Añado 50 Bungalos
        for (int i = 0; i < Param.TOTAL_BUNGALOS; i++) {
            camping.add(new Bungalow(cont));
            cont++;
        }
    }

    public ArrayList<Parcela> getCamping() {
        return camping;
    }

}
