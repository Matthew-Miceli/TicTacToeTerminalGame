import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class GUICalculatorDriver extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		JLabel currEquation = new JLabel("5 + 5");
		JButton clearButton = new JButton("AC");
		JButton changeSigns = new JButton("+/-");
		JButton modulusButton = new JButton("%");
		JButton divButton = new JButton("%");

		JPanel panel0 = new JPanel(new FlowLayout());
		JPanel panel1 = new JPanel(new FlowLayout());
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		panel0.add(currEquation);
		panel1.add(clearButton);
		panel1.add(changeSigns);
		panel1.add(modulusButton);
		panel1.add(divButton);

		frame.add(panel0);
		frame.add(panel1);

		frame.setLayout(new FlowLayout());
		frame.setSize(300, 300);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
