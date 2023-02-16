package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPpal extends JFrame {

	private JPanel contentPane;
	private Controlador controlador;


	/**
	 * Create the frame.
	 */
	public VentanaPpal() {
		setTitle("Ventana Examen MF0494");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][grow][grow][grow]", "[][62px][][62][][62.00]"));
		
		JButton btnNewButton_1 = new JButton("Mostrar Infractores");
		contentPane.add(btnNewButton_1, "cell 1 3,grow");
		
		JButton btnNewButton_2 = new JButton("Insertar Infractor");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarInsertarInfractores();
			}
		});
		contentPane.add(btnNewButton_2, "cell 4 3,grow");
	}


	public void setControlador(Controlador controlador) {
		this.controlador=controlador;		
	}

}
