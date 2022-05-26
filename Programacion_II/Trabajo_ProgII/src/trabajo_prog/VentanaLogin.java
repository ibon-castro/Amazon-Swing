package trabajo_prog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.*;
import javax.imageio.*;

public class VentanaLogin extends JFrame implements ActionListener {
	
	// Listas que almacenan los datos de cada usuario
	private ArrayList<String> nombres = new ArrayList<String>();
	private ArrayList<String> apellidos = new ArrayList<String>();
	private ArrayList<String> nombresUsuario = new ArrayList<String>();
	private ArrayList<String> correos = new ArrayList<String>();
	private ArrayList<String> contraseñas = new ArrayList<String>();
	private ArrayList<String> descuentos = new ArrayList<String>();
	
	// Mapa que almacena nombre de usuario y las demás características, para entrar
	private HashMap<String, ArrayList<String>> mapaPersonas = new HashMap<String, ArrayList<String>>();
	
	// Etiquetas y cuadros de texto de usuario y contraseña
	private JLabel usuario;
	private JLabel contraseña;
	private JTextField usuarioTxt;
	private JPasswordField contraseñaTxt;
	
	// Booleanos para comprobar que el usuario existe y que la contraseña coincide con el usuario
	private boolean personaExiste = false;
	private boolean contraseñaCoincide = false;
	
	// Variablse que almacenan el nombre y el apellido del usuario introducido, para que aparezcan en la siguiente pantalla
	private String nombre;
	private String apellido;
	
	// Para saber el descuento a aplicar
	private String descuento;
	
	// Constructor
	public VentanaLogin() {
		inicializarVentanaLogin();
	}

	private void inicializarVentanaLogin() {
		
		// Crear pantalla, icono, título, tamaño, localización y disposición principal
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/graphics/amazon.png");
		setIconImage(icono);
		setTitle("Amazon");
		setSize(800, 500);
		setLocation(200, 100);
		this.setLayout(new GridLayout(1, 2));

		// Imagen del margen izquierdo de la pantalla
		JLabel imagen = new JLabel(new ImageIcon("src/graphics/amazon.png"));
		this.add(imagen);

		/* Panel derecho, que contiene:
		* - Panel superior con nombre de la tienda
		* - Panel con los recuadros y etiquetas de usuario y contraseña
		* - Panel con los botones de iniciar sesión y registrarse
		* - Panel de error, donde si algo falla salta un aviso
		*/
		JPanel panelDerecho = new JPanel(new GridLayout(6, 1));
		JPanel panelUsuario = new JPanel(new FlowLayout());
		JPanel panelContraseña = new JPanel(new FlowLayout());
		JPanel panelBotones = new JPanel(new FlowLayout());
		JButton iniciarSesion = new JButton("Iniciar Sesión");
		JButton registrarse = new JButton("Registrarse");
		JPanel textoUp = new JPanel(new FlowLayout());
		JPanel textoDown = new JPanel(new FlowLayout());
		JLabel fraseUp = new JLabel("Amazon");
		JLabel fraseDown = new JLabel("Online Shop");
		JLabel error = new JLabel("");
		error.setFont(new Font("Arial", Font.PLAIN, 13));
		error.setForeground(Color.RED);
		usuario = new JLabel("Usuario:");
		panelUsuario.add(usuario);
		usuarioTxt = new JTextField(25);
		panelUsuario.add(usuarioTxt);
		contraseña = new JLabel("Contraseña:");
		panelContraseña.add(contraseña);
		contraseñaTxt = new JPasswordField(23);
		panelContraseña.add(contraseñaTxt);
		textoUp.add(fraseUp);
		fraseUp.setForeground(Color.YELLOW);
		fraseUp.setFont(new Font("Serif", Font.BOLD, 47));
		textoUp.setBackground(Color.RED);
		textoDown.add(fraseDown);
		fraseDown.setForeground(Color.YELLOW);
		fraseDown.setFont(new Font("Serif", Font.BOLD, 47));
		textoDown.setBackground(Color.RED);
		panelDerecho.add(textoUp);
		panelDerecho.add(textoDown);
		panelDerecho.add(panelUsuario);
		panelDerecho.add(panelContraseña);
		panelBotones.add(iniciarSesion);
		panelBotones.add(registrarse);
		panelDerecho.add(panelBotones);
		panelDerecho.add(error);
		add(panelDerecho);
		
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
		} catch (IOException e1) {
			e1.printStackTrace();;
		}
		
		// Cambiar a la pestaña de registro al presionar este botón
		registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegister vr = new VentanaRegister();
				vr.setVisible(true);
				dispose();

			}
		});
		
		// Comprobar usuario y contraseña, y si existen y coinciden pasar a la pestaña de compra. Si no coinciden, saltar error
		iniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contraseñaFinal;
				if (mapaPersonas.containsKey(usuarioTxt.getText())) {
					personaExiste = true;
					for (Entry<String, ArrayList<String>> entrada : mapaPersonas.entrySet()) {
						if (entrada.getKey().equals(usuarioTxt.getText())) {
							contraseñaFinal = entrada.getValue().get(3);
							nombre = entrada.getValue().get(0);
							apellido = entrada.getValue().get(1);
							descuento = entrada.getValue().get(4);
							if (contraseñaFinal.equals(contraseñaTxt.getText())) {
								contraseñaCoincide = true;
							}
						}
					}
				}
				if (personaExiste && contraseñaCoincide) {
					VentanaCompra vc = new VentanaCompra(nombre, apellido, descuento);
					vc.setVisible(true);
					dispose();
				} else {
					error.setText("   Usuario o contraseña incorrectos. Pruebe otra vez o registrese.");
					tiempo.start();
				}
			}
		});
		
		// Cuando se presiona la x, se cierra la ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	// Leer el CSV, y pasar a nuestras listas y a nuestro mapa los datos
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
				for (int i = 0; i < nombresUsuario.size(); i++) {
					ArrayList<String> lista = new ArrayList<String>();
					lista.add(nombres.get(i));
					lista.add(apellidos.get(i));
					lista.add(correos.get(i));
					lista.add(contraseñas.get(i));
					lista.add(descuentos.get(i));
					mapaPersonas.put(nombresUsuario.get(i), lista);
				}
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
