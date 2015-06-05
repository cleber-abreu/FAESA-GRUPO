
public class Hashing {
	private ListaSE[] vetEnc ;
	private int m;
	
	public void insereH(Item item){
		NoSimples aux = new NoSimples();
		aux.setI(item);
		int n = (int) (item.getCpfLong()%m);
		vetEnc[n].insereInc(aux);
	}
	
	public void pesquisa(Item p){
		int n=(int) (p.getCpfLong()%m);	
		vetEnc[n].pesqLS(p.getCpfLong());
	}

	public Hashing(int tam) {
		int t = (int) (tam*(1.1));
		this.vetEnc = new ListaSE[t];
		this.m = Prime.closestPrime(tam);	
	}

}
