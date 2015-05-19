

public class Principal {
	private static Item[] vetorDados;
	private static MetodosOrdenacao metodos = new MetodosOrdenacao();
	
	public static void main(String[] args) {
		long tempoInicial;// = System.currentTimeMillis();
		long tempoCarrega, tempoOrdena, tempoTotal = 0;
		
		//String[] tipos = {"alea","ord","inv"};
		String[] tipos = {"alea"};
		String nomeArquivo = "";
		//int[] tamanhos = {500,1000,5000,10000,50000};
		int[] tamanhos = {500};
		
		for (int j = 0; j < tamanhos.length; j++) {
			for (int k = 0; k < tipos.length; k++) {
				for (int l = 0; l < 1; l++) {
					
					/*
					 * QUICK SORT
					 */
					vetorDados = new Item[tamanhos[j]];
					tempoInicial = System.nanoTime();
					
					nomeArquivo = "cliente"+tamanhos[j]+tipos[k];
					Arquivo.ler(vetorDados, nomeArquivo);
					tempoCarrega = System.nanoTime() - tempoInicial;
					
					metodos.quicksort(vetorDados);
					tempoOrdena = System.nanoTime() - tempoInicial - tempoCarrega;
					
					tempoTotal = System.nanoTime() - tempoInicial;
					System.out.println(nomeArquivo);

					Arquivo.gravar(vetorDados, nomeArquivo);
					
					System.out.println("\nQUICK SORT"
							+ "\nCarregar dados : " + tempoCarrega
							+ "\nOrdenação      : " + tempoOrdena
							+ "\nTotal          : " + tempoTotal);
					
					/*
					 * ABB
					 */
					nomeArquivo = "cliente"+tamanhos[0]+tipos[0];
					tempoInicial = System.nanoTime();
					ArvoreABB abb = new ArvoreABB();
					Arquivo.ler(abb, nomeArquivo);
					tempoCarrega = System.nanoTime() - tempoInicial;
					
					abb.arvBalanceada();
					tempoOrdena = System.nanoTime() - tempoInicial - tempoCarrega;
					
					Arquivo.gravar( abb.camCentral(), "ABB-"+ tamanhos[0]);
					tempoTotal = System.nanoTime() - tempoInicial;
					
					System.out.println("\nABB"
							+ "\nCarregar dados : " + tempoCarrega
							+ "\nBalanceamento  : " + tempoOrdena
							+ "\nTotal          : " + tempoTotal);
					
					/*
					 * AVL
					 */
					tempoInicial = System.nanoTime();
					ArvoreAVL avl = new ArvoreAVL();
					Arquivo.ler(avl, nomeArquivo);
					tempoCarrega = System.nanoTime() - tempoInicial;
					
					Arquivo.gravar(avl.vetorOrdenado(), "AVL");
					tempoTotal = System.nanoTime() - tempoInicial;
					
					System.out.println("\nAVL"
							+ "\nCarregar dados : " + tempoCarrega
							+ "\nTotal          : " + tempoTotal);
				}
			}
		}
		
		/*
		 * PESQUISA BINÁRIA EM 200 CPFs
		 */
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
