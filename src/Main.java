public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        // Inserção de nós na árvore binária
        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(2);
        arvoreBinaria.inserir(18);

        // Exibição dos nós em pré-ordem
        System.out.println("Pré-ordem: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());

        // Exibição dos nós em ordem
        System.out.println("Em ordem: ");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());

        // Exibição dos nós em pós-ordem
        System.out.println("Pós-ordem: ");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());

        // Remoção de alguns nós
        System.out.println("\nRemovendo o nó com valor 7 (uma folha):");
        arvoreBinaria.remover(7);
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());

        System.out.println("\nRemovendo o nó com valor 3 (um filho):");
        arvoreBinaria.remover(3);
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());

        System.out.println("\nRemovendo o nó com valor 6 (dois filhos):");
        arvoreBinaria.remover(6);
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
    }
}
