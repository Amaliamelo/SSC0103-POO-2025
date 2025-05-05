
/**
 * @author usp
 */
public class Main {
// Main.java
    public static void main(String[] args) {
        // Criando a árvore e inserindo valores
        Inserir insercao = new Inserir() {
            @Override
            public boolean Busca(int valor) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void Deletar(int valor) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        insercao.Inserir(50);
        insercao.Inserir(30);
        insercao.Inserir(20);
        insercao.Inserir(40);
        insercao.Inserir(70);
        insercao.Inserir(60);
        insercao.Inserir(80);

        // Criando instâncias das classes de busca, deleção e percurso
        Busca busca = new Busca(insercao.getRaiz()) {
            @Override
            public void Inserir(int valor) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean Busca(int valor) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void Deletar(int valor) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        Deletar delecao = new Deletar(insercao.getRaiz()) {
            @Override
            public void Inserir(int valor) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public boolean Busca(int valor) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void Deletar(int valor) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };

        // Exibindo a árvore em ordem
        System.out.println("Árvore em ordem:");

        // Testando busca
        System.out.println("\nBusca por 40: " + busca.Busca(40)); // true
        System.out.println("Busca por 100: " + busca.Busca(100)); // false

        // Deletando um valor e mostrando a árvore novamente
        delecao.deletar(20);
        System.out.println("\nÁrvore após deletar 20:");
    }
}
