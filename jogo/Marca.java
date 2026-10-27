package jogo;


public class Marca
{
    private char simbolo;

    public Marca (char smb) throws Exception
    {
        // validar smb, garantindo que ele
        // seja 'X' ou 'O' e coloca-lo em
        // simbolo
        // dar excecao em caso de valor invalido
        if (smb != 'O' & smb != 'X') throw new Exception("O simbolo digitado não é válido!");
        simbolo = smb;
    }

    public char getSimbolo ()
    {
        // retornar simbolo
        return simbolo;
    }

    @Override
    public String toString ()
    {
        return ""+simbolo;
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario
        if (!(obj instanceof Marca)) return false;

        Marca outraMarca = (Marca) obj;
        return this.simbolo == outraMarca.getSimbolo();
    }

    @Override
    public int hashCode ()
    {
        // faça
        return simbolo;
    }
}