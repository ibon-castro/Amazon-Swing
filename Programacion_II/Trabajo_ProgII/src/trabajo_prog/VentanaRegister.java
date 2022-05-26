package trabajo_prog;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.*;
import java.awt.*;

public class VentanaRegister extends JFrame {
	
	// Listas que almacenan los datos de cada usuario
	private ArrayList<String> nombres = new ArrayList<String>();
	private ArrayList<String> apellidos = new ArrayList<String>();
	private ArrayList<String> nombresUsuario = new ArrayList<String>();
	private ArrayList<String> correos = new ArrayList<String>();
	private ArrayList<String> contraseñas = new ArrayList<String>();
	private ArrayList<String> descuentos = new ArrayList<String>();

	// Constructor
	public VentanaRegister() {
		inicializar();
	}

	private void inicializar() {
		
		// Crear pantalla, icono, título, tamaño, localización y disposición principal
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/graphics/amazon.png");
		setIconImage(icono);
		setTitle("Amazon");
		setSize(800, 500);
		setLocation(200, 100);
		this.setLayout(new GridLayout(8, 1));

		/* Crear los siguientes contenedores de texto, junto con sus etiquetas:
		 * - Estudiante, jubliado o ninguna
		 * - Nombre
		 * - Apellido
		 * - Nomnbre de usuario
		 * - Correo
		 * - Contraseña
		 */
		JRadioButton estudiante = new JRadioButton("Estudiante (50 %)", false);
		JRadioButton jubilado= new JRadioButton("Jubilado (25 %)", false);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(estudiante);
		grupo.add(jubilado);
		JPanel opciones = new JPanel();
		opciones.add(estudiante);
		opciones.add(jubilado);
		JLabel nombre = new JLabel("Nombre:");
		JTextField nombreTxt = new JTextField(25);
		JPanel panelNombre = new JPanel();
		panelNombre.add(nombre);
		panelNombre.add(nombreTxt);
		JLabel apellido = new JLabel("Apellido:");
		JTextField apellidoTxt = new JTextField(25);
		JPanel panelApellido = new JPanel();
		panelApellido.add(apellido);
		panelApellido.add(apellidoTxt);
		JLabel nombreUsuario = new JLabel("Nombre de usuario:");
		JTextField nombreUsuarioTxt = new JTextField(18);
		JPanel panelNombreUsuario = new JPanel();
		panelNombreUsuario.add(nombreUsuario);
		panelNombreUsuario.add(nombreUsuarioTxt);
		JLabel correo = new JLabel("Correo electrónico:");
		JTextField correoTxt = new JTextField(18);
		JPanel panelCorreo = new JPanel();
		panelCorreo.add(correo);
		panelCorreo.add(correoTxt);
		JLabel contraseña = new JLabel("Contraseña:");
		JTextField contraseñaTxt = new JTextField(22);
		JPanel panelContraseña = new JPanel();
		panelContraseña.add(contraseña);
		panelContraseña.add(contraseñaTxt);
		JButton botonRegistro = new JButton("Registrarse");
		JPanel panelBoton = new JPanel();
		panelBoton.add(botonRegistro);
		JLabel error = new JLabel("");

		// Añadir lo anterior a la disposición
		this.add(opciones);
		this.add(panelNombre);
		this.add(panelApellido);
		this.add(panelNombreUsuario);
		this.add(panelCorreo);
		this.add(panelContraseña);
		this.add(error);
		this.add(panelBoton);

		/* Si todos los parametros son introducidos correctamente y no se repiten, 
		*remite a la pestaña de inicio de sesión. Si no, salta un error
		*/
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean nombreBien = false;
				boolean apellidoBien = false;
				boolean nombreUsuarioBien = false;
				boolean correoBien = false;
				boolean contraseñaBien = false;
				boolean usuarioCogido = false;
				boolean correoCogido = false;
				
				// Hacer que cuando el mensaje de error esté cierto tiempo en la pantalla, desaparezca
				ActionListener desaparecer = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						error.setText("");
					}
				};
				Timer tiempo = new Timer(3000, desaparecer);

				// Leer er archivo
				try {
					leerCsv();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				// Comprobación de todos los parametros introducidos
				if (nombreTxt.getText().length() > 1) {
					nombreBien = true;
				} else {
					error.setText("Nombre demasiado corto");
				}
				if (apellidoTxt.getText().length() > 1) {
					apellidoBien = true;
				} else {
					error.setText("Apellido demasiado corto");
				}
				if (nombreUsuarioTxt.getText().length() < 16) {
					nombreUsuarioBien = true;
				} else {
					error.setText("Nombre de usuario demasiado largo");
					tiempo.start();
				}
				if (!nombresUsuario.contains(nombreUsuarioTxt.getText())) {
					usuarioCogido = true;
				} else {
					error.setText("Nombre de usuario cogido");
					tiempo.start();
				}
				if (correoTxt.getText().contains("@") && correoTxt.getText().contains(".")) {
					correoBien = true;
				} else {
					error.setText("El correo debe contener un @ y un .");
					tiempo.start();
				}
				if (!correos.contains(correoTxt.getText())) {
					correoCogido = true;
				} else {
					error.setText("Correo cogido");
					tiempo.start();
				}
				if (contraseñaTxt.getText().length() > 5) {
					contraseñaBien = true;
				} else {
					error.setText("Contraseña demasiado corta");
					tiempo.start();
				}
				
				// Si los parametros anteriores son correctos, los pasa al archivo
				if (nombreBien && apellidoBien && nombreUsuarioBien && usuarioCogido && correoBien && correoCogido
						&& contraseñaBien) {
					if(estudiante.isSelected()) {
						Estudiante estudiante = new Estudiante(nombreTxt.getText(), apellidoTxt.getText(),
							nombreUsuarioTxt.getText(), correoTxt.getText(), contraseñaTxt.getText(), "estudiante");
						escribirCsv(estudiante);
					}else if(jubilado.isSelected()){
						Jubilado jubilado = new Jubilado(nombreTxt.getText(), apellidoTxt.getText(),
							nombreUsuarioTxt.getText(), correoTxt.getText(), contraseñaTxt.getText(), "jubilado");
						escribirCsv(jubilado);
					}else {
						Otros otro = new Otros(nombreTxt.getText(), apellidoTxt.getText(),
							nombreUsuarioTxt.getText(), correoTxt.getText(), contraseñaTxt.getText(), "otros");
						escribirCsv(otro);
					}
					
					try {
						leerCsv();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					VentanaLogin vl = new VentanaLogin();
					vl.setVisible(true);
					dispose();

				}

			}
		});
		
		// Cuando se presiona la x, se cierra la ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Escribir los datos de una persona en el archivo
	public void escribirCsv(Estudiante e) {
		String path = "src/personas.csv";
		try {
			FileWriter fw = new FileWriter(path, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String saltoLinea = "\n";
			bw.write(saltoLinea);
			bw.write(e.toString());
			bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public void escribirCsv(Jubilado j) {
		String path = "src/personas.csv";
		try {
			FileWriter fw = new FileWriter(path, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String saltoLinea = "\n";
			bw.write(saltoLinea);
			bw.write(j.toString());
			bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public void escribirCsv(Otros o) {
		String path = "src/personas.csv";
		try {
			FileWriter fw = new FileWriter(path, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String saltoLinea = "\n";
			bw.write(saltoLinea);
			bw.write(o.toString());
			bw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	// Leer el CSV, y pasar a nuestras listas los datos
	public void leerCsv() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/trabajo_prog/personas.csv"));
			String linea = br.readLine();
			while (null != linea) {
				String[] campos = linea.split(";");
				nombres.add(campos[0]);
				apellidos.add(campos[1]);
				nombresUsuario.add(campos[2]);
				correos.add(campos[3]);
				contraseñas.add(campos[4]);
				descuentos.add(campos[5]);
				linea = br.readLine();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (null != br) {
				br.close();
			}
		}
	}

}
