// Felipe Vieira Lilli 
// 03/2023 - 04/2023
// Teste com JFrame

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Principal {

	//Variavéis para controle das dimensões da tela (hd : altura, wd: largura):
	public static int hd = 600;
	public static int wd = 1200;
	// teste
	// Variavél para o tamanho do vetor:
	public static int tamanhoDoVetor = 70;
	
	// Vetor principal:
	public static int[] vetor = new int[tamanhoDoVetor];

	// Variavéis para controle do código:
	public static boolean reset = false;
	public static boolean primeira = true;
	
	// Instanciamento de classes:
	public static Dimension d = new Dimension(wd,hd);
	public static MJFrame frame = new MJFrame();

	
	// Variavél para o(s) botão(ões) inicial(is) // Adicionar uma string no array cria um botão funcional
	public static String[] algoritS = {
			"Selection Sort",
			"Bubble Sort",
			"Insert Sort",
			"Shell Sort",
			};
	
	//Quantidade de botões que cabem na tela em uma coluna // Feito manualmente para quebrar a coluna mais à frente 
	public static int qntB = 7;
 	
	
	
	public static void SsFrame() {
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setMinimumSize(d);
		frame.setVisible(true);
		frame.setLocation(200,100);
		frame.pack();
		frame.setBackground(Color.BLACK);
		frame.addKeyListener(new Teclado());
		frame.isFocused();
		
		}
	
	public static void main(String[] args) {
		Corpo c = new Corpo();
		c.preencheTudo(vetor);
		SsFrame();
		while(true) {
			// O while para de funcionar caso não tenha algo além do if dentro dele
			// e nessa situação não posso deixar apenas "while(reset)" pois só teria uma verificação
		System.out.print("");	
			if(reset == true) {
				reset = false;
				primeira = true;
				c.preencheTudo(vetor);
				Corpo.step = 0;
			}

		}
	
	}


}


class MJFrame extends JFrame{
	
	
	/**
	 * 	Classe para a desenhar na tela
	 */
	
	private static final long serialVersionUID = 1L;
	
	// Variavéis para controle do posicionamento das colunas:
	//
	// Controla o espaço entre cada coluna:
	public static int esp = 15;
	
	// Controla a posição y da 2ª aba de coluna:
	public static int pos2 = 300;
	
	// Espaço da coluna destaque sobre a coluna normal:
	static int dtq = 10;
	
	// Vetor para ser alterado pelos algorítimos
	public static int[] veta = new int[Principal.tamanhoDoVetor];

	// Variavél para decidir se o menu  vai aparecer:
	public static boolean pause = true;
	
	// Variavél para escolha do botão;
	public static int escolha = 0;

