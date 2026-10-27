package jogo;

public class AnalistaSituacional
{
    private Tabuleiro tabDoJogo;

    public AnalistaSituacional (Tabuleiro tab) throws Exception
    {
        tabDoJogo = tab;
        // colocar tab em tabDoJogo
    }

    public Marca getMarcaDoVencedor ()
    {
        // descobrir se ha um vencedor e retornar
        // a marca dele; retornara null, quando
        // nao houver vencedor
        try
        {
        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.haMarcaNaPosicao(0,2)){
            if (this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.tabDoJogo.getMarcaNaPosicao(0,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.tabDoJogo.getMarcaNaPosicao(0,2))){
                    return this.tabDoJogo.getMarcaNaPosicao(0,0);
                }
        }

        if (this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.haMarcaNaPosicao(1,2)){
            if (this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.tabDoJogo.getMarcaNaPosicao(1,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.tabDoJogo.getMarcaNaPosicao(1,2))){
                    return this.tabDoJogo.getMarcaNaPosicao(1,0);
                }
        }

        if (this.tabDoJogo.haMarcaNaPosicao(2,0) && this.tabDoJogo.haMarcaNaPosicao(2,1) && this.tabDoJogo.haMarcaNaPosicao(2,2)){
            if (this.tabDoJogo.getMarcaNaPosicao(2,0).equals(this.tabDoJogo.getMarcaNaPosicao(2,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(2,1).equals(this.tabDoJogo.getMarcaNaPosicao(2,2))){
                    return this.tabDoJogo.getMarcaNaPosicao(2,0);
                }
        }

        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.haMarcaNaPosicao(1,0) && this.tabDoJogo.haMarcaNaPosicao(2,0)){
            if (this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.tabDoJogo.getMarcaNaPosicao(1,0)) &&
                this.tabDoJogo.getMarcaNaPosicao(1,0).equals(this.tabDoJogo.getMarcaNaPosicao(2,0))){
                    return this.tabDoJogo.getMarcaNaPosicao(0,0);
                }
        }

        if (this.tabDoJogo.haMarcaNaPosicao(0,1) && this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.haMarcaNaPosicao(2,1)){
            if (this.tabDoJogo.getMarcaNaPosicao(0,1).equals(this.tabDoJogo.getMarcaNaPosicao(1,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.tabDoJogo.getMarcaNaPosicao(2,1))){
                    return this.tabDoJogo.getMarcaNaPosicao(0,1);
                }
        }

        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.haMarcaNaPosicao(1,2) && this.tabDoJogo.haMarcaNaPosicao(2,2)){
            if (this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.tabDoJogo.getMarcaNaPosicao(1,2)) &&
                this.tabDoJogo.getMarcaNaPosicao(1,2).equals(this.tabDoJogo.getMarcaNaPosicao(2,2))){
                    return this.tabDoJogo.getMarcaNaPosicao(0,2);
                }
        }

        if (this.tabDoJogo.haMarcaNaPosicao(0,0) && this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.haMarcaNaPosicao(2,2)){
            if (this.tabDoJogo.getMarcaNaPosicao(0,0).equals(this.tabDoJogo.getMarcaNaPosicao(1,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.tabDoJogo.getMarcaNaPosicao(2,2))){
                    return this.tabDoJogo.getMarcaNaPosicao(0,0);
                }
        }

        if (this.tabDoJogo.haMarcaNaPosicao(0,2) && this.tabDoJogo.haMarcaNaPosicao(1,1) && this.tabDoJogo.haMarcaNaPosicao(2,0)){
            if (this.tabDoJogo.getMarcaNaPosicao(0,2).equals(this.tabDoJogo.getMarcaNaPosicao(1,1)) &&
                this.tabDoJogo.getMarcaNaPosicao(1,1).equals(this.tabDoJogo.getMarcaNaPosicao(2,0))){
                    return this.tabDoJogo.getMarcaNaPosicao(0,2);
                }
        }
    }
    catch (Exception erro)
    {
        throw new RuntimeException(erro);
    }

    return null;

    }

    private boolean tabuleiroCheio ()
    {
        // verificar se todas as posicoes do
        // tabuleiro estao preenchidas (!=null)
        // retornando true em caso afirmativo,
        // ou false em caso negativo
        try
        {
        if (!this.tabDoJogo.haMarcaNaPosicao(0,0)) return false;
        if (!this.tabDoJogo.haMarcaNaPosicao(0,1)) return false;
        if (!this.tabDoJogo.haMarcaNaPosicao(0,2)) return false;
        if (!this.tabDoJogo.haMarcaNaPosicao(1,0)) return false;
        if (!this.tabDoJogo.haMarcaNaPosicao(1,1)) return false;
        if (!this.tabDoJogo.haMarcaNaPosicao(1,2)) return false;
        if (!this.tabDoJogo.haMarcaNaPosicao(2,0)) return false;
        if (!this.tabDoJogo.haMarcaNaPosicao(2,1)) return false;
        if (!this.tabDoJogo.haMarcaNaPosicao(2,2)) return false;
        }
        catch (Exception erro)
        {
            throw new RuntimeException(erro);
        }
        return true;
    }

    public boolean fimDeJogo ()
    {
        // se getMarcaDoVencedor != null,
        // retorna true
        // se tabuleiroCheio == true,
        // retorna true
        // caso contrario, retorna false
        if (getMarcaDoVencedor() != null) return true;
        if (tabuleiroCheio()) return true;
        return false;
    }

    @Override
    public String toString ()
    {
        // faça
        Marca vencedor = getMarcaDoVencedor();
        if (vencedor != null){
            return "O jogador " + vencedor + " venceu!!";
        }
        
        if (tabuleiroCheio()){
            return "Resultado: Empate.";
        }

        else{
            return "Jogo em andamento...";
        }
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario
        if (!(obj instanceof AnalistaSituacional)) return false;
        AnalistaSituacional outrAnalistaSituacional = (AnalistaSituacional) obj;
        return this.tabDoJogo.equals(outrAnalistaSituacional.tabDoJogo);
    }

    @Override
    public int hashCode ()
    {
        // faça
        return tabDoJogo.hashCode();
    }
}