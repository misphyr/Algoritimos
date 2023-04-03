import java.util.Random;

// corpo
public class Corpo {

	public static int counter = 0;
	public static int[] test = new int[Principal.tamanhoDoVetor];

	public static int step = 0;

	//Função para encher o vetor com números aleatórios
	public  void preencheTudo(int[] vet) {
		Random r = new Random();
		for(int i = 0; i < vet.length; i++) {
			vet[i] = r.nextInt(100);
			test[i] = vet[i];
		}
	}
	
	
	
	
	}


