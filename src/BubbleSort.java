
public class BubbleSort extends Corpo{
	
	public static int s1 = 0;
	public int[] BUBBLE(int vet[]) {

		int sub;
		
		
		if(step + 1 >= Principal.tamanhoDoVetor){
			step = 0;
		}
		if(step < 0) {
			step = Principal.tamanhoDoVetor - 2;
		}
		
			if(vet[step] > vet[step+1])
			{
	    		  sub = vet[step];
	    		  vet[step] = vet[step+1];
	    		  vet[step+1] = sub;
	    		
	      }
		
		
		return vet;
			
	}
	
	
	
}
