package aula11;

import javax.swing.*;
import java.awt.event.*;

public class Visão extends JFrame implements ActionListener {

    private final Modelo modelo;
    private JTextField campoNumeros;
    private JButton botaoAdicionar;
    private JButton botaoOrdenarInsertion;
    private JButton botaoOrdenarBubble;
    private JTextArea areaResultado;

    public Visão(Modelo modelo) {
        this.modelo = modelo;
        setTitle("Ordenação de Números");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create and configure UI components
        campoNumeros = new JTextField(10);
        botaoAdicionar = new JButton("Adicionar");
        botaoOrdenarInsertion = new JButton("Ordenar (Insertion Sort)");
        botaoOrdenarBubble = new JButton("Ordenar (Bubble Sort)");
        areaResultado = new JTextArea(5, 20);
        areaResultado.setEditable(false);

        // Add components to the frame
        add(new JLabel("Informe um número:"));
        add(campoNumeros);
        add(botaoAdicionar);
        add(botaoOrdenarInsertion);
        add(botaoOrdenarBubble);
        add(new JScrollPane(areaResultado));

        // Register action listener for buttons
        botaoAdicionar.addActionListener(this);
        botaoOrdenarInsertion.addActionListener(this);
        botaoOrdenarBubble.addActionListener(this);

        // Display the initial state (empty list)
        areaResultado.setText(modelo.exibirNumeros());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == botaoAdicionar) {
            try {
                int valor = Integer.parseInt(campoNumeros.getText());
                modelo.adicionarNumero(valor);
                campoNumeros.setText(""); // Clear the input field
                areaResultado.setText(modelo.exibirNumeros());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor inválido!");
            }
        } else if (source == botaoOrdenarInsertion) {
            modelo.ordenarInsertionSort();
            areaResultado.setText(modelo.exibirNumeros());
        } else if (source == botaoOrdenarBubble) {
            modelo.ordenarBubbleSort();
            areaResultado.setText(modelo.exibirNumeros());
        }
    }

    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Visão visão = new Visão(modelo);
        visão.setSize(400, 300);
        visão.setVisible(true);
    }
}
