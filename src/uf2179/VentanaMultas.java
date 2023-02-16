package uf2179;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class VentanaMultas extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private final ButtonGroup buttonGroupPago = new ButtonGroup();
	private JComboBox comboBoxSancion;
	private JLabel lblImporte;
	private JRadioButton rdbtnPagoNormal;
	private JRadioButton rdbtnPagoPronto;
	private JTextArea textAreaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMultas frame = new VentanaMultas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][][][][][][grow]"));
		
		JLabel lblTitulo = new JLabel("DGT - Infracciones");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBackground(new Color(0, 0, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblTitulo, "cell 0 0 3 1,growx");
		
		JLabel lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblMatricula, "cell 0 1,alignx trailing");
		
		txtMatricula = new JTextField();
		contentPane.add(txtMatricula, "cell 1 1,growx");
		txtMatricula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		contentPane.add(lblNombre, "flowx,cell 2 1");
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblApellidos, "cell 0 2,alignx trailing");
		
		txtApellidos = new JTextField();
		contentPane.add(txtApellidos, "cell 1 2 2 1,growx");
		txtApellidos.setColumns(10);
		
		JLabel lblSancion = new JLabel("Sanción:");
		lblSancion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblSancion, "cell 0 3,alignx trailing");
		
		comboBoxSancion = new JComboBox<String>();
		comboBoxSancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccionado = (String) comboBoxSancion.getSelectedItem();
				if (seleccionado.equals("No llevar casco")) {
					lblImporte.setText("200");
				} else {
					lblImporte.setText("500");
				}		
			}
		});
		comboBoxSancion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxSancion.setModel(new DefaultComboBoxModel<String>(new String[] {"No llevar casco", "Conducción temeraria"}));
		contentPane.add(comboBoxSancion, "cell 1 3 2 1,growx");
		
		JLabel lblImporteTitulo = new JLabel("Importe:");
		lblImporteTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblImporteTitulo, "cell 0 4");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 2 1,growx");
		txtNombre.setColumns(10);
		
		lblImporte = new JLabel("200");
		contentPane.add(lblImporte, "cell 1 4");
		
		rdbtnPagoNormal = new JRadioButton("Pago Normal");
		rdbtnPagoNormal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnPagoNormal.setSelected(true);
		rdbtnPagoNormal.setActionCommand("Pago normal");
		buttonGroupPago.add(rdbtnPagoNormal);
		contentPane.add(rdbtnPagoNormal, "cell 1 5");
		
		rdbtnPagoPronto = new JRadioButton("Pronto Pago");
		rdbtnPagoPronto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnPagoPronto.setActionCommand("Pronto pago");
		buttonGroupPago.add(rdbtnPagoPronto);
		contentPane.add(rdbtnPagoPronto, "cell 2 5");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarResultado();
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnAceptar, "cell 0 6 3 1,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 7 3 1,grow");
		
		textAreaResultado = new JTextArea();
		scrollPane.setViewportView(textAreaResultado);
	}

	protected void mostrarResultado() {
		String matricula = txtMatricula.getText();
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String sancion = (String) comboBoxSancion.getSelectedItem();
		String tipoPago = buttonGroupPago.getSelection().getActionCommand();
				
		if (matricula == null || matricula.isBlank()
				|| nombre==null || nombre.isBlank()
				|| apellidos==null || apellidos.isBlank()){
			JOptionPane.showMessageDialog(this, "Hay datos sin introducir. Por favor, introduzca todos los datos requeridos.", "Faltan datos", JOptionPane.ERROR_MESSAGE);
			return;}
		
		if (tipoPago.equals("Pago normal")) {
			textAreaResultado.setText("Conductor: " + nombre +" " + apellidos
					+ "\nInfracción: " + sancion + "\nImporte: " + lblImporte.getText());
		} else {
			textAreaResultado.setText("Conductor: " + nombre +" " + apellidos
					+ "\nInfracción: " + sancion + "\nImporte: " + lblImporte.getText()
					+ "\nPronto pago: " + Integer.parseInt(lblImporte.getText())/2);
		}
		
		
	}

}
