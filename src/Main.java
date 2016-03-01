import org.basex.server.ClientSession;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by 47767573t on 01/03/16.
 */
public class Main {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ClientSession session = null;
        boolean salir = false;

        while(!salir){
            try{

                System.out.println("Ejercicios de practica ");
                System.out.println("1.- Cuantos paises hay en <<factbook.xml>>");
                System.out.println("2.- Cuantos paises hay");
                System.out.println("3.- Cual es la informacion sobre Alemania");
                System.out.println("4.- Cuanta gente vive en Uganda");
                System.out.println("5.- Cuales son las ciudades de Peru");
                System.out.println("6.- Cuanta gente vive en Shangai");
                System.out.println("7.- Cual es el codigo de matricula de coche de Chipre");
                System.out.println("8.- Salir");

                System.out.println("Elija consulta");
                scn.nextLine();

                switch (scn.nextLine()){
                    case "1":
                        String cad = "for $doc in collection('mondial.xml') ";
                        cad = cad + "where document-uri($doc) = \"mondial.xml\" ";
                        cad = cad + "return $doc//name)";

                        System.out.println(session.query(cad).execute());

                        break;

                    case "2":

                        break;

                    case "3":

                        break;

                    case "4":

                        break;

                    case "5":

                        break;

                    case "6":

                        break;

                    case "7":

                        break;

                    case "8":
                        System.out.println("BYE BYE");
                        session.close();
                        salir = true;
                        break;

                    default:
                        System.out.println("Ha elegido una opcion incorrecta");
                        break;
                }

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
