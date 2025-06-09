public class Main {
    public static void main(String[] args) {
        // árvore binária com a raiz 10
        ArvoreBinaria arvore = new ArvoreBinaria(10);

        arvore.adicionar(5);
        arvore.adicionar(-2);
        arvore.adicionar(11);
        arvore.adicionar(22);
        arvore.adicionar(23);
        arvore.adicionar(25);
        arvore.adicionar(-10);
        arvore.adicionar(0);

        // árvore em ordem (menor para maior)
        System.out.println("Árvore em ordem:");
        arvore.imprimirEmOrdem();

        // remoção de nós folha
        arvore.excluir(0);
        arvore.excluir(25);
        System.out.println("\nApós remover nós folhas (0 e 25):");
        arvore.imprimirEmOrdem();

        // remoção de nó com apenas um filho
        arvore.excluir(22);  // só tem o filho 23
        System.out.println("\nApós remover nó com um filho (22):");
        arvore.imprimirEmOrdem();

        // remoção da raiz (nó principal da árvore, a raiz tem dois filhos (5 e 11), então o código vai buscar o maior valor da subárvore esquerda
        arvore.excluir(10);
        System.out.println("\nApós remover a raiz (10):");
        arvore.imprimirEmOrdem();
    }
}
