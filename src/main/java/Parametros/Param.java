package Parametros;

import java.io.*;
import java.util.Properties;
import static Ficheros.Ficheros.*;
public class Param {

    Properties config;

    //Total Parcelas
    public static int TOTAL_PARCELAS=80;
    public static int TOTAL_TIENDAS=10;
    public static int TOTAL_BUNGALOS=50;
    public static int TOTAL_CARAVANAS=20;

    //Tienda
    public int TIENDA_PRECIO_DIARIO;
    public int TIENDA_PRECIO_ELECTRICIDAD_DIARIO;
    public int TIENDA_DESCUENTO_LARGA_ESTANCIA; // Descuento para estancias de mas de 7 dias
    public int TIENDA_DIAS_LARGA_ESTANCIA;

    //Caravana
    public int CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO;
    public int CARAVANA_PRECIO_DIARIO_RESTO;
    public int CARAVANA_MINIMO_DIAS_ESTANCIA; // Si no cumple el minimo no se permite checkout

    //Bungalow
    public int BUNGALOW_PRECIO_INDIVIDUAL;
    public int BUNGALOW_PRECIO_INFANTIL;
    public int BUNGALOW_PORCENTAJE_RECARGO; //Si se queda 1 o 2 noches, debe pagar recargo
    public int BUNGALOW_NOCHES_RECARGO;
    public int BUNGALOW_EDAD_MAYOR_INFANTIL;
    public int BUNGALOW_MAX_ACOMPANIANTES;

    //Rutas
    public static String separador = System.getProperty("file.separator");
    public static String rutaProperties = "." + separador + "data" + separador + "parametros.txt";
    public static String rutaCamping = "." + separador + "data" + separador + "camping.dat";
    public static String rutaEntrada = "." + separador + "data" + separador + "historico.csv";

    public Param(String ruta) {
        // Comprueba si existe un archivo de parametros

        File archivo = new File(ruta);
        config = new Properties();
        if (archivo.exists()) {
            //Si existe lo carga a las variables estaticas
            cargarParam(this, config);
        } else {
            //Si no existe lo guarda por primera vez con los valores por defecto
            inicializarParametros(ruta);
            guardarParam(this, config);
        }

    }

    public void inicializarParametros(String ruta) {
        //Tienda
        TIENDA_PRECIO_DIARIO = 20;
        TIENDA_PRECIO_ELECTRICIDAD_DIARIO = 1;
        TIENDA_DESCUENTO_LARGA_ESTANCIA = 10; // Descuento para estancias de mas de 7 dias
        TIENDA_DIAS_LARGA_ESTANCIA = 7;

        //Caravana
        CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO = 50;
        CARAVANA_PRECIO_DIARIO_RESTO = 30;
        CARAVANA_MINIMO_DIAS_ESTANCIA = 10; // Si no cumple el minimo no se permite checkout

        //Bungalow
        BUNGALOW_PRECIO_INDIVIDUAL = 20;
        BUNGALOW_PRECIO_INFANTIL = 0;
        BUNGALOW_PORCENTAJE_RECARGO = 20; //Si se queda 1 o 2 noches, debe pagar recargo
        BUNGALOW_NOCHES_RECARGO = 2;
        BUNGALOW_EDAD_MAYOR_INFANTIL = 5;
        BUNGALOW_MAX_ACOMPANIANTES = 8;
    }
    /*
    public void cargarParametros(String ruta) {
        try {
            config.load(new FileInputStream(ruta));
            TIENDA_PRECIO_DIARIO = Integer.valueOf(config.getProperty("TIENDA_PRECIO_DIARIO"));
            TIENDA_PRECIO_ELECTRICIDAD_DIARIO = Integer.valueOf(config.getProperty("TIENDA_PRECIO_ELECTRICIDAD_DIARIO"));
            TIENDA_DESCUENTO_LARGA_ESTANCIA = Integer.valueOf(config.getProperty("TIENDA_DESCUENTO_LARGA_ESTANCIA"));
            TIENDA_DIAS_LARGA_ESTANCIA = Integer.valueOf(config.getProperty("TIENDA_DIAS_LARGA_ESTANCIA"));
            CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO = Integer.valueOf(config.getProperty("CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO"));
            CARAVANA_PRECIO_DIARIO_RESTO = Integer.valueOf(config.getProperty("CARAVANA_PRECIO_DIARIO_RESTO"));
            CARAVANA_MINIMO_DIAS_ESTANCIA = Integer.valueOf(config.getProperty("CARAVANA_MINIMO_DIAS_ESTANCIA"));
            BUNGALOW_PRECIO_INDIVIDUAL = Integer.valueOf(config.getProperty("BUNGALOW_PRECIO_INDIVIDUAL"));
            BUNGALOW_PRECIO_INFANTIL = Integer.valueOf(config.getProperty("BUNGALOW_PRECIO_INFANTIL"));
            BUNGALOW_PORCENTAJE_RECARGO = Integer.valueOf(config.getProperty("BUNGALOW_PORCENTAJE_RECARGO"));
            BUNGALOW_NOCHES_RECARGO = Integer.valueOf(config.getProperty("BUNGALOW_NOCHES_RECARGO"));
            BUNGALOW_EDAD_MAYOR_INFANTIL = Integer.valueOf(config.getProperty("BUNGALOW_EDAD_MAYOR_INFANTIL"));
        } catch (IOException e) {
            System.out.println("Error de entrada y salida");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void guardarParametros(String ruta) {
        config.setProperty("TIENDA_PRECIO_DIARIO", String.valueOf(TIENDA_PRECIO_DIARIO));
        config.setProperty("TIENDA_PRECIO_ELECTRICIDAD_DIARIO", String.valueOf(TIENDA_PRECIO_ELECTRICIDAD_DIARIO));
        config.setProperty("TIENDA_DESCUENTO_LARGA_ESTANCIA", String.valueOf(TIENDA_DESCUENTO_LARGA_ESTANCIA));
        config.setProperty("TIENDA_DIAS_LARGA_ESTANCIA", String.valueOf(TIENDA_DIAS_LARGA_ESTANCIA));
        config.setProperty("CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO", String.valueOf(CARAVANA_PRECIO_DIARIO_SALIDA_AGOSTO));
        config.setProperty("CARAVANA_PRECIO_DIARIO_RESTO", String.valueOf(CARAVANA_PRECIO_DIARIO_RESTO));
        config.setProperty("CARAVANA_MINIMO_DIAS_ESTANCIA", String.valueOf(CARAVANA_MINIMO_DIAS_ESTANCIA));
        config.setProperty("BUNGALOW_PRECIO_INDIVIDUAL", String.valueOf(BUNGALOW_PRECIO_INDIVIDUAL));
        config.setProperty("BUNGALOW_PRECIO_INFANTIL", String.valueOf(BUNGALOW_PRECIO_INFANTIL));
        config.setProperty("BUNGALOW_PORCENTAJE_RECARGO", String.valueOf(BUNGALOW_PORCENTAJE_RECARGO));
        config.setProperty("BUNGALOW_NOCHES_RECARGO", String.valueOf(BUNGALOW_NOCHES_RECARGO));
        config.setProperty("BUNGALOW_EDAD_MAYOR_INFANTIL", String.valueOf(BUNGALOW_EDAD_MAYOR_INFANTIL));

        try {
            config.store(new FileOutputStream(ruta), "Valores globales para Camping");
        } catch (IOException e) {
            System.out.println("Error de entrada y salida");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
*/
}
