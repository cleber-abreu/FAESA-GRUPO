import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Arquivo {
	
	private static final String ENTRADA = "./Dados/Entrada/";
	private static final String SAIDA = "./Dados/Saida/";
	
	public static void ler(Item[] vetorDados, String arquivo) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(ENTRADA + arquivo)));
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
	
	public static void gravar(Item[] vetorDados, String arquivo) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(SAIDA + arquivo)));
			for (int i = 0; i < vetorDados.length; i++) {
				out.write(vetorDados[i].getCpf() + ";" 
						+ vetorDados[i].getNome() + ";" 
						+ vetorDados[i].getData() + ";" 
						+ vetorDados[i].getValor());
				out.newLine();
			}
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void lerCpf(String[] VetorCPF) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(ENTRADA + "cpf.txt"));
			String linha = "";
			int i = 0;
			
			while ((linha = in.readLine()) != null) {
				VetorCPF[i] = linha;
				i++;
			}
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void gravarCpf(String[] vetorCpf, String arquivo) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(SAIDA + arquivo)));
			for (int i = 0; i < vetorCpf.length; i++) {
				out.write(vetorCpf[i]);
				out.newLine();
			}
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
