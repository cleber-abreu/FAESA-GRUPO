import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Principal {
	ListEnc lista = new ListEnc();
	
	private static void carregaDados(String caminho) {
		try {
			File arquivo = new File(caminho);
			FileReader reader = new FileReader(arquivo);
			BufferedReader in = new BufferedReader(reader);
			String linha;
			
			while ((linha = in.readLine()) != null) {
				System.out.println(linha);
			}
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
			
		carregaDados("./Dados/Entrada/cliente20alea.txt");
	}
}
