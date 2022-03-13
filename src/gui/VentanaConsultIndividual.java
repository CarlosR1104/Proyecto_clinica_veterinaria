package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import VO.MascotaVo;
import VO.PersonaVo;
import VO.ProductoVo;
import controlador.Coordinador;

public class VentanaConsultIndividual extends JDialog implements ActionListener {
	private JTextField txtDocumento;
	private JButton btnConsultar,btnConsultarM,btnActualizarM,btnConsultarP,btnActualizarP;
	private JPanel panel;
	private JTextArea area;
	private JScrollPane scroll;
	
	Coordinador miCoordinador;
	
	
	public VentanaConsultIndividual() {
		setSize(500,500);
		setLayout(null);
		setTitle("Consulta ");
		setLocationRelativeTo(null);
		iniciarComponentes();
		
	}
	
	public void iniciarComponentes() {
	
		panel= new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		setContentPane(panel);
		
		
		
		JLabel etiDocumento=new JLabel("Documento");
		etiDocumento.setBounds(90,40,150,24);
		panel.add(etiDocumento);
		
		txtDocumento=new JTextField();
		txtDocumento.setBounds(165,40,150,24);
		panel.add(txtDocumento);
		
		btnConsultar=new JButton("Buscar Persona");
		btnConsultar.setBounds(330,40,150,24);
		btnConsultar.addActionListener(this);
		panel.add(btnConsultar);
		
		btnConsultarM=new JButton("Buscar Mascota");
		btnConsultarM.setBounds(330,70,150,24);
		btnConsultarM.addActionListener(this);
		panel.add(btnConsultarM);
		
		btnConsultarP = new JButton("Buscar Producto");
		btnConsultarP.setBounds(330,10,150,20);
		btnConsultarP.addActionListener(this);
		panel.add(btnConsultarP);
		
		
		btnActualizarM = new JButton("Editar Mascota");
		btnActualizarM.setBounds(10,320,150,30);
		btnActualizarM.addActionListener(this);
		panel.add(btnActualizarM);
		
		btnActualizarP = new JButton("Editar Producto");
		btnActualizarP.setBounds(200,320,150,30);
		btnActualizarP.addActionListener(this);
		panel.add(btnActualizarP);
		
		
		area=new JTextArea();
		
		
		scroll=new JScrollPane(area);
		scroll.setBounds(20,100,400,200);
		panel.add(scroll);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConsultar) {
			PersonaVo p=miCoordinador.buscarPersona(Long.parseLong(txtDocumento.getText()));
			area.setText(""+p);
		}else if (e.getSource() == btnConsultarM) {
			MascotaVo m = miCoordinador.buscarMascota(Long.parseLong(txtDocumento.getText()));
			area.setText("" + m);
		}else if (e.getSource() == btnActualizarM) {
			MascotaVo miMascota = miCoordinador.buscarMascota(Long.parseLong(txtDocumento.getText()));
			if (miMascota != null) {
					miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el nuevo color de la mascota: "));
					miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre de la mascota: "));
					miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la nueva raza de la mascota: "));
					miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el nuevo sexo de la mascota: "));
					String n = miCoordinador.actualizarMascota(miMascota);
					if (n.equals("ok")) {
						JOptionPane.showMessageDialog(null, "Actualizado");
						System.out.println("VALIDANDO OK");
					}
				}
			}else if (e.getSource() == btnConsultarP) {
				ProductoVo p = miCoordinador.buscarProducto(Long.parseLong(txtDocumento.getText()));
				area.setText(""+p);
			}else if (e.getSource() == btnActualizarP) {
				ProductoVo miProducto= miCoordinador.buscarProducto(Long.parseLong(txtDocumento.getText()));
				if (miProducto!= null) {
					miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto: "));
					miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del producto: ")));
					String n = miCoordinador.actualizarProducto(miProducto);
						if (n.equals("ok")) {
							JOptionPane.showMessageDialog(null, "Actualizado");
							System.out.println("VALIDANDO OK");
						}
					}
				
			}
			
}
	
	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	
}
