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
			BufferedReader in = new BufferedReader(new FileReader(new File(ENTRADA + arquivo + ".txt")));
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
	
	public static void ler(ListaEnc dados, String arquivo) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(ENTRADA + arquivo + ".txt")));
			String linha = "";
			String campo[];
			
			while ((linha = in.readLine()) != null) {
				campo = linha.split(";");
				dados.insereUltimo(new Item(campo[0], campo[1], campo[2], campo[3]));
			}
			
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ler(ArvoreABB arv, String arquivo) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(ENTRADA + arquivo + ".txt")));
			String linha = "";
			String campo[];
			
			while ((linha = in.readLine()) != null) {
				campo = linha.split(";");
				arv.insere(new Item(campo[0], campo[1], campo[2], campo[3]));
			}
			
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ler(ArvoreAVL arv, String arquivo) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(ENTRADA + arquivo + ".txt")));
			String linha = "";
			String campo[];
			
			while ((linha = in.readLine()) != null) {
				campo = linha.split(";");
				arv.insereRaiz(new Item(campo[0], campo[1], campo[2], campo[3]));
			}
			
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ler(String[] vetorCPF) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(ENTRADA + "cpf.txt"));
			String linha = "";
			int i = 0;
			
			while ((linha = in.readLine()) != null) {
				vetorCPF[i] = linha;
				i++;
			}
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void gravar(Item[] dados, String arquivo) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(SAIDA + arquivo + ".txt")));
			for (int i = 0; i < dados.length && dados[i] != null; i++) {
				out.write(dados[i].getCpf() + ";" 
						+ dados[i].getNome() + ";" 
						+ dados[i].getData() + ";" 
						+ dados[i].getValor());
				out.newLine();
			}
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void gravar(ListaEnc dados, String arquivo) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(SAIDA + arquivo + ".txt")));
			
			No no = dados.getPrim();
			while (no != null) {
				out.write(no.toString());
				out.newLine();
			}
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void gravar(String[] dados, String arquivo) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(SAIDA + arquivo + ".txt")));
			for (int i = 0; i < dados.length; i++) {
				out.write(dados[i]);
				out.newLine();
				out.newLine();
			}
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
