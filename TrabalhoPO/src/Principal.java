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
				lista.insereUltimo(new Dados(campo[0], campo[1], campo[2], campo[3]));
			}
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws ParseException {
		long tempo = System.nanoTime();
		
		carregaDados("./Dados/Entrada/cliente50000alea.txt");
		System.out.println(lista.toString());
		
		tempo = System.nanoTime() - tempo;
		System.out.println("Tempo: " + tempo);
	}
}
