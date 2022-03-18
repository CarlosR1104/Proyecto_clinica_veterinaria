package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import VO.MascotaVo;
import VO.PersonaVo;
import controlador.Coordinador;

public class VentanaActualizarMascota extends JDialog implements ActionListener {
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdDueno;
	private JTextField txtNombre;
	private JTextField txtRaza;
	private JButton btnCancelar;
	private JButton btnRegistrar;

	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private PersonaVo miPersonaVo;

	Coordinador miCoordinador;

	/**
	 * Create the dialog.
	 * 
	 * @param b
	 * @param ventanaPrincipal
	 * @param documento
	 */
	public VentanaActualizarMascota(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal, modal);
		setSize(408, 288);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes();

	}

	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblTitulo = new JLabel("GESTIONAR MASCOTAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 370, 192);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblDueno = new JLabel("Id Due\u00F1o:");
		lblDueno.setBounds(199, 17, 71, 21);
		panel.add(lblDueno);

		txtIdDueno = new JTextField();
		txtIdDueno.setBounds(269, 17, 86, 20);
		panel.add(txtIdDueno);
		txtIdDueno.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 49, 71, 21);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 49, 86, 20);
		panel.add(txtNombre);

		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(214, 49, 71, 21);
		panel.add(lblRaza);

		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(269, 49, 86, 20);
		panel.add(txtRaza);

		JSeparator separator = new JSeparator();
		separator.setBounds(24, 127, 331, 12);
		panel.add(separator);

		btnCancelar = new JButton("Buscar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(271, 150, 89, 23);
		panel.add(btnCancelar);

		btnRegistrar = new JButton("Actualizar");
		btnRegistrar.setBounds(172, 150, 89, 23);
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(24, 81, 71, 21);
		panel.add(lblSexo);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Macho", "Hembra" }));
		comboBox.setBounds(88, 81, 86, 22);
		panel.add(comboBox);

		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(214, 82, 71, 21);
		panel.add(lblColor);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Blanco", "Negro", "Caf\u00E9", "Gris", "Manchas" }));
		comboBox_1.setBounds(269, 81, 86, 22);
		panel.add(comboBox_1);

		invalidarCampos();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			MascotaVo miMascota = miCoordinador.buscarMascotaIdPersona(Long.parseLong(txtIdDueno.getText()));
			if (miMascota != null) {
				validarCampos();
				txtIdDueno.setEnabled(false);
				txtNombre.setText(miMascota.getNombre());
				txtRaza.setText(miMascota.getRaza());
				comboBox.setSelectedItem(miMascota.getSexo());
				comboBox_1.setSelectedItem(miMascota.getColorMascota());
				btnRegistrar.setEnabled(true);
			}
		} else if (e.getSource() == btnRegistrar) {

			MascotaVo miMascota = miCoordinador.buscarMascotaIdPersona(Long.parseLong(txtIdDueno.getText()));
			System.out.println();
			if (miMascota != null) {
				miMascota.setNombre(txtNombre.getText());
				miMascota.setColorMascota((String) comboBox_1.getSelectedItem());
				miMascota.setSexo((String) comboBox.getSelectedItem());
				miMascota.setRaza(txtRaza.getText());
				miMascota.setPersona(miPersonaVo);
				miCoordinador.actualizarMascota(miMascota);

				JOptionPane.showMessageDialog(null, "Mascota se actualizo correctamente exitosamente");
				btnRegistrar.setEnabled(false);
				txtIdDueno.setEnabled(true);
				invalidarCampos();

			}
		}
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public void validarCampos() {
		txtNombre.setEnabled(true);
		txtRaza.setEnabled(true);
		comboBox.setEnabled(true);
		comboBox_1.setEnabled(true);

	}

	public void invalidarCampos() {
		txtNombre.setEnabled(false);
		txtRaza.setEnabled(false);
		comboBox.setEnabled(false);
		comboBox_1.setEnabled(false);
	}

}
