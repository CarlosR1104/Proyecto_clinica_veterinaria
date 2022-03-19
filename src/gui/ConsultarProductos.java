package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import VO.Nacimiento;
import VO.PersonaVo;
import VO.ProductoVo;
import controlador.Coordinador;

public class ConsultarProductos extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable tablaProductos;
	private JButton btnConsultarProductos;
	private Coordinador miCoordinador;
	private JScrollPane scroll;
	
	public ConsultarProductos() {
		
		setTitle("Consultar Productos");
		setSize(458,365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConsultarProductos = new JButton("Consultar Productos");
		btnConsultarProductos.setBounds(115, 22, 206, 40);
		btnConsultarProductos.addActionListener(this);
		contentPane.add(btnConsultarProductos);
		
		
		
		scroll = new JScrollPane ();
		scroll.setBounds(10, 99, 422, 174);
		contentPane.add(scroll);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultarProductos) {
			ArrayList<ProductoVo> lista = miCoordinador.consultarProductos();
			
			System.out.println("LISTA PERSONAS"+lista);
			Lista(lista);
		}
	}
	
	public void Lista(ArrayList<ProductoVo> producto) {
		String titulos [] = {"Id", "Nombre", "Precio"};
		System.out.println(producto.size());
		int celdas;
		if (producto.size()>15) {
			celdas=14;
		} else {
			celdas = producto.size(); 
		}
		//Nacimiento n=miCoordinador.consultarNacimiento(personas.get(i).getNacimiento().getIdNacimiento());
		String cuadro [] [] = new String[celdas][3];
		
		if (producto.size()>0) {
			System.out.println("hola");
			for (int i = 0; i < producto.size(); i++) {
				cuadro[i][0] = producto.get(i).getIdProducto()+"";
				cuadro[i][1] = producto.get(i).getNombreProducto();
				cuadro[i][2] = producto.get(i).getPrecioProducto()+"";
			}
		}else {
			cuadro = new String [14][9];
			
		}
		
		tablaProductos = new JTable (cuadro,titulos);
		scroll.setViewportView(tablaProductos);
		
		
	}
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador= miCoordinador;
	}

}
