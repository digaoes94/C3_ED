package presidio;

public class ItemPR {
	private int codigo;
	private String nome, cidade;
	private NivelSEG nivel;
	
	public ItemPR(int codigo, String nome, String cidade, NivelSEG nivel) {
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
		this.nivel = nivel;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public NivelSEG getNivel() {
		return nivel;
	}
	public void setNivel(NivelSEG nivel) {
		this.nivel = nivel;
	}
}