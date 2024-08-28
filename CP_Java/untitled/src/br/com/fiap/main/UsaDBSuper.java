package br.com.fiap.main;

import br.com.fiap.bean.DragonBallSuper;
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 * Classe UsaDBSuper para interagir com o usuário.
 *
 * O caminho da pasta depende da máquina, no da FIAP é C:\Users\labsfiap\Desktop\CP_Java\Pasta
 *
 * @autor Rafael Autieri dos Anjos
 * @RM RM550885
 */
public class UsaDBSuper {
    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            String[] options = {"Cadastrar", "Consultar"};
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma operação:", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            String path = JOptionPane.showInputDialog("Informe o caminho da pasta:");
            DragonBallSuper dbSuper = new DragonBallSuper();

            switch (escolha) {
                case 0: // Cadastrar
                    String nome = JOptionPane.showInputDialog("Informe o nome do personagem:");

                    int ki = Integer.parseInt(JOptionPane.showInputDialog("Informe o Ki do personagem:"));
                    int tecnicas = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de técnicas do personagem:"));
                    int velocidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a velocidade do personagem:"));
                    int transformacoes = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de transformações do personagem:"));

                    dbSuper.setNomeDoPersonagem(nome);
                    dbSuper.setKi(ki);
                    dbSuper.setTecnicas(tecnicas);
                    dbSuper.setVelocidade(velocidade);
                    dbSuper.setTransformacoes(transformacoes);

                    try {
                        dbSuper.gravar(path + "/" + nome + ".txt");
                        JOptionPane.showMessageDialog(null, "Personagem cadastrado com sucesso!");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao gravar o arquivo: " + e.getMessage());
                    }
                    break;

                case 1: // Consultar
                    String nomeConsulta = JOptionPane.showInputDialog("Informe o nome do personagem para consulta:");
                    try {
                        dbSuper.ler(path + "/" + nomeConsulta + ".txt");
                        JOptionPane.showMessageDialog(null, "Personagem consultado com sucesso!\n" +
                                "Nome: " + dbSuper.getNomeDoPersonagem() + "\n" +
                                "Ki: " + dbSuper.getKi() + "\n" +
                                "Técnicas: " + dbSuper.getTecnicas() + "\n" +
                                "Velocidade: " + dbSuper.getVelocidade() + "\n" +
                                "Transformações: " + dbSuper.getTransformacoes());
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage());
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Operação inválida!");
                    break;
            }

            int continuarOpcao = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Continuar",
                    JOptionPane.YES_NO_OPTION);
            if (continuarOpcao != JOptionPane.YES_OPTION) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Obrigado por usar o programa! Até logo!");
            }
        }
    }
}
