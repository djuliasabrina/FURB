
public class Sistema {
	
	public Sistema() {
		Carro c1 = new Carro();
		Modelo modelo = new Modelo();
		
		modelo.setNome("BYD");
		c1.setCor(COR.AMARELO);
		c1.setAnoPublicacao(2025);
		c1.setKm(1555);
		c1.setEstaLigado(true);
		
		
		System.out.println("Nome: " + modelo.getNome() + 
				"\nCor: " + c1.getCor() + 
				"\nAno publicação: " + c1.getAnoPublicacao() + 
				"\nQuilometragem: " + c1.getKm() + 
				"\nEsta ligado? " + c1.getEstaLigado());
		
		
		
	}
	
	public static void main(String[] args) {
		new Sistema();
	}

}
