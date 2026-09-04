import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GerenciarFesta {

	private Scanner s;
	private List<Cliente> clientes;
	private List<Tema> temas;
	private List<Aluguel> alugueis;
	private List<Item> itens;

	public GerenciarFesta() {
		clientes = new ArrayList<Cliente>();
		temas = new ArrayList<Tema>();
		itens = new ArrayList<Item>();
		alugueis = new ArrayList<Aluguel>();

		String menuTexto = "1 - Inserir cliente\n"
				+ "2 - Inserir tema\n"
				+ "3 - Inserir aluguel\n"
				+ "4 - Inserir item\n"
				+ "5 - Listar clientes\n"
				+ "6 - Listar temas\n"
				+ "7 - Listar alugueis\n"
				+ "8 - Listar item"
				+ "0 - Sair";

		int opcao = 0;

		do {
			String op = JOptionPane.showInputDialog("\nEscola uma opção: \n" + menuTexto + "\nDigite: ");
			opcao = Integer.parseInt(op);

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
		if (itens == null) {
			JOptionPane.showMessageDialog(null, "Nenhum item cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String dados = "--- LISTANDO ITENS ---";
		int i = 0;
		for(Item item: itens){
			dados += "\nItem " + (i + 1) + "\nNome: " + item.getNome() + "\nQuantidade: " + item.getQtd() + "\n";
			i++;
		}
		JOptionPane.showMessageDialog(null, dados);

	}

	private void inserirItem() {
		String nome = JOptionPane.showInputDialog("Nome do item: ");
		String qtd = JOptionPane.showInputDialog("Quantidade: ");
		int qtd_aux = Integer.parseInt(qtd);

		Item i1 = new Item();
		i1.setNome(nome);
		i1.setQtd(qtd_aux);

		itens.add(i1);

	}

	private void listarAluguel() {
		if (alugueis == null) {
			JOptionPane.showMessageDialog(null, "Nenhum aluguel cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}

		System.out.println("---LISTANDO ALUGUEIS---");
		for (int i = 0; i < alugueis.size(); i++) {
			System.out.println("Aluguel " + (i + 1));
			System.out.println("Data: " + alugueis.get(i).getData());
			System.out.println("Hora de inicio da festa: " + alugueis.get(i).getHora_inicio());
			System.out.println("Hora de termino da festa: " + alugueis.get(i).getHora_termino());
			System.out.println("Tema: " + alugueis.get(i).getTemas());
			System.out.println("Cliente: " + alugueis.get(i).getCliente());
			System.out.println("Endereço: " + alugueis.get(i).getEndereco());
		}

	}

	private void listarTema() {
		if (temas == null) {
			JOptionPane.showMessageDialog(null, "Nenhum tema cadastrado!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		System.out.println("---LISTANDO TEMAS---");
		for (int i = 0; i < temas.size(); i++) {
			System.out.println("Tema " + (i + 1));
			System.out.println("Nome: " + temas.get(i).getNome() + "\nCor da toalha: " + temas.get(i).getToalha() +
					"\nValor do aluguel: " + temas.get(i).getValor_aluguel() + "\nItens: " + temas.get(i).getItens());
		}

	}

	private void listarCliente() {
		if (clientes == null) {
			JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String dadosClientes = "--- LISTANDO CLIENTES ---";
		int c = 0;
		for(Cliente cliente: clientes){
			dadosClientes += "\nCliente " + (c + 1) + "\nNome: " + cliente.getNome() + "\nTelefone: " + cliente.getTelefone() + "\nData do cadastro: " + cliente.getDataPrimeira() + "\n";
			c++;
		}
		JOptionPane.showMessageDialog(null, dadosClientes);

	}

	private void inserirAluguel() {
		s = new Scanner(System.in);

		if (clientes == null) {
			JOptionPane.showMessageDialog(null, "Cliente deve ser cadastrado primeiro!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (temas == null) {
			JOptionPane.showMessageDialog(null, "Nenhum tema cadastrado!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}

		String hora_inicio = JOptionPane.showInputDialog("Informe de a hora de inicio da festa: ");
		int hora_i = Integer.parseInt(hora_inicio);
		System.out.println("Informe de a hora de inicio da festa: ");
		String hora_termino = JOptionPane.showInputDialog("Informe de a hora de inicio da festa: ");
		int hora_t = Integer.parseInt(hora_termino);

		System.out.println("Temas: ");
		for (int i = 0; i < temas.size(); i++) {
			System.out.println("[" + i + "]" + temas.get(i).getNome());
		}
		String nomeTema = JOptionPane.showInputDialog("Informe o número do tema: ");
		int id_nomeTema = Integer.parseInt(nomeTema);

		System.out.println("Clientes: ");
		for (int j = 0; j < clientes.size(); j++) {
			System.out.println("[" + j + "]" + clientes.get(j).getNome());
		}
		String nomeCliente = JOptionPane.showInputDialog("Informe o número do cliente: ");
		int id_nomeCliente = Integer.parseInt(nomeCliente);

		String endereco = JOptionPane.showInputDialog("Informe o endereço: ");

		Aluguel a1 = new Aluguel();
		a1.setData(new Date());
		a1.setHora_inicio(hora_i);
		a1.setHora_termino(hora_t);
		a1.setTemas(temas);
		a1.setCliente(clientes);
		a1.setEndereco(endereco);

		alugueis.add(a1);

	}

	private void inserirTema() {
		s = new Scanner(System.in);
		int id_nrItem;
		List<Item> itensSelecionados = new ArrayList<Item>();
		int qtdItens_inteiro = 0;

		if (itens == null) {
			JOptionPane.showMessageDialog(null, "Item deve ser cadastrado primeiro!", "ERRO",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		String nome = JOptionPane.showInputDialog("Nome do tema: ");
		String cor = JOptionPane.showInputDialog("Cor da toalha: ");
		String valor = JOptionPane.showInputDialog("Valor do Aluguel: ");
		float valor_aluguel = Float.parseFloat(valor);

		System.out.println("Itens disponíveis: ");
		for (int i = 0; i < itens.size(); i++) {
			System.out.println("[" + i + "]" + itens.get(i).getNome());
		}

		int op;
		do {
			String nrItem = JOptionPane.showInputDialog("Digite o número do item escolhido: ");
			id_nrItem = Integer.parseInt(nrItem);

			Item itemEncontrado = itens.get(id_nrItem); //Pega o item escolhido e 
			itensSelecionados.add(itemEncontrado); //Adiciona na LISTA List<Item> itensSelecionados

			String qtdItens = JOptionPane.showInputDialog("Informe a quantidade do item: ");
			qtdItens_inteiro = Integer.parseInt(qtdItens);

			op = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais algum item?", "Confirmação",
					JOptionPane.YES_NO_OPTION);

		} while (op == JOptionPane.YES_OPTION);

		JOptionPane.showMessageDialog(null, "Tema cadastrado com SUCESSO!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		Tema t1 = new Tema();
		t1.setNome(nome);
		t1.setToalha(cor);
		t1.setValor_aluguel(valor_aluguel);
		t1.setItens(itensSelecionados);
		

		temas.add(t1);

	}

	private void inserirCliente() {
		String nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
		String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente: ");

		Cliente c1 = new Cliente();
		c1.setNome(nome);
		c1.setTelefone(telefone);
		c1.setDataPrimeira(new Date()); // pega a data de hoje - data do cadastro

		JOptionPane.showMessageDialog(null, "Cliente cadastrado!!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		clientes.add(c1);

	}

	public static void main(String[] args) {
		new GerenciarFesta();
	}

}
