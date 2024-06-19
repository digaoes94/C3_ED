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
}
