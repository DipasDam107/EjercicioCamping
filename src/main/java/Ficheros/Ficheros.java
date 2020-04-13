package Ficheros;

import Logica.Bungalow;
import Logica.Parcela;
import Logica.Tienda;
import Parametros.Param;
import java.io.*;
import java.util.*;
import static Parametros.Param.*;
import java.time.LocalDate;

public class Ficheros {

    final static char SEPARADOR = ';';

    //PARAMETROS
    public static void guardarParam(Param param, Properties config) {
        config.setProperty("TIENDA_PRECIO_DIARIO", String.valueOf(param.TIENDA_PRECIO_DIARIO));
        config.setProperty("TIENDA_PRECIO_ELECTRICIDAD_DIARIO", String.valueOf(param.TIENDA_PRECIO_ELECTRICIDAD_DIARIO));
        config.setProperty("TIENDA_DESCUENTO_LARGA_ESTANCIA", String.valueOf(param.TIENDA_DESCUENTO_LARGA_ESTANCIA));
        config.setProperty("TIENDA_DIAS_LARGA_ESTANCIA", String.valueOf(param.TIENDA_DIAS_LARGA_ESTANCIA));
        config.setProperty("CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO", String.valueOf(param.CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO));
        config.setProperty("CARAVANA_PRECIO_DIARIO_RESTO", String.valueOf(param.CARAVANA_PRECIO_DIARIO_RESTO));
        config.setProperty("CARAVANA_MINIMO_DIAS_ESTANCIA", String.valueOf(param.CARAVANA_MINIMO_DIAS_ESTANCIA));
        config.setProperty("BUNGALOW_PRECIO_INDIVIDUAL", String.valueOf(param.BUNGALOW_PRECIO_INDIVIDUAL));
        config.setProperty("BUNGALOW_PRECIO_INFANTIL", String.valueOf(param.BUNGALOW_PRECIO_INFANTIL));
        config.setProperty("BUNGALOW_PORCENTAJE_RECARGO", String.valueOf(param.BUNGALOW_PORCENTAJE_RECARGO));
        config.setProperty("BUNGALOW_NOCHES_RECARGO", String.valueOf(param.BUNGALOW_NOCHES_RECARGO));
        config.setProperty("BUNGALOW_EDAD_MAYOR_INFANTIL", String.valueOf(param.BUNGALOW_EDAD_MAYOR_INFANTIL));
        config.setProperty("BUNGALOW_MAX_ACOMPANIANTES", String.valueOf(param.BUNGALOW_MAX_ACOMPANIANTES));

        try {
            config.store(new FileOutputStream(rutaProperties), "Valores globales para Camping");
        } catch (IOException e) {
            System.out.println("Error de entrada y salida");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void cargarParam(Param param, Properties config) {
        try {
            config.load(new FileInputStream(rutaProperties));
            param.TIENDA_PRECIO_DIARIO = Integer.valueOf(config.getProperty("TIENDA_PRECIO_DIARIO"));
            param.TIENDA_PRECIO_ELECTRICIDAD_DIARIO = Integer.valueOf(config.getProperty("TIENDA_PRECIO_ELECTRICIDAD_DIARIO"));
            param.TIENDA_DESCUENTO_LARGA_ESTANCIA = Integer.valueOf(config.getProperty("TIENDA_DESCUENTO_LARGA_ESTANCIA"));
            param.TIENDA_DIAS_LARGA_ESTANCIA = Integer.valueOf(config.getProperty("TIENDA_DIAS_LARGA_ESTANCIA"));
            param.CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO = Integer.valueOf(config.getProperty("CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO"));
            param.CARAVANA_PRECIO_DIARIO_RESTO = Integer.valueOf(config.getProperty("CARAVANA_PRECIO_DIARIO_RESTO"));
            param.CARAVANA_MINIMO_DIAS_ESTANCIA = Integer.valueOf(config.getProperty("CARAVANA_MINIMO_DIAS_ESTANCIA"));
            param.BUNGALOW_PRECIO_INDIVIDUAL = Integer.valueOf(config.getProperty("BUNGALOW_PRECIO_INDIVIDUAL"));
            param.BUNGALOW_PRECIO_INFANTIL = Integer.valueOf(config.getProperty("BUNGALOW_PRECIO_INFANTIL"));
            param.BUNGALOW_PORCENTAJE_RECARGO = Integer.valueOf(config.getProperty("BUNGALOW_PORCENTAJE_RECARGO"));
            param.BUNGALOW_NOCHES_RECARGO = Integer.valueOf(config.getProperty("BUNGALOW_NOCHES_RECARGO"));
            param.BUNGALOW_EDAD_MAYOR_INFANTIL = Integer.valueOf(config.getProperty("BUNGALOW_EDAD_MAYOR_INFANTIL"));
            param.BUNGALOW_MAX_ACOMPANIANTES = Integer.valueOf(config.getProperty("BUNGALOW_MAX_ACOMPANIANTES"));
        } catch (IOException e) {
            System.out.println("Error de entrada y salida");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //CAMPING
    public static void guardarCamping(ArrayList<Parcela> camping) {
        try (FileOutputStream fos = new FileOutputStream(rutaCamping, false);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            for (Parcela x : camping) {
                System.out.println(x.toString());
                oos.writeObject(x);
            }

        } catch (IOException ex) {
            System.err.println("Error al guardar:" + ex.getMessage());
        }
    }

    public static ArrayList<Parcela> cargarCamping() {
        ArrayList<Parcela> camping = new ArrayList<>();
        camping.clear();
        boolean eof = false;
        File fichero = new File(rutaCamping);
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
        } catch (ClassNotFoundException ex) {
            System.err.println("Error:" + ex.getMessage());
        }
        return camping;
    }

    //HISTORICO CHECKOUTs
    public static void guardarEntrada(Parcela parcela, double importe) {
        try (FileWriter fw = new FileWriter(new File(rutaEntrada), true);
                BufferedWriter bfw = new BufferedWriter(fw)) {
            //dni huésped principal, número de parcela, tipo de parcela, fecha de entrada, fecha de salida, importe pagado. 
            bfw.write(parcela.getCliente().getDni() + SEPARADOR);
            bfw.write(String.valueOf(parcela.getNumero()) + SEPARADOR);
            if (parcela instanceof Bungalow) {
                bfw.write("Bungalow" + SEPARADOR);
            } else if (parcela instanceof Tienda) {
                bfw.write("Tienda" + SEPARADOR);
            } else {
                bfw.write("Caravana" + SEPARADOR);
            }
            bfw.write(parcela.getFechaOcupado() + "" + SEPARADOR);
            bfw.write(LocalDate.now() + "" + SEPARADOR);
            bfw.write(importe + "" + SEPARADOR);
            bfw.newLine();
            bfw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
