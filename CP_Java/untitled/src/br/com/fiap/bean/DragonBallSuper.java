package br.com.fiap.bean;

import br.com.fiap.main.IDBSuper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Classe DragonBallSuper que implementa a interface IDBSuper.
 *
 * @autor Rafael Autieri dos Anjos
 * @RM RM550885
 */
public class DragonBallSuper implements IDBSuper {
    private String nomeDoPersonagem;
    private int ki;
    private int tecnicas;
    private int velocidade;
    private int transformacoes;

    // Construtor vazio
    public DragonBallSuper() {}

    // Getter para nomeDoPersonagem
    public String getNomeDoPersonagem() {
        return nomeDoPersonagem;
    }

    // Setter para nomeDoPersonagem
    public void setNomeDoPersonagem(String nomeDoPersonagem) {
        this.nomeDoPersonagem = nomeDoPersonagem;
    }

    // Getter para ki
    public int getKi() {
        return ki;
    }

    // Setter para ki
    public void setKi(int ki) {
        this.ki = ki;
    }

    // Getter para tecnicas
    public int getTecnicas() {
        return tecnicas;
    }

    // Setter para tecnicas
    public void setTecnicas(int tecnicas) {
        this.tecnicas = tecnicas;
    }

    // Getter para velocidade
    public int getVelocidade() {
        return velocidade;
    }

    // Setter para velocidade
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    // Getter para transformacoes
    public int getTransformacoes() {
        return transformacoes;
    }

    // Setter para transformacoes
    public void setTransformacoes(int transformacoes) {
        this.transformacoes = transformacoes;
    }

    /**
     * Método para ler o arquivo da pasta informada e retornar um objeto da classe DragonBallSuper.
     *
     * @param path Caminho do arquivo.
     * @throws IOException Se ocorrer um erro de leitura.
     */
    @Override
    public void ler(String path) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        String[] parts = content.split("\n");
        if (parts.length >= 5) {
            this.nomeDoPersonagem = parts[0].replace("Nome: ", "");
            this.ki = Integer.parseInt(parts[1].replace("Ki: ", ""));
            this.tecnicas = Integer.parseInt(parts[2].replace("Técnicas: ", ""));
            this.velocidade = Integer.parseInt(parts[3].replace("Velocidade: ", ""));
            this.transformacoes = Integer.parseInt(parts[4].replace("Transformações: ", ""));
        }
    }

    /**
     * Método para salvar o arquivo na pasta informada.
     *
     * @param path Caminho do arquivo.
     * @throws IOException Se ocorrer um erro de gravação.
     */
    @Override
    public void gravar(String path) throws IOException {
        String content = "Nome: " + nomeDoPersonagem + "\n" +
                "Ki: " + ki + "\n" +
                "Técnicas: " + tecnicas + "\n" +
                "Velocidade: " + velocidade + "\n" +
                "Transformações: " + transformacoes;
        Files.write(Paths.get(path), content.getBytes());
    }
}
