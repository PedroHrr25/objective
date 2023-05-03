import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;

public class application {
    static HashMap<String, HashSet<String>> todos = new HashMap<>();

    public static void main(String[] args) {

        Object[] options = {"Sim", "Não"};

        HashSet<String> massa = new HashSet<>();
        massa.add("lasanha");
        massa.add("coxinha");

        todos.put("massa", massa);


        while (true) {
            boolean acerto = false;
            boolean reprise = false;
            JOptionPane.showMessageDialog(null, "Pense em um prato que gosta");
            for (String list : todos.keySet()) {
              int  opcao = JOptionPane.showOptionDialog(null, "O tipo de prato  que você pensou é " + list + " ?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                if (opcao == JOptionPane.YES_OPTION) {

                    HashSet<String> conjunto = todos.get(list);

                    boolean achou = false;
                    for (String pratos : conjunto) {
                      int  opcao2 = JOptionPane.showOptionDialog(null, "O Prato que você pensou é " + pratos, "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                        switch (opcao2) {
                            case JOptionPane.YES_OPTION: {
                                JOptionPane.showMessageDialog(null, "Seu Prato é " + pratos);
                                achou = true;
                                acerto = true;
                                reprise = true;
                                break;
                            }
                            case JOptionPane.NO_OPTION: {
                                break;
                            }
                            default: {
                                System.exit(0);
                            }
                        }
                        if (achou) {
                            break;
                        }
                        reprise = true;
                    }
                }
                if (reprise) {
                    break;
                }
                if(opcao == JOptionPane.CLOSED_OPTION){
                    System.exit(0);
                }
            }
            if (!acerto) {
             String   nome = JOptionPane.showInputDialog(null, "Qual prato você pensou? ");
            String    nome2 = JOptionPane.showInputDialog(null, "de qual familia " + nome + " pertence");
                addNovoPrato(nome, nome2);
            }
        }

    }

    public static void addNovoPrato(String nome, String nome2) {
        if (!(nome == null || nome2 == null)) {
            todos.computeIfPresent(nome2, (key, value) -> {
                value.add(nome);
                return value;
            });
            todos.computeIfAbsent(nome2, key -> {
                HashSet<String> conjunto = new HashSet<>();
                conjunto.add(nome);
                return conjunto;

            });
        }
    }

}







