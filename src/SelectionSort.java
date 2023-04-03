
public class SelectionSort extends Corpo{

	
	public static int[] veta = new int[Principal.tamanhoDoVetor];
	
	public int[] SELECTION(int[] vet) {
		
			
			
			if(step >= Principal.tamanhoDoVetor){
				step = 0;
			}
			if(step < 0) {
				step = Principal.tamanhoDoVetor - 1;
			}
	
	
			int a = step;
			for(int j = step + 1; j < vet.length; j++){
				if(j >= 0 && j <= vet.length) {
				}
				if(vet[j] < vet[a]) {
					a = j;
					}
				}
			
					int temp = vet[a];
					vet[a] = vet[step];
					vet[step] = temp;
			
	return vet;
	
	}
}
	

