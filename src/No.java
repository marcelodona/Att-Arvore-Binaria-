public class No {
    // atributo que guarda o valor do nó
    private int conteudo;

    // aponta para o filho da esquerda
    private No esquerda;

    // aponta para o filho da direita
    private No direita;

    // construtor do nó
    public No(int conteudo) {
        this.conteudo = conteudo;
        this.esquerda = null;
        this.direita = null;
    }

    // retorna o valor armazenado no nó
    public int getConteudo() {
        return conteudo;
    }

    // altera o valor armazenado no nó
    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    // rtorna o filho da esquerda
    public No getEsquerda() {
        return esquerda;
    }

    // define o filho da esquerda
    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    // retorna o filho da direita
    public No getDireita() {
        return direita;
    }

    // define o filho da direita
    public void setDireita(No direita) {
        this.direita = direita;
    }
}
