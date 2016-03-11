
import org.basex.api.client.ClientSession;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by 47767573t on 01/03/16.
 */
public class Main {



    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);

        ClientSession session = null;
        System.out.print("Entrando...");
        session = new ClientSession("localhost", 1984, "admin", "admin");
        System.out.println(" ...Dentro");


        boolean salir = false;
        String query = "";

        while(!salir){
            try{
                System.out.println("\nEjercicios de practica ");
                System.out.println("1.- Que paises hay en <<factbook.xml>>");
                System.out.println("2.- Cuantos paises hay");
                System.out.println("3.- Cual es la informacion sobre Alemania");
                System.out.println("4.- Cuanta gente vive en Uganda");
                System.out.println("5.- Cuales son las ciudades de Peru");
                System.out.println("6.- Cuanta gente vive en Shangai");
                System.out.println("7.- Cual es el codigo de matricula de coche de Chipre");
                System.out.println("8.- Salir");

                System.out.println("Elija consulta");

                switch (scn.nextInt()){
                    case 1:
                        query = "collection('Factbook.xml')/factbook/record/country";
                        toQuery(session, query);
                        break;

                    case 2:
                        query = "collection('mondial.xml')/count(/mondial/country)";
                        toQuery(session, query);
                        break;

                    case 3:
                        query = "collection('mondial.xml')/mondial/country[name=\"Germany\"]";
                        toQuery(session, query);
                        break;

                    case 4:
                        query = "collection('mondial.xml')/mondial/country[name=\"Uganda\"]/population[last()]/text()";
                        toQuery(session, query);
                        break;

                    case 5:
                        query = "collection('mondial.xml')/mondial/country[name=\"Peru\"]/province/city/name/text()";
                        toQuery(session, query);
                        break;

                    case 6:
                        query = "collection('mondial.xml')/mondial/country/province[name=\"Shanghai\"]/population[last()]/text()";
                        toQuery(session, query);
                        break;

                    case 7:
                        query ="collection('mondial.xml')/mondial/country[name=\"Cyprus\"]/@car_code";
                        toQuery(session, query);
                        break;

                    case 8:
                        System.out.println("BYE BYE");
                        session.close();
                        salir = true;
                        break;

                    default:
                        System.out.println("Ha elegido una opción incorrecta");
                        break;
                }

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    /**
     * realiza consultas con la sesion concretada e imprime por pantalla
     * @param session sesion de conexion para realizar la consulta
     * @param q query de consulta
     */
    public static void toQuery (ClientSession session, String q){
        try {
            System.out.println("Resultado:\n"+session.query(q).execute());
        } catch (IOException e) {
            System.out.println("Error en conexión con la sesion: "+String.valueOf(e));
        }
    }

}
