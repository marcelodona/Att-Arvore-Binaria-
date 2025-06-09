public class Main {
    public static void main(String[] args) {
        // Criando a árvore com o nó raiz 50
        ArvoreBinaria arvore = new ArvoreBinaria(10);

        // Inserindo elementos
        arvore.inserirRecursivoRedirecionamentoOtimizado(5);
        arvore.inserirRecursivoRedirecionamentoOtimizado(-2);
        arvore.inserirRecursivoRedirecionamentoOtimizado(11);
        arvore.inserirRecursivoRedirecionamentoOtimizado(22);
        arvore.inserirRecursivoRedirecionamentoOtimizado(23);
        arvore.inserirRecursivoRedirecionamentoOtimizado(25);
        arvore.inserirRecursivoRedirecionamentoOtimizado(-10);
        arvore.inserirRecursivoRedirecionamentoOtimizado(0);


        System.out.println("Árvore em ordem (inicial):");
        arvore.visualizar();

        // Testando busca de filho
        int valorBuscado = 10;
        No encontrado = arvore.buscarFilho(valorBuscado);
        if (encontrado != null) {
            System.out.println("\nValor " + valorBuscado + " encontrado na árvore.");
        } else {
            System.out.println("\nValor " + valorBuscado + " não encontrado na árvore.");
        }

        // Testando busca de pai
        No pai = arvore.buscarPai(valorBuscado);
        if (pai != null) {
            System.out.println("Pai de " + valorBuscado + " é: " + pai.getConteudo());
        }

        // Removendo nó folha
        System.out.println("\nRemovendo nó folha (25):");
        arvore.removerNo(25);
        arvore.visualizar();

        // Removendo nó com um filho
        System.out.println("\nRemovendo nó com um filho (22):");
        arvore.removerNo(22);
        arvore.visualizar();

        // Removendo nó com dois filhos
        System.out.println("\nRemovendo nó com dois filhos (-2):");
        arvore.removerNo(-2);
        arvore.visualizar();
    }
}
