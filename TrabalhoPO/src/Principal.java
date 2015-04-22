import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;


public class Principal {
	//private static ListEnc lista = new ListEnc();
	private static Dados[] vetorDados = new Dados[500];
	private static MetodosOrdenacao metodos = new MetodosOrdenacao();
	
	private static void carregaDados(String caminho) throws ParseException {
		try {
			File arquivo = new File(caminho);
			FileReader reader = new FileReader(arquivo);
			BufferedReader in = new BufferedReader(reader);
			String linha = "";
			String campo[];
			int i = 0;
			while ((linha = in.readLine()) != null) {
				campo = linha.split(";");
				//lista.insereUltimo(new Dados(campo[0], campo[1], campo[2], campo[3]));
				vetorDados[i] = new Dados(campo[0], campo[1], campo[2], campo[3]);
				i++;
			}
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws ParseException {
		long tempo = System.currentTimeMillis();	
		carregaDados("./Dados/Entrada/cliente500alea.txt");
		tempo = System.currentTimeMillis() - tempo;
		
		//System.out.println(lista.toString());
		ImprimeVetorDados();
		System.out.println("Tempo: " + tempo);
		
		metodos.quicksort(vetorDados);
		ImprimeVetorDados();
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
