import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class application {

    public static void main(String[] args) {


        JOptionPane.showMessageDialog(null, "Pense em um prato que gosta");

        Object[] options = {"Sim", "Não"};
        HashMap<TiposPratos, HashSet<Pratos>> todos = new HashMap<>();
        HashSet<Pratos> massa = new HashSet<>();
        massa.add(new Pratos("lasanha"));
        massa.add(new Pratos("coxinha"));
        HashSet<Pratos> peixe = new HashSet<>();
        todos.put(new TiposPratos("massa"), massa);
        String nome;
        String nome2;


        while (true) {
            for (TiposPratos list : todos.keySet()) {
                int opcao = JOptionPane.showOptionDialog(null, "O tipo de prato  que você pensou é " + list + " ?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                if (opcao == JOptionPane.YES_OPTION) {

                    HashSet<Pratos> conjunto = todos.get(list);

                    for (Pratos pratos : conjunto) {
                        int opcao2 = JOptionPane.showOptionDialog(null, "O Prato que você pensou é " + pratos, "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                        if (opcao2 == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Seu Prato é " + pratos);
                            break;
                        }
                    }
                }
                if (opcao == JOptionPane.NO_OPTION) {
                } else {
                    System.exit(0);
                }
            }
            nome = JOptionPane.showInputDialog(null, "Qual prato você pensou? ");
            nome2 = JOptionPane.showInputDialog(null, nome + " é _____ mas não é bolo de chocolate");

            if (todos.containsKey(nome2)) {
                HashSet<Pratos> conjunto = todos.get(nome2);
                conjunto.add(new Pratos(nome));
            } else {
                HashSet<Pratos> novoConjunto = new HashSet<>();
                novoConjunto.add(new Pratos(nome));
                todos.put(new TiposPratos(nome2), novoConjunto);
            }

        }
    }
}






