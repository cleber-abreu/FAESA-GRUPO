

public class Principal {
	private static Item[] vetorDados;
	private static MetodosOrdenacao metodos = new MetodosOrdenacao();
	
	public static void main(String[] args) {
		long tempoInicial = 0;// = System.currentTimeMillis();
		long tempoCarrega = 0, tempoOrdena = 0, tempoTotal = 0, tempoPesquisa = 0;
		ArvoreABB abb;
		ArvoreAVL avl;
		boolean primeiroLoop;
		long tempoVetorQS = 0, tempoVetorQI = 0, tempoABB = 0, tempoAVL = 0, tempoHash = 0;
		
		//String[] tipos = {"alea","ord","inv"};
		String[] tipos = {"alea","ord","inv"};
		String nomeArquivo = "";
		String[] cpf;
		//int[] tamanhos = {500,1000,5000,10000,50000};
		int[] tamanhos = {500};
		
		for (int j = 0; j < tamanhos.length; j++) {
			for (int k = 0; k < tipos.length; k++) {
				tempoVetorQS = 0; tempoVetorQI = 0; tempoABB = 0; tempoAVL = 0; tempoHash = 0;
				primeiroLoop = true;
				for (int l = 0; l < 6; l++) {
					tempoCarrega = 0; tempoOrdena = 0; tempoTotal = 0; tempoPesquisa = 0;
					
					/* VETOR QUICKSORT */
					tempoInicial = System.currentTimeMillis();
					
					vetorDados = new Item[tamanhos[j]];
					nomeArquivo = "cliente"+tamanhos[j]+tipos[k];
					Arquivo.ler(vetorDados, nomeArquivo);
					
					metodos.quicksort(vetorDados);
					Arquivo.gravar(vetorDados, nomeArquivo);

					cpf = new String[200];
					Arquivo.lerCpf(cpf); //A gravação do arquivo cpf é feita diretamente no método "Arquivo.lerCpf"
					MetodosPesquisa.pesqBinaria(vetorDados, cpf);

					tempoTotal = System.currentTimeMillis() - tempoInicial;
					
					//Se não for o primeiro loop, começa a grava o tempo gasto, foi feito isso porque o tempo gasto 
					//para ler o arquivo na primeira vez é maior;  
					if (!primeiroLoop) {
						System.out.println("Total Quick: "+tempoTotal);
						tempoVetorQS += tempoTotal;
					}
					
					/* VETOR QUICKSORT + INSERÇÃO */
					tempoInicial = System.currentTimeMillis();
					
					vetorDados = new Item[tamanhos[j]];
					nomeArquivo = "cliente"+tamanhos[j]+tipos[k];
					Arquivo.ler(vetorDados, nomeArquivo);
					
					metodos.quickInsert(vetorDados);
					Arquivo.gravar(vetorDados, nomeArquivo);

					cpf = new String[200];
					Arquivo.lerCpf(cpf); //A gravação do arquivo cpf é feita diretamente no método "Arquivo.lerCpf"
					
					MetodosPesquisa.pesqBinaria(vetorDados, cpf);

					tempoTotal = System.currentTimeMillis() - tempoInicial;
					
					//Se não for o primeiro loop, começa a grava o tempo gasto, foi feito isso porque o tempo gasto 
					//para ler o arquivo na primeira vez é maior;  
					if (!primeiroLoop) {
						System.out.println("Total Quick Insert: "+tempoTotal);
						tempoVetorQI += tempoTotal;
					}
					
					/* ABB */
					nomeArquivo = "cliente"+tamanhos[0]+tipos[0];
					tempoInicial = System.currentTimeMillis();
					abb = new ArvoreABB();
					Arquivo.ler(abb, nomeArquivo);
					//tempoCarrega = System.nanoTime() - tempoInicial;
					
					abb.arvBalanceada();
					//tempoOrdena = System.nanoTime() - tempoInicial - tempoCarrega;
					
					Arquivo.gravar( abb.camCentral(), "ABB-"+ tamanhos[0]);
					tempoTotal = System.currentTimeMillis() - tempoInicial;
					if (!primeiroLoop) tempoABB += tempoTotal;
					
					/*System.out.println("\nABB"
							+ "\nCarregar dados : " + tempoCarrega
							+ "\nBalanceamento  : " + tempoOrdena
							+ "\nTotal          : " + tempoTotal);
					*/
					
					/* AVL */
					/*
					tempoInicial = System.nanoTime();
					avl = new ArvoreAVL();
					Arquivo.ler(avl, nomeArquivo);
					tempoCarrega = System.nanoTime() - tempoInicial;
					
					Arquivo.gravar(avl.vetorOrdenado(), "AVL");
					tempoTotal = System.nanoTime() - tempoInicial;
					if (!primeiroLoop) tempoAVL += tempoTotal;
					System.out.println("\nAVL"
							+ "\nCarregar dados : " + tempoCarrega
							+ "\nTotal          : " + tempoTotal);

					*/
					
					primeiroLoop = false;
					
				}
				//System.out.println(tamanhos[j]+" - "+ tipos[k]+ " - Total Vetor Quick: " +(tempoVetorQS));
				System.out.println(tamanhos[j]+" - "+ tipos[k]+ " - Média Vetor Quick: " +(tempoVetorQS/5));
				//System.out.println(tamanhos[j]+" - "+ tipos[k]+ " - Total Vetor Quick Insert: " +(tempoVetorQI));
				System.out.println(tamanhos[j]+" - "+ tipos[k]+ " - Média Vetor Quick Insert: " +(tempoVetorQI/5));
				//System.out.println(tamanhos[j]+" - "+ tipos[k]+ " - Total ABB: " +(tempoABB));
				System.out.println(tamanhos[j]+" - "+ tipos[k]+ " - Média ABB: " +(tempoABB/5));
				//System.out.println(tamanhos[j]+" - "+ tipos[k]+ " - Média AVL: " +(tempoAVL/5));
			}
		}
		
		
		/*
		 * PESQUISA BINÁRIA EM 200 CPFs
		 */
		
		/*
		tempoInicial = System.nanoTime();
		
		String[] cpf = new String[200];
		Arquivo.lerCpf(cpf);
		tempoCarrega = System.nanoTime() - tempoInicial;
		
		MetodosPesquisa.pesqBinaria(vetorDados, cpf);
		tempoOrdena = System.nanoTime() - tempoInicial - tempoCarrega;
		
		tempoTotal = System.nanoTime() - tempoInicial;
		
		System.out.println("\nPESQUISA BINÁRIA EM 200 CPFs"
				+ "\nCarregar dados : " + tempoCarrega
				+ "\nOrdenação      : " + tempoOrdena
				+ "\nTotal          : " + tempoTotal);
		*/
	}
	
	public static void imprimeVetorDados(){
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
