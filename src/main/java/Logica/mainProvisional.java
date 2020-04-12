package Logica;
import Parametros.Param;
import java.util.ArrayList;
import Logica.cosas.*;

public class mainProvisional {
     
     
     public static void main(String [] args){
         Param parametros = new Param(Param.rutaProperties);
         Camping camp = new Camping();
         
         ArrayList <Parcela> parcelas =camp.getCamping();
         Cliente cli;
         /*
         do{
             cli = cosas.introducirCliente();
         }while(cli==null);
         parcelas.get(60).checkIn(cli);
         */
         for(Parcela x : parcelas)
             System.out.println(x.toString());
             
                     
         
     }
}
