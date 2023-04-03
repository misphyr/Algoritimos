
public class ShellSort extends Corpo {

	public int h = 1;
	public int c, j;
	public int[] SHELL(int[] vet) {

		if(step >= Principal.tamanhoDoVetor){
			step = 0;
			h /= 2;
		}

		if(step < 0) {
			step = Principal.tamanhoDoVetor - 1;
			h *= 2;
		}

		if(Principal.primeira == true) {
			h = 1;
		while(h < vet.length) {
			h = h * 3 + 1;
		}

		h /= 3;
		Principal.primeira= false;
		}
				c = vet[step];
				j = step;

				while(j >= h && vet[j - h] > c) {
			
					vet[j] = vet[j - h];
					j -= h;
					
				}
				
				vet[j] = c;
				
	return vet;
	}
}
