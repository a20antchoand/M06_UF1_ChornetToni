package m06.uf.exemples;

import javax.swing.*;

public class popup {
	public static void main(String args[]) {
		JPanel panel = new JPanel();
		panel.add(new JLabel("Jordi Burro:"));
		JTextField texto1 = new JTextField(20);
		panel.add(texto1);
		panel.add(new JLabel("Toni Guapo:"));
		JTextField texto2 = new JTextField(20);
		panel.add(texto2);
		JOptionPane.showConfirmDialog(null, panel);

		System.out.println("Jordi muy burro: " + texto1.getText());
		System.out.println("Toni igual de burro: " + texto2.getText());
	}
}