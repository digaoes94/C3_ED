package presidiario;

import presidiario.ItemPS;

public class NoPS {
	private ItemPS item;
	private NoPS esq, dir;
	
	public NoPS(ItemPS item) {
		this.item = item;
		this.esq = null;
		this.dir = null;
	}

	public ItemPS getItem() {
		return item;
	}
	public void setItem(ItemPS item) {
		this.item = item;
	}

	public NoPS getEsq() {
		return esq;
	}
	public void setEsq(NoPS esq) {
		this.esq = esq;
	}

	public NoPS getDir() {
		return dir;
	}
	public void setDir(NoPS dir) {
		this.dir = dir;
	}
	
	@Override
	public String toString() {
		String resumo = "";
		
		resumo += "Presidiário: " + this.item.getNome() + ". Idade: " + this.item.getIdade() + "./n";
		resumo += "Código: " + this.item.getCodigo() + ". Presídio: " + this.item.getPresidio() + ".";
		
		return resumo;
	}
}
