
public class InsertSort extends Corpo {

	public int[] INSERT(int vet[]) {
			
	
		if(step  >= Principal.tamanhoDoVetor){
			step = 0;
		}
		if(step < 0) {
			step = Principal.tamanhoDoVetor - 2;
		}
		
			  int key = vet[step];
		      int x = step - 1;
		      
				
		      while (x >= 0 && key < vet[x]) {
		    	  vet[x + 1] = vet[x];
		    	  counter = x;
		        --x;
		      }
	
		      vet[x + 1] = key;

		     
		      return vet;	
	}

	
}
