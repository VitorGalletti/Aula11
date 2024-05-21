package aula11;

import java.util.ArrayList;
import java.util.List;

public class Modelo {

    private List<Controle> numeros;

    public Modelo() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int valor) {
        numeros.add(new Controle(valor));
    }

    public void removerNumero(int indice) {
        if (indice >= 0 && indice < numeros.size()) {
            numeros.remove(indice);
        }
    }

    public Controle obterNumero(int indice) {
        if (indice >= 0 && indice < numeros.size()) {
            return numeros.get(indice);
        }
        return null;
    }

    public void ordenarInsertionSort() {
        for (int i = 1; i < numeros.size(); i++) {
            Controle atual = numeros.get(i);
            int j = i - 1;
            while (j >= 0 && numeros.get(j).getValor() > atual.getValor()) {
                numeros.set(j + 1, numeros.get(j));
                j--;
            }
            numeros.set(j + 1, atual);
        }
    }

    public void ordenarBubbleSort() {
        for (int i = numeros.size() - 1; i > 0; i--) {
            boolean trocado = false;
            for (int j = 0; j < i; j++) {
                if (numeros.get(j).getValor() > numeros.get(j + 1).getValor()) {
                    Controle aux = numeros.get(j);
                    numeros.set(j, numeros.get(j + 1));
                    numeros.set(j + 1, aux);
                    trocado = true;
                }
            }
            if (!trocado) {
                break;
            }
        }
    }

    public String exibirNumeros() {
        StringBuilder sb = new StringBuilder();
        for (Controle numero : numeros) {
            sb.append(numero.getValor()).append(" ");
        }
        return sb.toString().trim();
    }
}