package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import VO.PersonaVo;
import VO.PersonasProductosVo;
import VO.ProductoVo;
import controlador.Coordinador;
import modelo.dao.PersonaDao;
import modelo.dao.PersonaProductoDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminarProductos extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel nombre,precio,etiNombre,etiPrecio,etiId;
	private JTextField txtNombre,txtPrecio,txtNombre2,txtId;
	private JButton btnEliminarP,btnActualizarP,btnConfirmar,btnBuscar,btnComprar;
	private Coordinador miCoordinador;
	
	public VentanaEliminarProductos() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		contentPane.setLayout(null);
		
		nombre= new JLabel("Ingrese el nombre");
		nombre.setBounds(10,10,150,20);
		contentPane.add(nombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10,30,200,40);
		contentPane.add(txtNombre);
	
		btnEliminarP= new JButton("Eliminar Producto");
		btnEliminarP.setBounds(220,15,150,30);
		btnEliminarP.addActionListener(this);
		contentPane.add(btnEliminarP);
		
		btnActualizarP= new JButton("Actualizar Producto");
		btnActualizarP.setBounds(220,50,150,30);
		btnActualizarP.addActionListener(this);
		contentPane.add(btnActualizarP);
		
		btnBuscar = new JButton("Buscar Producto");
		btnBuscar.setBounds(220,90,150,30);
		btnBuscar.addActionListener(this);
		contentPane.add(btnBuscar);
		
		btnComprar = new JButton("Comprar Producto");
		btnComprar.setBounds(220,150,150,30);
		btnComprar.addActionListener(this);
		btnComprar.setEnabled(false);
		contentPane.add(btnComprar);
		
		etiId = new JLabel("Id");
		etiId.setBounds(10,80,100,20);
		contentPane.add(etiId);
		
		txtId = new JTextField();
		txtId.setBounds(80,80,100,30);
		contentPane.add(txtId);
		
		etiNombre = new JLabel("Nombre");
		etiNombre.setBounds(10,120,100,20);
		contentPane.add(etiNombre);
		
		txtNombre2 = new JTextField();
		txtNombre2.setBounds(80,120,100,30);
		contentPane.add(txtNombre2);
		
		etiPrecio = new JLabel("Precio");
		etiPrecio.setBounds(10,150,100,20);
		contentPane.add(etiPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(80,160,100,30);
		contentPane.add(txtPrecio);
		
		txtId.setEnabled(false);
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(80,200,100,30);
		btnConfirmar.addActionListener(this);
		btnConfirmar.setEnabled(false);
		contentPane.add(btnConfirmar);
		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizarP) {
			ProductoVo miProducto= miCoordinador.buscarProducto(txtNombre.getText());
			if (miProducto != null) {
				txtNombre2.setText(miProducto.getNombreProducto());
				txtId.setText(String.valueOf(miProducto.getIdProducto()));
				txtPrecio.setText(String.valueOf(miProducto.getPrecioProducto()));
				btnConfirmar.setEnabled(true);				
			}
			
		}else if (e.getSource() == btnConfirmar) {
			ProductoVo miProducto= miCoordinador.buscarProducto(txtNombre.getText());
			if (miProducto != null) {
				miProducto.setNombreProducto(txtNombre2.getText());
				miProducto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
				miCoordinador.actualizarProducto(miProducto);
				JOptionPane.showMessageDialog(null, "Actualizado Correctamente");
			}
		}else if (e.getSource() == btnEliminarP) {
			String p = miCoordinador.eliminarProducto(txtNombre.getText());
			if (p.equalsIgnoreCase("Eliminado")) {
				JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
			}else {
				JOptionPane.showMessageDialog(null, "No se ha eliminado, Ha ocurrido un error");
			}
		}else if (e.getSource() == btnBuscar) {
			ProductoVo miProducto= miCoordinador.buscarProducto(txtNombre.getText());
			if (miProducto != null) {
				txtNombre2.setText(miProducto.getNombreProducto());
				txtId.setText(String.valueOf(miProducto.getIdProducto()));
				txtPrecio.setText(String.valueOf(miProducto.getPrecioProducto()));
				btnComprar.setEnabled(true);
				
			}
		}else if (e.getSource() == btnComprar) {
			Long id = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la persona que va a comprar el producto"));
			PersonaVo p = miCoordinador.buscarPersona(id);
			if (p != null) {
				PersonaProductoDao persona_Prod = new PersonaProductoDao();
				PersonasProductosVo persona_Prod_Vo = new PersonasProductosVo();
				
				persona_Prod_Vo.setPersonaId(id);
				persona_Prod_Vo.setProductoId(Long.parseLong(txtId.getText()));
				persona_Prod.registrarPersonaProducto(persona_Prod_Vo);
				JOptionPane.showMessageDialog(null, "La compra se ha hecho con exito");
			}else {
				JOptionPane.showMessageDialog(null, "Error", "Verifique que la persona este registrada en la base de datos", JOptionPane.ERROR_MESSAGE);
			}
		}	
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
