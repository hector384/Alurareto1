import services.ConectionAPI;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

            int opt = 0;

        do {
            Scanner leer = new Scanner(System.in);
            String[] text = {
                    "******************************************************************",
                    "Bienvenidos a nuestro conversor de moneda",
                    "1.Dolar a Peso argentino",
                    "2.Peso Argentino a Dolar",
                    "3.Dolar A real Brasileño",
                    "4.Salir",
                    "******************************************************************"
            };

            for (int i = 0; i < text.length; i++){
                System.out.println(text[i]);
                if(i == text.length - 1) {
                    System.out.println();
                }
            }
            System.out.print("Seleccione una opcion: ");
            opt = leer.nextInt();
            System.out.print("Cantidad: ");
            double cant = leer.nextDouble();
            ConectionAPI methods = new ConectionAPI();
            switch (opt) {
                case 1:
                    String response = methods.getConversion("/USD/ARS/"+ cant);
                    System.out.println("El valor de su conversion es: "+response +" Pesos argentinos");
                    break;
                case 2:
                    String response2 = methods.getConversion("/ARS/USD/" + cant+ " Dolares");
                    System.out.println("El valor de su conversion es: "+response2+ " Real Brasileño");
                    break;
                case 3:
                    String response3 = methods.getConversion("/USD/BRL/" + cant);
                    System.out.println("El valor de su conversion es: "+response3);
                    break;
                default:
                    System.out.print("La opcion no es correcta");
                    break;

            }

        }while(opt!=4);

    }







}