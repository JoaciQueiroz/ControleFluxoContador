import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        
        int tentativasRestantes = 3; // Iniciamos com três tentativas, incluindo a atual
        
        while (tentativasRestantes > 0) {
            System.out.println("Digite o primeiro parâmetro");
            int parametroUm = terminal.nextInt();
            System.out.println("Digite o segundo parâmetro");
            int parametroDois = terminal.nextInt();
            
            try {
                // chamando o método contendo a lógica de contagem
                contar(parametroUm, parametroDois);
                break; // Se a contagem for bem-sucedida, saímos do loop
            } catch (ParametrosInvalidosException e) {
                // imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
                System.out.println(e.getMessage());
                
                tentativasRestantes--;
                if (tentativasRestantes > 0) {
                    System.out.println("Você tem mais " + tentativasRestantes + " tentativas.");
                } else {
                    System.out.println("Você não tem mais tentativas. Encerrando o programa.");
                }
            }
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if (parametroUm >= parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }
        
        int contagem = parametroDois - parametroUm;
        // realizar o for para imprimir os números com base na variável contagem
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}
