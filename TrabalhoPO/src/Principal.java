
public class Principal {
	private static Item[] vetorDados;

	public static void main(String[] args) {
		long tempoInicial = 0, tempoTotal = 0;
		ArvoreABB abb;
		ArvoreAVL avl;
		Hashing hash;
		boolean primeiroLoop;
		long tempoVetorQS = 0, tempoVetorQI = 0, tempoABB = 0, tempoAVL = 0, tempoHash = 0;
		String[] tipos = {"alea","ord","inv"};
		String nomeArquivo = "";
		String[] cpf;
		int[] tamanhos = {500,1000,5000,10000,50000};
		
		double testeTempoI = System.currentTimeMillis();
		double testeTempoF = 0;
		
		for (int j = 0; j < tamanhos.length; j++) {
			System.out.println("====================================================");
			for (int k = 0; k < tipos.length; k++) {
				tempoVetorQS = 0; tempoVetorQI = 0; tempoABB = 0; tempoAVL = 0; tempoHash = 0;
				primeiroLoop = true;
				for (int l = 0; l < 6; l++) {
					tempoTotal = 0;
					nomeArquivo = "cliente"+tamanhos[j]+tipos[k];
					cpf = new String[200];
					Arquivo.ler(cpf);
					
					/* VETOR QUICKSORT */
					
					tempoInicial = System.currentTimeMillis();
					
					vetorDados = new Item[tamanhos[j]];
					Arquivo.ler(vetorDados, nomeArquivo);
					
					MetodosOrdenacao.quicksort(vetorDados);
					Arquivo.gravar(vetorDados, "vetorQS-"+tamanhos[j]+tipos[k]);

					Arquivo.gravar(MetodosPesquisa.pesqBinaria(vetorDados, cpf), "vetorQS-PESQ-"+tamanhos[j]+tipos[k]);

					tempoTotal = System.currentTimeMillis() - tempoInicial;
					
					//Se não for o primeiro loop, começa a grava o tempo gasto, foi feito isso porque o tempo gasto 
					//para ler o arquivo na primeira vez é maior;  
					if (!primeiroLoop) {
						tempoVetorQS += tempoTotal;
					}
					
					
					/* VETOR QUICKSORT + INSERÇÃO */
					
					tempoInicial = System.currentTimeMillis();
					
					vetorDados = new Item[tamanhos[j]];
					Arquivo.ler(vetorDados, nomeArquivo);
					
					MetodosOrdenacao.quickInsert(vetorDados);
					Arquivo.gravar(vetorDados, "vetorQI-"+tamanhos[j]+tipos[k]);
					
					Arquivo.gravar(MetodosPesquisa.pesqBinaria(vetorDados, cpf), "vetorQI-PESQ-"+tamanhos[j]+tipos[k]);

					tempoTotal = System.currentTimeMillis() - tempoInicial;
					
					//Se não for o primeiro loop, começa a grava o tempo gasto, foi feito isso porque o tempo gasto 
					//para ler o arquivo na primeira vez é maior;  
					if (!primeiroLoop) {
						tempoVetorQI += tempoTotal;
					}
					
					
					/* ABB */
					
					tempoInicial = System.currentTimeMillis();
					abb = new ArvoreABB();
					Arquivo.ler(abb, nomeArquivo);
					
					abb.arvBalanceada();							
					Arquivo.gravar(abb.camCentral(), "ABB-"+tamanhos[j]+tipos[k]);					
					Arquivo.gravar(abb.pesquisa(cpf), "ABB-PESQ-"+ tamanhos[j]+tipos[k]);				
					tempoTotal = System.currentTimeMillis() - tempoInicial;
							
					if (!primeiroLoop) tempoABB += tempoTotal;
					
					
					
					/* AVL */
					
					tempoInicial = System.currentTimeMillis();
					avl = new ArvoreAVL();
					Arquivo.ler(avl, nomeArquivo);
					
					Arquivo.gravar(avl.vetorOrdenado(), "AVL-"+tamanhos[j]+tipos[k]);
					Arquivo.gravar(avl.pesquisa(cpf), "AVL-PESQ-"+ tamanhos[j]+tipos[k]);
					
					tempoTotal = System.currentTimeMillis() - tempoInicial;
					if (!primeiroLoop) tempoAVL += tempoTotal;
					
					
					/* HASHING */
					
					tempoInicial = System.currentTimeMillis();
					hash = new Hashing(tamanhos[j]);
					Arquivo.ler(hash, nomeArquivo);
					
					Arquivo.gravar(hash.pesquisa(cpf), "HASH-PESQ-"+ tamanhos[j]+tipos[k]);
					
					tempoTotal = System.currentTimeMillis() - tempoInicial;
					if (!primeiroLoop) tempoHash += tempoTotal;
					
					
					//depois do primeiro loop
					primeiroLoop = false;
				}
				
				System.out.println("Arquivo: " + tamanhos[j]+" - "+ tipos[k]+ " - Média Vetor Quick: " +(tempoVetorQS/5));
				System.out.println("Arquivo: " + tamanhos[j]+" - "+ tipos[k]+ " - Média Vetor Quick Insert: " +(tempoVetorQI/5));
				System.out.println("Arquivo: " + tamanhos[j]+" - "+ tipos[k]+ " - Média ABB: " +(tempoABB/5));
				System.out.println("Arquivo: " + tamanhos[j]+" - "+ tipos[k]+ " - Média AVL: " +(tempoAVL/5));
				System.out.println("Arquivo: " + tamanhos[j]+" - "+ tipos[k]+ " - Média HASHING: " +(tempoHash/5));
			}
		}
		
		testeTempoF = System.currentTimeMillis() - testeTempoI;
		System.out.println("tempo total gasto: "+FormataTempo(testeTempoF));
		
		System.out.println("FIM! =)");	
	}
	
	public static String TempoSegundos(double tempo){
		return tempo/1000 + " segundos";
	}
	
	public static String FormataTempo(double tempo){
		double horas = 0, min = 0, seg = 0, miliseg = 0;
		seg = (int)Math.abs(tempo/1000);
		miliseg = ((tempo/1000) - seg) * 1000;
		min = (int)Math.abs(seg/60);
		seg = ((seg/60) - min) * 60;
		horas = (int)Math.abs(min/60);
		min = ((min/60) - horas) *60;
		return (int)horas+":"+(int)min+":"+(int)seg+":"+(int)miliseg;
	}
	
}
