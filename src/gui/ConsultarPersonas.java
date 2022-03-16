package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import VO.Nacimiento;
import VO.PersonaVo;
import controlador.Coordinador;
import modelo.dao.NacimientoDao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

public class ConsultarPersonas extends JDialog implements ActionListener{

	
	
	private JPanel contentPane;
	private JTable tablaPersonas;
	private JButton btnConsultarPersonas;
	private Coordinador miCoordinador;
	private JScrollPane scroll;
	private JTextField txtImprimir;
	private JTextArea area;
	private JLabel imagen;
	
	public ConsultarPersonas() {
		
		setTitle("Consultar Personas");
		setSize(812,365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
	//	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConsultarPersonas = new JButton("Consultar Personas");
		btnConsultarPersonas.setBounds(278, 21, 206, 40);
		btnConsultarPersonas.addActionListener(this);
		contentPane.add(btnConsultarPersonas);
		
		
		
		scroll = new JScrollPane ();
		scroll.setBounds(10, 99, 776, 174);
		contentPane.add(scroll);
		
		ImageIcon imagen2=new ImageIcon("dog.JPG");
		imagen=new JLabel();
		imagen.setBounds(0, 0, 800, 383);//agregamos la pocision de la imagen
		imagen.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(imagen);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultarPersonas) {
			ArrayList<PersonaVo> lista = miCoordinador.consultarPersonas();
			ArrayList<Nacimiento>listaNacimiento=miCoordinador.consultarNacimiento();
			
			System.out.println("LISTA PERSONAS"+lista);
			System.out.println("lista nbacimiento"+listaNacimiento);
			System.out.println("iiii"+listaNacimiento);
			Lista(lista,listaNacimiento);
		}
	}
	
	public void Lista(ArrayList<PersonaVo> personas,ArrayList<Nacimiento>n) {
		String titulos [] = {"Documento", "Nombre", "Profesion", "Telefono", "Tipo", "Ciudad", "Departamento", "Fecha nacimiento", "Pais"};
		System.out.println(personas.size());
		System.out.println(n.size());
		int celdas;
		if (personas.size()>15) {
			celdas=14;
		} else {
			celdas = personas.size(); 
		}
		//Nacimiento n=miCoordinador.consultarNacimiento(personas.get(i).getNacimiento().getIdNacimiento());
		String cuadro [] [] = new String[celdas][9];
		
		if (personas.size()>0) {
			System.out.println("hola");
			for (int i = 0; i < personas.size(); i++) {
				for (int j = 0; j < n.size(); j++) {
				cuadro[i][0] = personas.get(i).getIdPesona()+"";
				cuadro[i][1] = personas.get(i).getNombre();
				cuadro[i][2] = personas.get(i).getProfesion();
				cuadro[i][3] = personas.get(i).getTelefono();
				cuadro[i][4] = personas.get(i).getTipo()+"";
				cuadro[j][5] = n.get(j).getCiudadNacimiento();
				cuadro[j][6] = n.get(j).getDepartamentoNacimiento();
				cuadro[j][7] = n.get(j).getFechaNacimiento()+"";
				cuadro[j][8] = n.get(j).getPaisNacimiento();
			}
			}
		}else {
			cuadro = new String [14][9];
			
		}
		
		tablaPersonas = new JTable (cuadro,titulos);
		scroll.setViewportView(tablaPersonas);
		
		
	}
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador= miCoordinador;
	}
}
