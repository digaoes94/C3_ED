package presidio;

import presidio.ItemPR;
import presidio.NoPR;

public class ArvorePR {
	private NoPR raiz;
	private int qtdNos;
	
	public ArvorePR() {
		this.raiz = null;
		this.qtdNos = 0;
	}
	
	public boolean eVazia() {
		return (this.raiz == null);
	}
	
	public NoPR getRaiz() {
		return this.raiz;
	}
	
	public int getQtdNos() {
		return this.qtdNos;
	}
	
	public boolean inserir(ItemPR item) {
		if (pesquisar(item.getCodigo())) {
			return false;
		}
		else {
			this.raiz = inserir(item, this.raiz);
			this.qtdNos++;
			return true;
		}
	}
	public NoPR inserir(ItemPR item, NoPR no) {
		if (no == null) {
			NoPR novo = new NoPR(item);
			return novo;
		}
		else {
			if (item.getCodigo() < no.getItem().getCodigo()) {
				no.setEsq(inserir(item, no.getEsq()));
				return no;
			}
			else {
				no.setDir(inserir(item, no.getDir()));
				return no;
			}
		}
	}
	
	public boolean pesquisar(int codigo) {
		if (pesquisar(codigo, this.raiz) != null) {
			return true;
		}
		else {
			return false;
		}
	}
	private NoPR pesquisar(int codigo, NoPR no) {
		if (no != null) {
			if (codigo < no.getItem().getCodigo()) {
				no = pesquisar(codigo, no.getEsq());
			}
			else {
				if (codigo > no.getItem().getCodigo()) {
					no = pesquisar(codigo, no.getDir());
				}
			}
		}
		
		return no;
	}
	
	public boolean remover(int codigo) {
		if (pesquisar(codigo, this.raiz) != null) {
			this.raiz = remover(codigo, this.raiz);
			this.qtdNos--;
			return true;
		}
		else {
			return false;
		}
	}
	public NoPR remover(int codigo, NoPR no) {
		if (codigo < no.getItem().getCodigo()) {
			no.setEsq(remover(codigo, no.getEsq()));
		}
		else {
			if (codigo > no.getItem().getCodigo()) {
				no.setDir(remover(codigo, no.getDir()));
			}
			else {
				if (no.getDir() == null) {
					return no.getEsq();
				}
				else {
					if (no.getEsq() == null) {
						return no.getDir();
					}
					else {
						no.setEsq(Arrumar(no, no.getEsq()));
					}
				}
			}
		}
		
		return no;
	}
	
	private NoPR Arrumar(NoPR no, NoPR maior) {
		if (maior.getDir() != null) {
			maior.setDir(Arrumar(no, maior.getDir()));
		}
		else {
			no.setItem(maior.getItem());
			maior = maior.getEsq();
		}
		
		return no;
	}

	public ItemPR[] CamCentral() {
		int[] n = new int[1];
		n[0] = 0;
		ItemPR[] vet = new ItemPR[this.qtdNos];
		
		return (CamCentral(this.raiz, vet, n));
	}
	private ItemPR[] CamCentral(NoPR no, ItemPR[] vet, int[] n) {
		if (no != null) {
			vet = CamCentral(no.getEsq(), vet, n);
			vet[n[0]] = no.getItem();
			n[0]++;
			vet = CamCentral(no.getDir(), vet, n);
		}

		return vet;
	}

	public ItemPR[] CamPre() {
		int[] n = new int[1];
		n[0] = 0;
		ItemPR[] vet = new ItemPR[this.qtdNos];
		
		return (CamPre(this.raiz, vet, n));
	}
	private ItemPR[] CamPre(NoPR no, ItemPR[] vet, int[] n) {
		if (no != null) {
			vet[n[0]] = no.getItem();
			n[0]++;
			vet = CamPre(no.getEsq(), vet,n);
			vet = CamPre(no.getDir(), vet,n);
		}
		
	return vet;
	}

	public ItemPR[] CamPos() {
		int[] n = new int[1];
		n[0] = 0;
		ItemPR[] vet = new ItemPR[this.qtdNos];
		
		return (CamPos(this.raiz, vet, n));
	}
	private ItemPR[] CamPos(NoPR no, ItemPR[] vet, int[] n){
		if (no != null) {
			vet = CamPos(no.getEsq(), vet, n);
			vet = CamPos(no.getDir(), vet, n);
			vet[n[0]] = no.getItem();
			n[0]++;
		}
		
	return vet;
	}
}