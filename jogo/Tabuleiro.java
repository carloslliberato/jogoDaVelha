package jogo;

public class Tabuleiro implements Cloneable {
    // a principio, toda igual a null
    private Marca matriz[][] = new Marca[3][3];

    public boolean haMarcaNaPosicao(int lin, int col) throws Exception {
        // Verifica se a linha ou coluna são inválidas (fora dos limites da matriz)
        if (lin < 0 || lin >= matriz.length || col < 0 || col >= matriz[0].length) {
            throw new Exception("Linha ou coluna inválida.");
        }

        // Se for null, matriz[lin][col] != null resulta em false.
        // Se não for null, resulta em true.
        return matriz[lin][col] != null;
    }

    public Marca getMarcaNaPosicao(int lin, int col) throws Exception {
        if (lin < 0 || lin >= matriz.length || col < 0 || col >= matriz[0].length) {
            throw new Exception("Linha ou coluna inválida.");
        }

        return matriz[lin][col];
        // retornar a marca que tem em
        // matriz[lin][col]
        // dar excecao caso lin ou col invalido
    }

    public void setMarcaNaPosicao(Marca mrc, int lin, int col) throws Exception {
        if (lin < 0 || lin >= matriz.length || col < 0 || col >= matriz[0].length) {
            throw new Exception("Linha ou coluna inválida.");
        }

        if (mrc == null) {
            throw new Exception("Nova Marca não pode ser inválida.");
        }

        matriz[lin][col] = mrc;

        // colocar mrc em matriz[lin][col],
        // dar excecao caso lin ou col invalido
        // dar excecao caso mrc seja null
    }

    @Override
    public String toString() {

        String retorno = "";
        String linha = "";
        for (int lin = 0; lin < matriz.length; lin++) {
            for (int col = 0; col < matriz[lin].length; col++) {
                if (matriz[lin][col] == null) {
                    linha += "[ ]";
                } else {
                    linha += String.format("[%c]", matriz[lin][col].getSimbolo());
                }
            }
            if (retorno.isEmpty()) {
                retorno = linha;
            } else {
                retorno = String.format("%s%n%s", retorno, linha);
            }
            linha = "";
        }

        return retorno;
        // retornar em um String o tabuleiro
        // formatado para ser exibido na tela
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() != this.getClass())
            return false;
        Tabuleiro other = (Tabuleiro) obj;
        if (!other.matriz.equals(this.matriz))
            return false;
        return true;
        // retornar true se this for igual a obj ou false caso contrario
    }

    @Override
    public int hashCode() {
        int ret = 1;
        ret += ret * 13 + matriz.hashCode();
        if (ret < 0)
            ret = -ret;
        return ret;
        // faça
    }

    public Tabuleiro(Tabuleiro modelo) throws Exception {
        if (modelo == null)
            throw new Exception("O modelo não pode ser inválido!");

        this.matriz = new Marca[3][3];

        for (int lin = 0; lin < modelo.matriz.length; lin++) {
            for (int col = 0; col < modelo.matriz[lin].length; col++) {
                this.matriz[lin][col] = modelo.matriz[lin][col];
            }
        }
    }

    @Override
    public Object clone() {
        Tabuleiro ret = null;
        try {
            ret = new Tabuleiro(this);
        } catch (Exception e) {
        }
        return ret;
        // faça
    }
}