package com.heranca;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("Minha Empresa");

        Vendedor f1 = new Vendedor("Luiz", 1000, 10);
        Venda um = new Venda(200);
        Venda dois = new Venda(100);
        f1.incluirVenda(um);
        f1.incluirVenda(dois);

        empresa.incluirFuncionario(f1);

        Vendedor f2 = new Vendedor("Paula", 1200, 7);
        f2.incluirVenda(new Venda(500));
        f2.incluirVenda(new Venda(350));
        f2.incluirVenda(new Venda(280));

        empresa.incluirFuncionario(f2);

        Programador julio = new Programador("Julio", 1000);
        julio.incluirLinguagem("C");
        julio.incluirLinguagem("Java");

        empresa.incluirFuncionario(julio);

        Programador ana = new Programador("Ana", 1000);
        ana.incluirLinguagem("Java");
        ana.incluirLinguagem("C#");

        empresa.incluirFuncionario(ana);

        Programador anderson = new Programador("Anderson", 1200);
        anderson.incluirLinguagem("Phyton");

        empresa.incluirFuncionario(anderson);

        System.out.println("Custo total que a empresa terá com os salários de todos os tipos de funcionários: ");
        System.out.println(empresa.calcularCustosSalarios());

        System.out.println("Funcionários: ");
        for(Funcionario f : empresa.getFuncionarios()){
            System.out.println("Nome: " + f.getNome() + "\nSalário" + f.calcularSalario());
        }

        System.out.println("Vendedores e Percentual de Comissão");
        for(Funcionario f : empresa.getFuncionarios()){
            if (f instanceof Vendedor v) {
                System.out.println("Nome: " + v.getNome() + "\nPercentual: " + v.getPercentualComissao());
            }
        }

        System.out.println("Programadores e linguagens que conhecem: ");
        for(Funcionario f : empresa.getFuncionarios()){
            if (f instanceof Programador p) {
                System.out.println("Nome: " + p.getNome() + "\nLinguagens: " + p.getLinguagens());
            }
        }
    }
}