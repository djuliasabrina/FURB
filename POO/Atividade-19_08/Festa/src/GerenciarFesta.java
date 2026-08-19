import java.util.Date;
import java.util.Scanner;



public class GerenciarFesta {
	
	private Scanner s;
	private Cliente[] clientes;
	private Tema[] temas;
	private Aluguel[] alugueis;
	private Item[] itens;
	private int qtdAtualCliente;
	private int qtdAtualTema;
	private int qtdAtualAluguel;
	private int qtdAtualItem;
	
	public GerenciarFesta() {
		s = new Scanner(System.in);
		clientes = new Cliente[20];
		temas = new Tema[20];
		alugueis = new Aluguel[30];
		
		String menuTexto = "1 - Inserir cliente\n"
				+ "2 - Inserir tema\n"
				+ "3 - Inserir aluguel\n"
				+ "4 - Inserir item\n"
				+ "5 - Listar clientes\n"
				+ "6 - Listar temas\n"
				+ "7 - Listar alugueis\n"
				+ "8 - Listar item";
		
		int opcao = 0;
		
		do {
			System.out.println("\nEscola uma opção: \n" + menuTexto + "\nDigite: ");
			opcao = s.nextInt();
			
			switch(opcao) {
			
			case 1:
				inserirCliente();
				break;
			
			case 2:
				inserirTema();
				break;
				
			case 3:
				inserirAluguel();
				break;
				
			case 4:
				inserirItem();
				break;
				
			case 5:
				listarCliente();
				break;
				
			case 6:
				listarTema();
				break;
				
			case 7:
				listarAluguel();
				break;
				
			case 8:
				listarItem();
				break;
				
			case 0:
				break;
				
			default: 
				System.out.println("Opção Inválida...");
			}
			
		}while (opcao != 0);
		
		}
	


	private void listarItem() {
		for(int i = 0; i < qtdAtualItem; i++) {
			System.out.println();
			System.out.println("Item " + (i + 1));
			System.out.println("Nome: " + itens[i].getNome() + "\nQuantidade: " + itens[i].getQtd());
		}
		
	}



	private void inserirItem() {
		System.out.println("Nome do item: ");
		String nome = s.next();
		System.out.println("Quantidade: ");
		int qtd = s.nextInt();
		
		Item i1 = new Item();
		i1.setNome(nome);
		i1.setQtd(qtd);
	
		itens[qtdAtualItem] = i1;
		qtdAtualItem++;
		
	}



	private void listarAluguel() {
		// TODO Auto-generated method stub
		
	}



	private void listarTema() {
		// TODO Auto-generated method stub
		
	}



	private void listarCliente() {
		for(int i = 0; i < qtdAtualCliente; i++) {
			System.out.println();
			System.out.println("Cliente " + (i + 1));
			System.out.println("Nome: " + clientes[i].getNome() + "\nTelefone: " + 
		     clientes[i].getTelefone() + "\nData do cadastro: " + clientes[i].getDataPrimeira());
		}
		
	}



	private void inserirAluguel() {
		s = new Scanner(System.in);
		//private Date data;
		//private int hora_inicio;
		//private int hora_termino;
		//private Tema tema;
		//private Cliente cliente;
		//private String endereco;
		
		System.out.println("Informe de a hora de inicio da festa: ");
		int hora_inicio = s.nextInt();
		System.out.println("Informe de a hora de inicio da festa: ");
		int hora_termino = s.nextInt();
		System.out.print("Informe o tema: ");
		String tema = s.next();
	
		
		
		
		
		
		
	}



	private void inserirTema() {
		s = new Scanner(System.in);
		//private Item[] itens;
		//private float valor_aluguel;
		//private TOALHA toalha;
		//private String nome;
		
		System.out.println("");
		
	}



	private void inserirCliente() {
		s = new Scanner(System.in);
		System.out.print("Digite o nome do cliente: ");
		String nome = s.next();
		System.out.print("Digite o telefone do cliente: ");
		String telefone = s.next();
		
		Cliente c1 = new Cliente();
		c1.setNome(nome);
		c1.setTelefone(telefone);
		c1.setDataPrimeira(new Date()); // pega a data de hoje - data do cadastro
		
		clientes[qtdAtualCliente] = c1;
		qtdAtualCliente++;
		
	}



	public static void main(String[] args) {
		new GerenciarFesta();
	}

}
