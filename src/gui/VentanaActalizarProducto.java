package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import VO.ProductoVo;
import controlador.Coordinador;

public class VentanaActalizarProducto extends JDialog implements ActionListener {
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtIdProducto;
	private JButton btnBuscar, btnaCancelar;
	private JButton btnActualizar;
	private Coordinador miCoordinador;

	public VentanaActalizarProducto(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal, modal);
		setSize(412, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes();

	}

	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblTitulo = new JLabel("ACTUALIZAR PRODUCTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 380, 200);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel documento = new JLabel("ID_Producto");
		documento.setBounds(24, 11, 71, 21);
		panel.add(documento);

		txtIdProducto = new JTextField();
		txtIdProducto.setBounds(100, 11, 100, 20);
		panel.add(txtIdProducto);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 50, 71, 21);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 50, 86, 20);
		panel.add(txtNombre);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(214, 50, 71, 21);
		panel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(269, 50, 86, 20);
		panel.add(txtPrecio);

		JSeparator separator = new JSeparator();
		separator.setBounds(24, 95, 331, 12);
		panel.add(separator);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(271, 11, 89, 23);
		panel.add(btnBuscar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(172, 120, 89, 23);
		btnActualizar.addActionListener(this);
		btnActualizar.setEnabled(false);
		panel.add(btnActualizar);

		btnaCancelar = new JButton("Cancelar");
		btnaCancelar.addActionListener(this);
		btnaCancelar.setBounds(271, 120, 89, 23);
		btnaCancelar.setEnabled(false);
		panel.add(btnaCancelar);

		invalidarDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnBuscar) {
			try {
				
			ProductoVo product = miCoordinador.bucarProductoID(Long.parseLong(txtIdProducto.getText()));
			if (product != null) {
				validarDatos();
				txtNombre.setText(product.getNombreProducto());
				txtPrecio.setText(String.valueOf(product.getPrecioProducto()));
				btnActualizar.setEnabled(true);
				txtIdProducto.setEnabled(false);
				btnaCancelar.setEnabled(true);

			}else {
				JOptionPane.showMessageDialog(null,"Confirme si el ID del  producto existe ");
				
			}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Verifique el campo ID del producto y vuelva a intentarlo ");
			}

		} else if (e.getSource() == btnActualizar) {
			
			try {
				
			
			ProductoVo product = miCoordinador.bucarProductoID(Long.parseLong(txtIdProducto.getText()));
			
			if (product != null) {
				product.setIdProducto(Long.parseLong(txtIdProducto.getText()));
				product.setNombreProducto(txtNombre.getText());
				product.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
				String exito = miCoordinador.actualizarProducto(product);

				if (exito.equalsIgnoreCase("ok")) {
					JOptionPane.showMessageDialog(null, "se actualizo correctamente el producto");
					btnaCancelar.setEnabled(false);
					txtIdProducto.setText("");
					btnActualizar.setEnabled(false);
					txtNombre.setText("");
					txtPrecio.setText("");
					txtIdProducto.setEnabled(true);
					invalidarDatos();

				}
			}
			
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"**Verifique los Campos grasias**","Error",JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == btnaCancelar) {
			txtIdProducto.setText("");
			txtIdProducto.setEnabled(true);
			txtNombre.setText("");
			txtNombre.setEnabled(false);
			txtPrecio.setText("");
			txtPrecio.setEnabled(false);
			btnActualizar.setEnabled(false);
			btnaCancelar.setEnabled(false);

		}
	}

	public void invalidarDatos() {
		txtNombre.setEnabled(false);
		txtPrecio.setEnabled(false);
	}

	public void validarDatos() {
		txtNombre.setEnabled(true);
		txtPrecio.setEnabled(true);
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
