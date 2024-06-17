package auxiliary;

import auxiliary.ItemSTR;
import auxiliary.NoSTR;

public class ListaSTR {
	private NoSTR prim;
	private NoSTR ult;
	private int qtdNos;
	
	public ListaSTR() {
		this.prim = null;
		this.ult = null;
		this.qtdNos = 0;
	}

	public NoSTR getPrim() {
		return prim;
	}
	public void setPrim(NoSTR prim) {
		this.prim = prim;
	}

	public NoSTR getUlt() {
		return ult;
	}
	public void setUlt(NoSTR ult) {
		this.ult = ult;
	}

	public int getQtdNos() {
		return qtdNos;
	}
	public void setQtdNos(int qtdNos) {
		this.qtdNos = qtdNos;
	}

	public boolean eVazia() {
		return (this.prim == null);
	}

	public void inserir(ItemSTR item) {
		NoSTR novoNo = new NoSTR(item);

		if (this.eVazia()) {
			this.prim = novoNo;
		}
		else {
			this.ult.setProx(novoNo);
		}

		this.ult = novoNo;
		this.qtdNos++;
	}
}
