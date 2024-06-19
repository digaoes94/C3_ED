package presidio;

import presidio.ItemPR;

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
}