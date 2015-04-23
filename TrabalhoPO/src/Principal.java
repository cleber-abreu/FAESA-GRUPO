import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Principal {
	private static Item[] vetorDados = new Item[500];
	private static MetodosOrdenacao metodos = new MetodosOrdenacao();
	
	private static void carregaDados(String caminho) {
		try {
			File arquivo = new File(caminho);
			FileReader reader = new FileReader(arquivo);
			BufferedReader in = new BufferedReader(reader);
			String linha = "";
			String campo[];
			int i = 0;
			
			while ((linha = in.readLine()) != null) {
				campo = linha.split(";");
				vetorDados[i] = new Item(campo[0], campo[1], campo[2], campo[3]);
				i++;
			}
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		long tempoInicial = System.nanoTime();
		long tempoCarrega, tempoOrdena, tempoTotal;
		
		carregaDados("./Dados/Entrada/cliente500alea.txt");
		tempoCarrega = System.nanoTime() - tempoInicial;
		
		//ImprimeVetorDados();
				
		metodos.quicksort(vetorDados);
		tempoOrdena = System.nanoTime() - tempoInicial - tempoCarrega;
		
		tempoTotal = System.nanoTime() - tempoInicial;
		ImprimeVetorDados();
		
		System.out.println("TEMPO"
				+ "\nCarrega dados : " + tempoCarrega
				+ "\nOrdena        : " + tempoOrdena
				+ "\nTotal         : " + tempoTotal);
	}
	
	public static void ImprimeVetorDados(){
		String mostraVetor = "\n";
		for (int i = 0; i < vetorDados.length; i++) {
			mostraVetor += vetorDados[i].getCpf() + " \t-\t" 
					+ vetorDados[i].getNome() + " \t-\t" 
					+ vetorDados[i].getData() + " \t-\t" 
					+ vetorDados[i].getValor() + "\n";
		}
		System.out.println(mostraVetor);
	}
}
