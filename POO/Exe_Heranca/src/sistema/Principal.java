package sistema;

import heranca.SubClasse;
import heranca.SuperClasse;

public class Principal {

    public Principal(){
        SubClasse s1 = new SubClasse(10, 2, 8);

        System.out.println(s1.somar());
        System.out.println(s1.dividir());

        SuperClasse super1 = new SuperClasse(10, 2);
        System.out.println(super1.dividir());

        
    }
    public static void main(String[] args) throws Exception {
        new Principal();
    }
}
