
public class ListaSE {
	private	NoSimples inic = new NoSimples();
	//criar No simples;
	
	public void insereInc(NoSimples novo){
		if(inic != null){
			novo.setProx(this.inic);
			inic= novo;
		}
		else{
			inic= novo;
		}
	}
	
	public Item pesqLS(long cpf){
		NoSimples aux=this.inic;
		while(aux.getI().getCpfLong()!=cpf && aux!=null){
			aux=aux.getProx();
		}
		return aux.getI();
	}
	public ListaSE() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
