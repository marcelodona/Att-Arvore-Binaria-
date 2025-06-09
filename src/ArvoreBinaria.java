public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria(int valorInicial) {
        this.raiz = new No(valorInicial);
    }

    public void adicionar(int valor) {
        raiz = inserir(raiz, new No(valor));
    }

    private No inserir(No atual, No novo) {
        if (atual == null) return novo;

        if (novo.getConteudo() < atual.getConteudo()) {
            atual.setEsquerda(inserir(atual.getEsquerda(), novo));
        } else {
            atual.setDireita(inserir(atual.getDireita(), novo));
        }
        return atual;
    }

    public void imprimirEmOrdem() {
        emOrdem(raiz);
    }

    private void emOrdem(No atual) {
        if (atual == null) return;
        emOrdem(atual.getEsquerda());
        System.out.println(atual.getConteudo());
        emOrdem(atual.getDireita());
    }

    public void excluir(int valor) {
        raiz = remover(raiz, valor);
    }

    private No remover(No atual, int valor) {
        if (atual == null) return null;

        if (valor < atual.getConteudo()) {
            atual.setEsquerda(remover(atual.getEsquerda(), valor));
        } else if (valor > atual.getConteudo()) {
            atual.setDireita(remover(atual.getDireita(), valor));
        } else {
            // nó folha
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                return null;
            }
            // apenas um filho
            else if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }
            // dois filhos
            else {
                No substituto = encontrarMaior(atual.getEsquerda());
                atual.setConteudo(substituto.getConteudo());
                atual.setEsquerda(remover(atual.getEsquerda(), substituto.getConteudo()));
            }
        }

        return atual;
    }

    private No encontrarMaior(No atual) {
        while (atual.getDireita() != null) {
            atual = atual.getDireita();
        }
        return atual;
    }
}