	// Instanciamento das classes dos algorítimos:
	public static SelectionSort sS = new SelectionSort();
	public static BubbleSort bS = new BubbleSort();
	public static InsertSort iS = new InsertSort();
	public static ShellSort hS = new ShellSort();
	
	
	@Override
	public void paint(Graphics g) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0,0,Principal.wd,Principal.hd);
	
			//If para decidir se o menu aparecerá ou não:
			if(pause == true) {
		menu(g);
		
		}else if(pause == false) {
			
		// Switch para escolher um algorítmo:
		switch(escolha){
		case 0:
			veta = sS.SELECTION(Principal.vetor);
			escrever(g);
			desenhar(g);
			break;
		case 1:
			veta = bS.BUBBLE(Principal.vetor);
			escrever(g);
			desenhar(g);
			g.setColor(Color.RED);
			g.fillRect(50+((Corpo.step+1)*esp)-2, pos2+dtq, 10, veta[Corpo.step+1]);
			g.setColor(Color.BLACK);
			g.drawRect(50+((Corpo.step+1)*esp)-2, pos2+dtq, 10, veta[Corpo.step+1]);
			break;
		case 2:
			veta = iS.INSERT(Principal.vetor);
			escrever(g);
			desenhar(g);
			g.setColor(Color.BLACK);
			g.fillRect(50+((Corpo.counter)*esp)-2, pos2+dtq, 10, veta[Corpo.counter]);	
			break;
		case 3:
			veta = hS.SHELL(Principal.vetor);
			escrever(g);
			desenhar(g);
			if((Corpo.step - hS.h)>= 0) {
			g.setColor(Color.BLACK);
			g.fillRect(50+((Corpo.step - hS.h)*esp)-2, pos2+dtq, 10, veta[Corpo.step-hS.h]);	
			}
			break;
		case 4:
			
			break;
		
		}
		}
		
		}
	
	
	private void menu(Graphics g) {
		
		//Valor 50 padrão para ser usado de cordenada, pois precisam ser resetadas
		int pattern = 50;
		
		//Ponto X que será feito o botão
		int pX = pattern;
		//Ponto Y que será feito o botão 
		int pY = pattern;
		
		//Largura do botão
		int bW = 150;
		//Altura do botão
		int bH = 50;
		
		
		
		//Preciso que quano a é = ou > que 7 ele crie outra coluna sem estragar a posição das primeiras;
		
		for(int a = 0; a < Principal.algoritS.length ; a++) {
		//Feito manualmente porque não vai chegar nem perto de 21;
			if(a==Principal.qntB || a==Principal.qntB*2 || a == Principal.qntB*3 | a == Principal.qntB*4) {
				// Resetar a posição Y dos botões próximos botões e aumentar a Posição X para não sobreescrever os anteriores:
				pY = pattern;
				pX += bW+pattern;
			}
			
		g.setColor(Color.BLACK);
		g.drawRect(pX,pY,bW,bH);

		
		
		if(a == escolha) {
			g.setColor(Color.RED);
		}
		else 
		{
		g.setColor(Color.GRAY);
		}
		
		g.fillRect(pX,pY,bW,bH);
		g.setColor(Color.WHITE);
		g.drawString(Principal.algoritS[a], pX+10,pY+30);
		// aumentar a posição y do botão a cada botão desenhado
		pY += (70);
		}

	}
	
	private void desenhar(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(50+(Corpo.step*esp)-2, pos2+dtq, 10, veta[Corpo.step]);
		g.setColor(Color.BLACK);
		g.drawRect(50+(Corpo.step*esp)-2, pos2+dtq, 10, veta[Corpo.step]);
		
	}

	private void escrever(Graphics g) {
		String[] c = new String[Principal.tamanhoDoVetor + 1];
		for(int i = 0; i < Principal.tamanhoDoVetor -1; i++) {
			c[i] =  Integer.toString(Corpo.test[i]);
			g.setColor(Color.WHITE);
			g.drawString(c[i], 50+(i*esp), 50);
			g.drawRect(50+(i*esp), 50, 10, Corpo.test[i]);
		}
		
		for(int i = 0; i < veta.length; i++) {
			c[i] =  Integer.toString(veta[i]);
			
			g.setColor(Color.GREEN);
			g.fillRect(50+(i*esp), pos2, 10, veta[i]);
			g.setColor(Color.BLUE);
			g.drawRect(50+(i*esp), pos2, 10, veta[i]);
			
			}
		
		for(int i = 0; i < veta.length; i++) {
			c[i] =  Integer.toString(veta[i]);
		
			g.setColor(Color.WHITE);
			g.drawString(c[i], 50+(i*esp), pos2);
		}
	}
}

class Teclado extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) {
		int a = e.getKeyCode();

		//pintar novamente apenas após pressinar alguma tecla
		Principal.frame.repaint();
		
		if(!MJFrame.pause) {
		if(a == KeyEvent.VK_RIGHT) {
			Corpo.step += 1;
		}
		if(a == KeyEvent.VK_LEFT) {
			Corpo.step -= 1;
		}
		if(a == KeyEvent.VK_ESCAPE) {
			MJFrame.pause = true;
		}
		}else {
		if(a == KeyEvent.VK_UP) {
			MJFrame.escolha -= 1;
		}
		
		if(a == KeyEvent.VK_DOWN) {
			MJFrame.escolha += 1;
		}
		if(a == KeyEvent.VK_RIGHT) {
			MJFrame.escolha += Principal.qntB;
		}
		if(a == KeyEvent.VK_LEFT) {
			MJFrame.escolha -= Principal.qntB;
		}
		
		if(MJFrame.escolha > Principal.algoritS.length - 1) {
			MJFrame.escolha = 0;
		}else if(MJFrame.escolha < 0) {
			MJFrame.escolha = Principal.algoritS.length - 1;
		}
		
		if(a == KeyEvent.VK_ENTER) {
			MJFrame.pause = false;
		}
		
		}
		if(a == KeyEvent.VK_1) {
			Principal.reset = true;
		}
		if(a == KeyEvent.VK_2) {
			System.exit(0);
		}
		
	}

}