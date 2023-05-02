import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;

public class application {
    static HashMap<TiposPratos, HashSet<Pratos>> todos = new HashMap<>();
    public static void main(String[] args) {

        Object[] options = {"Sim", "Não"};
        HashSet<Pratos> massa = new HashSet<>();
        massa.add(new Pratos("lasanha"));
        massa.add(new Pratos("coxinha"));
        HashSet<Pratos> peixe = new HashSet<>();
        todos.put(new TiposPratos("massa"), massa);
        String nome;
        String nome2;
        int opcao;
        int opcao2;


        while (true) {
            boolean acerto = false;
            JOptionPane.showMessageDialog(null, "Pense em um prato que gosta");
            for (TiposPratos list : todos.keySet()) {
                opcao = JOptionPane.showOptionDialog(null, "O tipo de prato  que você pensou é " + list + " ?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                if (opcao == JOptionPane.YES_OPTION) {

                    HashSet<Pratos> conjunto = todos.get(list);

                    boolean achou = false;
                    for (Pratos pratos : conjunto) {
                        opcao2 = JOptionPane.showOptionDialog(null, "O Prato que você pensou é " + pratos, "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                        switch (opcao2) {
                            case JOptionPane.YES_OPTION: {
                                JOptionPane.showMessageDialog(null, "Seu Prato é " + pratos);
                                achou = true;
                                acerto = true;
                                break;
                            }
                            case JOptionPane.NO_OPTION: {
                                break;
                            }
                            case JOptionPane.CANCEL_OPTION: {
                                System.exit(0);
                            }
                        }
                        if (achou) {
                            break;
                        }
                    }
                }

            }
            if (!acerto) {
                nome = JOptionPane.showInputDialog(null, "Qual prato você pensou? ");
                nome2 = JOptionPane.showInputDialog(null, nome + " é _____ mas não é bolo de chocolate");
                addNovoPrato(nome, nome2);
            }
            }

        }
        public static void addNovoPrato (String nome, String nome2){
            if (todos.containsKey(nome2)) {
                HashSet<Pratos> conjunto = todos.get(nome2);
                todos.remove(nome2);
                conjunto.add(new Pratos(nome));
                todos.put(new TiposPratos(nome2), conjunto);
            } else {
                HashSet<Pratos> novoConjunto = new HashSet<>();
                novoConjunto.add(new Pratos(nome));
                todos.put(new TiposPratos(nome2), novoConjunto);
            }


        }
    }






