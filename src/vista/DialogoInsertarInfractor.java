package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Infractor;
import net.miginfocom.swing.MigLayout;
import javax.swing.DefaultComboBoxModel;

public class DialogoInsertarInfractor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_2;
	private Controlador controlador;
	private JComboBox comboSancion;
	private JSpinner spinnerPuntos;
	private JSpinner spinnerAntiguedad;

	/**
	 * Create the dialog.
	 */
	public DialogoInsertarInfractor() {
		setBounds(100, 100, 450, 300);
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setVgap(1);
		borderLayout.setHgap(1);
		getContentPane().setLayout(borderLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblNewLabel_2 = new JLabel("    DGT - Infracciones");
		lblNewLabel_2.setPreferredSize(new Dimension(97, 30));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBackground(Color.BLUE);
		getContentPane().add(lblNewLabel_2, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, "");
		panel.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow,fill]", "[grow][][grow][][grow][][][][grow][][grow][grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		panel.add(lblNewLabel_3, "cell 0 0,alignx trailing");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(txtDNI, "cell 1 0 2 1,growx");
		txtDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel.add(lblNombre, "cell 3 0,alignx trailing");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(txtNombre, "cell 4 0,growx");
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		panel.add(lblApellidos, "cell 0 2,alignx trailing");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(txtApellidos, "cell 1 2 4 1,growx");
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Antig\u00FCedad:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_5, "cell 0 4,alignx right");
		
		spinnerAntiguedad = new JSpinner();
		spinnerAntiguedad.setModel(new SpinnerNumberModel(1, 0, 70, 1));
		panel.add(spinnerAntiguedad, "cell 1 4");
		
		JLabel lblNewLabel = new JLabel("Sanci\u00F3n:");
		panel.add(lblNewLabel, "cell 0 6,alignx trailing");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		comboSancion = new JComboBox();
		comboSancion.setModel(new DefaultComboBoxModel(new String[] {"No llevar casco", "Conduccion temeraria"}));
		comboSancion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(comboSancion, "cell 1 6 4 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Puntos:");
		panel.add(lblNewLabel_1, "cell 0 8,alignx right");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		spinnerPuntos = new JSpinner();
		spinnerPuntos.setModel(new SpinnerNumberModel(12, 1, 15, 1));
		panel.add(spinnerPuntos, "cell 1 8");
		
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow,fill]", "[grow,fill]"));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						recogerDatos();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void recogerDatos() {
		
		try {
		String dni = txtDNI.getText();
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();	
		int antiguedad = (int) spinnerAntiguedad.getValue();
		float sancion;
		int puntos = (int) spinnerPuntos.getValue();
		
		if ((float) comboSancion.getSelectedIndex()==0) {
			sancion = 200;
		} else {
			sancion = 500;
		}

		Infractor infractor = new Infractor (dni, nombre, apellidos, antiguedad, sancion, puntos);
		controlador.insertarInfractor(infractor);

		JOptionPane.showMessageDialog(this, "Infractor insertado correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
		
		this.setVisible(false);
		vaciarDatos();
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Hay datos sin introducir. Por favor, introduzca los datos numéricos correctos en código departamento/cento y los que puedan faltar.", "Faltan datos", JOptionPane.ERROR_MESSAGE);
		}
	}
	

	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
		
	}

	public void vaciarDatos() { 
		txtDNI.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");	
		spinnerAntiguedad.setValue(1);
		comboSancion.setSelectedIndex(-1);
		spinnerPuntos.setValue(12);
		}
	}
