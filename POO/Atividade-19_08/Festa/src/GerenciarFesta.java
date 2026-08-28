import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
	private int qtdAtualToalhas;

	public GerenciarFesta() {
		s = new Scanner(System.in);
		clientes = new Cliente[20];
		temas = new Tema[20];
		alugueis = new Aluguel[30];
		itens = new Item[30];

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

			switch (opcao) {

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

		} while (opcao != 0);

	}

	private void listarItem() {
		if (qtdAtualItem == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum item cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}
		for (int i = 0; i < qtdAtualItem; i++) {
			System.out.println();
			System.out.println("Item " + (i + 1));
			System.out.println("Nome: " + itens[i].getNome() + "\nQuantidade: " + itens[i].getQtd());
		}

	}

	private void inserirItem() {
		String nome = JOptionPane.showInputDialog("Nome do item: ");
		String qtd = JOptionPane.showInputDialog("Quantidade: ");
		int qtd_aux = Integer.parseInt(qtd);

		Item i1 = new Item();
		i1.setNome(nome);
		i1.setQtd(qtd_aux);

		itens[qtdAtualItem] = i1;
		qtdAtualItem++;

	}

	private void listarAluguel() {
		if (qtdAtualAluguel == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum aluguel cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}

		System.out.println("---LISTANDO ALUGUEIS---");
		for(int i = 0; i < qtdAtualAluguel; i++){
			System.out.println("Aluguel " + (i + 1));
			System.out.println("Data: " + alugueis[i].getData());
			System.out.println("Hora de inicio da festa: " + alugueis[i].getHora_inicio());
			System.out.println("Hora de termino da festa: " + alugueis[i].getHora_termino());
			System.out.println("Tema: " + alugueis[i].getTemas().getNome());
			System.out.println("Cliente: " + alugueis[i].getCliente().getNome());
			System.out.println("Endereço: " + alugueis[i].getEndereco());
		}

	}

	private void listarTema() {
		if (qtdAtualTema == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum tema cadastrado!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		System.out.println("---LISTANDO TEMAS---");
		for (int i = 0; i < qtdAtualTema; i++) {
			System.out.println("Tema " + (i + 1));
			System.out.println("Nome: " + temas[i].getNome() + "\nCor da toalha: " + temas[i].getToalha() +
					"\nValor do aluguel: " + temas[i].getValor_aluguel() + "\nItens: " + temas[i].getItens());
		}

	}

	private void listarCliente() {
		if (qtdAtualCliente == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}

		System.out.println("---LISTANDO CLIENTES---");
		for (int i = 0; i < qtdAtualCliente; i++) {
			System.out.println();
			System.out.println("Cliente " + (i + 1));
			System.out.println("Nome: " + clientes[i].getNome() + "\nTelefone: " +
					clientes[i].getTelefone() + "\nData do cadastro: " + clientes[i].getDataPrimeira());
		}

	}

	private void inserirAluguel() {
		s = new Scanner(System.in);
		// private Date data;
		// private int hora_inicio;
		// private int hora_termino;
		// private String tema;
		// private Cliente cliente;
		// private String endereco;

		if (qtdAtualCliente == 0) {
			JOptionPane.showMessageDialog(null, "Cliente deve ser cadastrado primeiro!", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (qtdAtualTema == 0) {
			JOptionPane.showMessageDialog(null, "Nenhum tema cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}

		String hora_inicio = JOptionPane.showInputDialog("Informe de a hora de inicio da festa: ");
		int hora_i = Integer.parseInt(hora_inicio);
		System.out.println("Informe de a hora de inicio da festa: ");
		String hora_termino = JOptionPane.showInputDialog("Informe de a hora de inicio da festa: ");
		int hora_t = Integer.parseInt(hora_termino);

		System.out.println("Temas: ");
		for(int i = 0; i < qtdAtualTema; i++){
			System.out.println("[" + i + "]" + temas[i].getNome());
		}
		String nomeTema = JOptionPane.showInputDialog("Informe o número do tema: ");
		int id_nomeTema = Integer.parseInt(nomeTema);

		System.out.println("Clientes: ");
		for(int j = 0; j < qtdAtualCliente; j++){
			System.out.println("[" + j + "]" + clientes[j].getNome());
		}
		String nomeCliente = JOptionPane.showInputDialog("Informe o número do cliente: ");
		int id_nomeCliente = Integer.parseInt(nomeCliente);

		String endereco = JOptionPane.showInputDialog("Informe o endereço: ");

		Aluguel a1 = new Aluguel();
		a1.setData(new Date());
		a1.setHora_inicio(hora_i);
		a1.setHora_termino(hora_t);
		a1.setTemas(temas[id_nomeTema]);
		a1.setCliente(clientes[id_nomeCliente]);
		a1.setEndereco(endereco);


		alugueis[qtdAtualAluguel] = a1;
		qtdAtualAluguel++;

	}

	private void inserirTema() {
		s = new Scanner(System.in);
		int id_nomeItem;

		if (qtdAtualItem == 0) {
			JOptionPane.showMessageDialog(null, "Item deve ser cadastrado primeiro!", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String nome = JOptionPane.showInputDialog("Nome do tema: ");
		String cor = JOptionPane.showInputDialog("Cor da toalha: ");
		String valor = JOptionPane.showInputDialog("Valor do Aluguel: ");
		float valor_aluguel = Float.parseFloat(valor);

		System.out.println("Itens disponíveis: ");
		for (int i = 0; i < qtdAtualItem; i++) {
			System.out.println("["+ i + "]" + itens[i].getNome());
		}

		int op;
		do {
			String nomeItem = JOptionPane.showInputDialog("Digite o número do item escolhido: ");
			id_nomeItem = Integer.parseInt(nomeItem);

			op = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais algum item?", "Confirmação",
					JOptionPane.YES_NO_OPTION);

		} while (op == JOptionPane.YES_OPTION);

		JOptionPane.showMessageDialog(null, "Tema cadastrado com SUCESSO!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		Tema t1 = new Tema();
		t1.setNome(nome);
		t1.setToalha(cor);
		t1.setValor_aluguel(valor_aluguel);
		t1.setItens(itens);

		temas[qtdAtualTema] = t1;
		qtdAtualTema++;

	}

	private void inserirCliente() {
		String nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
		String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente: ");

		Cliente c1 = new Cliente();
		c1.setNome(nome);
		c1.setTelefone(telefone);
		c1.setDataPrimeira(new Date()); // pega a data de hoje - data do cadastro

		JOptionPane.showMessageDialog(null, "Cliente cadastrado!!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		clientes[qtdAtualCliente] = c1;
		qtdAtualCliente++;

	}

	public static void main(String[] args) {
		new GerenciarFesta();
	}

}
