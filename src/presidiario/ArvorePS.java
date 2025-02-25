package presidiario;

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
		if (pesquisar(item.getCodigo()) != null) {
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
	
	public NoPS pesquisar(int codigo) {
		NoPS resultado = pesquisar(codigo, this.raiz);
		
		if (resultado != null) {
			return resultado;
		}
		else {
			return null;
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
	
	public int[] ContarIdosos() {
		int[] n = new int[1];
		n[0] = 0;
		
		if (this.raiz == null) {
			n[0] = -1;
			return n;
		}
		else {
			return (ContarIdosos(this.raiz, n));
		}
	}
	private int[] ContarIdosos(NoPS no, int[] n) {
		if (no != null) {
			if (no.getItem().getIdade() > 64) {
				n[0]++;
			}
			
			n = ContarIdosos(no.getEsq(), n);
			n = ContarIdosos(no.getDir(), n);
		}
		
		return n;
	}
	
	public String[] ListaPresos() {
		int[] n = new int[1];
		n[0] = 0;
		
		String[] vetPS = new String[this.qtdNos];
		
		if (this.raiz == null) {
			return null;
		}
		else {
			return (ListaPresos(this.raiz, vetPS, n));
		}
	}
	private String[] ListaPresos(NoPS no, String[] vetPS, int[] n) {
		if (no != null) {
			vetPS[n[0]] = no.toString();
			n[0]++;
			
			vetPS = ListaPresos(no.getEsq(), vetPS, n);
			vetPS = ListaPresos(no.getDir(), vetPS, n);
		}
		
		return vetPS;
	}
}
