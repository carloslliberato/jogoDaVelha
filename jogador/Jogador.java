package jogador;

import jogo.Marca;
import jogo.Tabuleiro;

public interface Jogador
{
    // retorna a marca do jogador
    public Marca getMarca ();

    // realiza uma jogada no tabuleiro
    public void facaSuaJogada ();
}
