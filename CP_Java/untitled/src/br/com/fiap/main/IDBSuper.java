package br.com.fiap.main;

import java.io.IOException;

/**
 * Interface para a classe DragonBallSuper.
 */
public interface IDBSuper {
    void ler(String path) throws IOException;
    void gravar(String path) throws IOException;
}
