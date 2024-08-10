public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if (this.raiz == null) {
            this.raiz = novoNo; // nó se torna uma nova raiz
        } else {
            No atual = this.raiz;
            No pai = null;
            boolean esquerda = false;

            while (atual != null) {
                pai = atual;
                if (novoNo.getValor() < atual.getValor()) {
                    atual = atual.getEsq();
                    esquerda = true;
                } else {
                    atual = atual.getDir();
                    esquerda = false;
                }
            }
            if (esquerda) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void preOrdem(No no) {
        if (no == null) return;
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if (no == null) return;
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if (no == null) return;
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public boolean remover(int valor) {
        No atual = raiz;
        No pai = raiz;
        boolean eFilhoEsquerdo = true;

        while (atual.getValor() != valor) { //loop que encontra o nó que será removido
            pai = atual;
            if (valor < atual.getValor()) {
                eFilhoEsquerdo = true;
                atual = atual.getEsq();
            } else { // se o valor é menor que nó atual: esquerda
                eFilhoEsquerdo = false;
                atual = atual.getDir();
            } // se o nó é maior que o nó atual: direita
        }

        if (atual.getEsq() == null && atual.getDir() == null) {
            if (atual == raiz) {
                raiz = null;
            } else if (eFilhoEsquerdo) {
                pai.setEsq(null);
            } else {
                pai.setDir(null);
            }
        } else if (atual.getEsq() == null) {
            if (atual == raiz) {
                raiz = atual.getDir();
            } else if (eFilhoEsquerdo) {
                pai.setEsq(atual.getDir());
            } else {
                pai.setDir(atual.getDir());
            }
        } else if (atual.getDir() == null) {
            if (atual == raiz) {
                raiz = atual.getEsq();
            } else if (eFilhoEsquerdo) {
                pai.setEsq(atual.getEsq());
            } else {
                pai.setDir(atual.getEsq());
            }
        } else {
            No sucessor = getSucessor(atual);
            if (atual == raiz) {
                raiz = sucessor;
            } else if (eFilhoEsquerdo) {
                pai.setEsq(sucessor);
            } else {
                pai.setDir(sucessor);
            }
            sucessor.setEsq(atual.getEsq());
        }

        return true;
    }
    private No getSucessor(No no) {
        No sucessorPai = no;
        No sucessor = no;
        No atual = no.getDir();

        while (atual != null) {
            sucessorPai = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }

        if (sucessor != no.getDir()) {
            sucessorPai.setEsq(sucessor.getDir());
            sucessor.setDir(no.getDir());
        }

        return sucessor;
    }
}
