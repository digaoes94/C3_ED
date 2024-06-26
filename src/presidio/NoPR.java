package presidio;

public class NoPR {
	private ItemPR item;
	private NoPR esq, dir;
	
	public NoPR(ItemPR item) {
		this.item = item;
		this.esq = null;
		this.dir = null;
	}

	public ItemPR getItem() {
		return item;
	}
	public void setItem(ItemPR item) {
		this.item = item;
	}

	public NoPR getEsq() {
		return esq;
	}
	public void setEsq(NoPR esq) {
		this.esq = esq;
	}

	public NoPR getDir() {
		return dir;
	}
	public void setDir(NoPR dir) {
		this.dir = dir;
	}
	
	@Override
	public String toString() {
		String resumo = "";
		
		resumo += "Presídio: " + this.item.getNome() + ". Código: " + this.item.getCodigo() + ".\n";
		resumo += "Cidade: " + this.item.getCidade() + ".";
		
		return resumo;
	}
}