import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;


public class Principal {
	private static ListEnc lista = new ListEnc();
	
	private static void carregaDados(String caminho) throws ParseException {
		try {
			File arquivo = new File(caminho);
			FileReader reader = new FileReader(arquivo);
			BufferedReader in = new BufferedReader(reader);
			String linha = "";
			String campo[];
			
			while ((linha = in.readLine()) != null) {
				campo = linha.split(";");
				lista.insereUltimo(new Item(Long.parseLong(campo[0]), campo[1], campo[2], campo[3]));
			}
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws ParseException {
		long tempoInicial = System.nanoTime();
		long tempo;
		
		carregaDados("./Dados/Entrada/cliente500alea.txt");
		tempo = System.nanoTime() - tempoInicial;
		System.out.println("Tempo para carregar dados: " + tempo);
		
		lista.quickSort();
		
		System.out.println(lista.toString());
		
		
		
		System.out.println("Tempo para carregar dados: " + tempo);
		System.out.println("Tempo para exibir lista: " + (System.nanoTime() - tempo - tempoInicial));
		
		tempo = System.nanoTime() - tempoInicial;
		System.out.println("Tempo Total: " + tempo);
	}
}
