public class ArvoreBinaria {
    // criando a raiz
    private No raiz;

    // construtor da árvore, inicia com um valor na raiz
    public ArvoreBinaria(int valorInicial) {
        this.raiz = new No(valorInicial);
    }

    // adicionar novo valor na árvore
    public void adicionar(int valor) {
        // Chama o método recursivo para inserir o novo nó
        raiz = inserir(raiz, new No(valor));
    }

    //percorre a árvore e insere o novo nó na posição correta, de forma recursiva
    private No inserir(No atual, No novo) {
        // se o nó atual for nulo, retorna o novo nó
        if (atual == null) return novo;

        // se o valor do novo nó for menor, insere à esquerda
        if (novo.getConteudo() < atual.getConteudo()) {
            atual.setEsquerda(inserir(atual.getEsquerda(), novo));
        } else {
            // se não insere à direita
            atual.setDireita(inserir(atual.getDireita(), novo));
        }

        // retorna o nó atual ja alterado
        return atual;
    }

    // imprime os valores da árvore em ordem
    public void imprimirEmOrdem() {
        emOrdem(raiz); // chama a função recursiva passando a raiz
    }

    // percorre a árvore em ordem (esquerda, raiz, direita)
    private void emOrdem(No atual) {
        if (atual == null) return; // caso base: nó nulo

        emOrdem(atual.getEsquerda());            // visita subárvore da esquerda
        System.out.println(atual.getConteudo()); // visita a raiz (nó atual)
        emOrdem(atual.getDireita());             // visita subárvore da direita
    }
    
    public void excluir(int valor) {
        raiz = remover(raiz, valor); // chama o método de remoção
    }

    // remove um nó com base no valor
    private No remover(No atual, int valor) {
        if (atual == null) return null; // verifica se a raiz é nula

        // se o valor a ser removido for menor, busca na esquerda
        if (valor < atual.getConteudo()) {
            atual.setEsquerda(remover(atual.getEsquerda(), valor));
        }
        // se for maior, busca na direita
        else if (valor > atual.getConteudo()) {
            atual.setDireita(remover(atual.getDireita(), valor));
        }
        // assim que encontra o nó a ser removido
        else {
            //1: nó é uma folha
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                return null; // remove, retornando null
            }
            // 2: tem apenas o filho da direita
            else if (atual.getEsquerda() == null) {
                return atual.getDireita(); // remove e retorna o filho da direita
            }
            // 3: tem apenas o filho da esquerda
            else if (atual.getDireita() == null) {
                return atual.getEsquerda(); // remove e retorna o filho da esquerda
            }
            // 4: nó com dois filhos
            else {
                // encontra o maior dos menores
                No substituto = encontrarMaior(atual.getEsquerda());

                // substitui o valor do nó atual pelo valor do maior da esquerda
                atual.setConteudo(substituto.getConteudo());

                // remove o nó que foi usado como substituto
                atual.setEsquerda(remover(atual.getEsquerda(), substituto.getConteudo()));
            }
        }

        // retorna o nó com as remoções feitas
        return atual;
    }

    // encontra o maior dos menores
    private No encontrarMaior(No atual) {
        // percorre até o nó mais à direita (maior valor)
        while (atual.getDireita() != null) {
            atual = atual.getDireita();
        }
        return atual;
    }
}
