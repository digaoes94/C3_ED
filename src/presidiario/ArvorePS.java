package presidiario;

import presidiario.ItemPS;
import presidiario.NoPS;
import auxiliary.*;

public class ArvorePS {
	private NoPS raiz;
	private int qtdNos;
	
	public ArvorePS() {
		this.raiz = null;
		this.qtdNos = 0;
	}
	
	public boolean eVazia() {
		return (this.raiz == null);
	}
	
	public NoPS getRaiz() {
		return this.raiz;
	}
	
	public int getQtdNos() {
		return this.qtdNos;
	}
	
	public boolean inserir(ItemPS item) {
		if (pesquisar(item.getCodigo())) {
			return false;
		}
		else {
			this.raiz = inserir(item, this.raiz);
			this.qtdNos++;
			return true;
		}
	}
	public NoPS inserir(ItemPS item, NoPS no) {
		if (no == null) {
			NoPS novo = new NoPS(item);
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
	private NoPS pesquisar(int codigo, NoPS no) {
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
	public NoPS remover(int codigo, NoPS no) {
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
	
	private NoPS Arrumar(NoPS no, NoPS maior) {
		if (maior.getDir() != null) {
			maior.setDir(Arrumar(no, maior.getDir()));
		}
		else {
			no.setItem(maior.getItem());
			maior = maior.getEsq();
		}
		
		return no;
	}

	public ItemPS[] CamCentral() {
		int[] n = new int[1];
		n[0] = 0;
		ItemPS[] vet = new ItemPS[this.qtdNos];
		
		return (CamCentral(this.raiz, vet, n));
	}
	private ItemPS[] CamCentral(NoPS no, ItemPS[] vet, int[] n) {
		if (no != null) {
			vet = CamCentral(no.getEsq(), vet, n);
			vet[n[0]] = no.getItem();
			n[0]++;
			vet = CamCentral(no.getDir(), vet, n);
		}

		return vet;
	}

	public ItemPS[] CamPre() {
		int[] n = new int[1];
		n[0] = 0;
		ItemPS[] vet = new ItemPS[this.qtdNos];
		
		return (CamPre(this.raiz, vet, n));
	}
	private ItemPS[] CamPre(NoPS no, ItemPS[] vet, int[] n) {
		if (no != null) {
			vet[n[0]] = no.getItem();
			n[0]++;
			vet = CamPre(no.getEsq(), vet,n);
			vet = CamPre(no.getDir(), vet,n);
		}
		
	return vet;
	}

	public ItemPS[] CamPos() {
		int[] n = new int[1];
		n[0] = 0;
		ItemPS[] vet = new ItemPS[this.qtdNos];
		
		return (CamPos(this.raiz, vet, n));
	}
	private ItemPS[] CamPos(NoPS no, ItemPS[] vet, int[] n){
		if (no != null) {
			vet = CamPos(no.getEsq(), vet, n);
			vet = CamPos(no.getDir(), vet, n);
			vet[n[0]] = no.getItem();
			n[0]++;
		}
		
	return vet;
	}
	
	/*
	public int ContarIdosos() {
		int idosos = 0;
		
		if (this.raiz == null) {
			return -1;
		}
		else {
			idosos = ContarIdosos(this.raiz, idosos);
		}
		
		return idosos;
	}
	private int ContarIdosos(NoPS no, int idosos) {
		if (no != null) {
			if (no.getItem().getIdade() >= 65) {
				idosos++;
			}
			
			idosos += ContarIdosos(no.getEsq(), idosos);
			idosos += ContarIdosos(no.getDir(), idosos);
		}
		
		return idosos;
	}
	*/
	
	/*
	public String[] ListaPresos() {
		String[] vetPS = new String[this.qtdNos];
		String aux = "";
		String aux2 = "";
		
		if (this.raiz == null) {
			return null;
		}
		else {
			aux = ListaPresos(this.raiz, aux2);
			vetPS = aux2.split(",");
			return vetPS;
		}
	}
	private String ListaPresos(NoPS no, String aux2) {
		if (no != null) {
			aux2 += no.getItem().getNome() + ",";
			
			aux2 += ListaPresos(no.getEsq(), aux2);
			aux2 += ListaPresos(no.getDir(), aux2);
		}
		
		return aux2;
	}
	*/
}
