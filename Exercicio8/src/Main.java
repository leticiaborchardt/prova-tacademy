import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");

        System.out.println("Digite a primeira palavra:");
        String p1 = sc.next();

        System.out.println("Digite a segunda palavra:");
        String p2 = sc.next();

        System.out.println(verificarFinalString(p1, p2));
    }

    public static boolean verificarFinalString(String primeiraPalavra, String segundaPalavra) {
        String ultimosDoisStr1 = primeiraPalavra.substring(primeiraPalavra.length() - 2);
        String primeirosDoisStr2 = segundaPalavra.substring(0, 2);

        return ultimosDoisStr1.equals(primeirosDoisStr2);
    }
}