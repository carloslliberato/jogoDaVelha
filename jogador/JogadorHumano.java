package jogador;

import jogo.Marca;
import jogo.Tabuleiro;
import java.io.*;

public class JogadorHumano implements Jogador
{
    private Marca          marca     = null;
    private Tabuleiro      tabDoJogo = null;
    private BufferedReader teclado   = new BufferedReader
                                        (new InputStreamReader
                                        (System.in));

    public JogadorHumano (Tabuleiro tab) throws Exception
    {
        if (tab == null)
            throw new Exception ("Tabuleiro invalido!");

        tabDoJogo = tab;

        // pede a marca ate que seja digitado X ou O
        while (marca == null)
        {
            System.out.print ("Escolha sua marca (X ou O): ");
            String resposta = teclado.readLine ();

            if (resposta == null)
                throw new Exception ("Entrada encerrada!");

            resposta = resposta.trim().toUpperCase();

            try
            {
                if (resposta.length() != 1)
                    throw new Exception ("Digite apenas um caractere!");

                marca = new Marca (resposta.charAt(0));
            }
            catch (Exception erro)
            {
                System.out.println ("Marca invalida! Digite X ou O.");
            }
        }
    }

    public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
    {
        if (tab == null)
            throw new Exception ("Tabuleiro invalido!");

        if (mrc == null)
            throw new Exception ("Marca invalida!");

        tabDoJogo = tab;
        marca     = mrc;

        System.out.println ("Sua marca e: " + marca);
    }

    public Marca getMarca ()
    {
        return marca;
    }

    public void facaSuaJogada ()
    {
        boolean jogou = false;

        System.out.println ();
        System.out.println (tabDoJogo);

        while (!jogou)
        {
            try
            {
                System.out.print ("Sua vez (" + marca + "). Digite a linha (1 a 3): ");
                int lin = Integer.parseInt (teclado.readLine().trim()) - 1;

                System.out.print ("Digite a coluna (1 a 3): ");
                int col = Integer.parseInt (teclado.readLine().trim()) - 1;

                if (tabDoJogo.haMarcaNaPosicao (lin, col))
                    System.out.println ("Essa posicao ja esta ocupada! Tente outra.");
                else
                {
                    tabDoJogo.setMarcaNaPosicao (marca, lin, col);
                    jogou = true;
                }
            }
            catch (Exception erro)
            {
                System.out.println ("Posicao invalida! Digite numeros de 1 a 3.");
            }
        }
    }

    public void vcGanhou ()
    {
        System.out.println ();
        System.out.println (tabDoJogo);
        System.out.println ("Parabens, voce ganhou!");
    }

    public void vcPerdeu ()
    {
        System.out.println ();
        System.out.println (tabDoJogo);
        System.out.println ("Que pena, voce perdeu!");
    }

    public void deuVelha ()
    {
        System.out.println ();
        System.out.println (tabDoJogo);
        System.out.println ("Deu velha! Ninguem ganhou.");
    }

    public boolean querMaisUmaPartida ()
    {
        for (;;)
        {
            System.out.print ("Deseja jogar mais uma partida (S/N)? ");

            String resposta;
            try
            {
                resposta = teclado.readLine ();
            }
            catch (IOException erro)
            {
                return false;
            }

            if (resposta == null)
                return false;

            resposta = resposta.trim().toUpperCase();

            if (resposta.equals ("S"))
                return true;

            if (resposta.equals ("N"))
                return false;

            System.out.println ("Resposta invalida! Digite S ou N.");
        }
    }
}
