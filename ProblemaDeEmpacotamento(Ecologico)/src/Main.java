import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(Main::criarInterface);
    }

    private static void criarInterface() {
        JFrame frame = new JFrame("Otimização de Empacotamento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null); 
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JLabel caixaLabel = new JLabel("Volumes das Caixas (separados por espaço):");
        JTextField caixaField = new JTextField(20);

        JLabel caminhaoLabel = new JLabel("Capacidades dos Caminhões (separados por espaço):");
        JTextField caminhaoField = new JTextField(20);

        JButton calcularButton = new JButton("Calcular Cargas");

        JButton resetButton = new JButton("Limpar");

        JTextArea resultadoArea = new JTextArea(10, 40);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Arial", Font.PLAIN, 14));
        resultadoArea.setMargin(new Insets(10, 10, 10, 10));
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        panel.add(caixaLabel, gbc);
        panel.add(caixaField, gbc);
        panel.add(caminhaoLabel, gbc);
        panel.add(caminhaoField, gbc);
        panel.add(calcularButton, gbc);
        panel.add(resetButton, gbc);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        calcularButton.addActionListener(e -> {
            try {
                List<Integer> volumesCaixas = parseVolumes(caixaField.getText());
                List<Integer> volumesCaminhoes = parseVolumes(caminhaoField.getText());
                if (volumesCaixas.isEmpty() || volumesCaminhoes.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira volumes para caixas e caminhões.",
                            "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                } else {
                    List<List<Integer>> cargas = firstFitDecreasing(volumesCaixas, volumesCaminhoes);
                    resultadoArea.setText(formatarCargas(cargas));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Erro: Por favor, insira apenas números inteiros válidos.",
                        "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }
        });

        resetButton.addActionListener(e -> {
            caixaField.setText("");
            caminhaoField.setText("");
            resultadoArea.setText("");
        });

        frame.setVisible(true);
    }

    private static List<Integer> parseVolumes(String input) {
        return List.of(input.trim().split("\\s+")).stream()
                .filter(s -> !s.isEmpty()) 
                .map(Integer::parseInt)
                .filter(i -> i > 0) 
                .collect(Collectors.toList());
    }

    private static List<List<Integer>> firstFitDecreasing(List<Integer> volumesCaixas, List<Integer> volumesCaminhoes) {
        volumesCaixas.sort(Collections.reverseOrder()); 
        List<List<Integer>> cargas = new ArrayList<>();
        volumesCaminhoes.forEach(capacidade -> cargas.add(new ArrayList<>())); 

        for (int volume : volumesCaixas) {
            boolean alocado = false;
            for (int i = 0; i < volumesCaminhoes.size(); i++) {
                if (volumesCaminhoes.get(i) >= volume) {
                    cargas.get(i).add(volume); 
                    volumesCaminhoes.set(i, volumesCaminhoes.get(i) - volume);
                    alocado = true;
                    break;
                }
            }
            if (!alocado) {
                JOptionPane.showMessageDialog(null, "Algumas caixas não puderam ser alocadas!",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        return cargas;
    }

    private static String formatarCargas(List<List<Integer>> cargas) {
        StringBuilder resultado = new StringBuilder("Cargas dos caminhões:\n");
        int i = 1;
        for (List<Integer> carga : cargas) {
            resultado.append("Caminhão ").append(i++).append(": ").append(carga)
                    .append(" (Volume total: ").append(carga.stream().mapToInt(Integer::intValue).sum()).append(")\n");
        }
        return resultado.toString();
    }
}
