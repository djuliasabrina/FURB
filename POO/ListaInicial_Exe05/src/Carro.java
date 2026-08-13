
public class Carro {

	private Modelo modelo;
	private COR cor;
	private int anoPublicacao;
	private float km;
	private boolean estaLigado;
	
	//Getters
	public Modelo getModelo() {
		return modelo;
	}
	
	public COR getCor() {
		return cor;
	}
	
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public float getKm() {
		return km;
	}
	
	public boolean getEstaLigado() {
		return estaLigado;
	}
	
	//Setters
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public void setCor(COR cor) {
		this.cor = cor;
	}
	
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public void setKm(float km) {
		this.km = km;
	}
	
	public void setEstaLigado(boolean estaLigado) {
		this.estaLigado = estaLigado;
	}
}
