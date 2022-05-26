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
	private ArrayList<String> contrase�as = new ArrayList<String>();
	private ArrayList<String> descuentos = new ArrayList<String>();
	
	// Mapa que almacena nombre de usuario y las dem�s caracter�sticas, para entrar
	private HashMap<String, ArrayList<String>> mapaPersonas = new HashMap<String, ArrayList<String>>();
	
	// Etiquetas y cuadros de texto de usuario y contrase�a
	private JLabel usuario;
	private JLabel contrase�a;
	private JTextField usuarioTxt;
	private JPasswordField contrase�aTxt;
	
	// Booleanos para comprobar que el usuario existe y que la contrase�a coincide con el usuario
	private boolean personaExiste = false;
	private boolean contrase�aCoincide = false;
	
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
		
		// Crear pantalla, icono, t�tulo, tama�o, localizaci�n y disposici�n principal
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
		* - Panel con los recuadros y etiquetas de usuario y contrase�a
		* - Panel con los botones de iniciar sesi�n y registrarse
		* - Panel de error, donde si algo falla salta un aviso
		*/
		JPanel panelDerecho = new JPanel(new GridLayout(6, 1));
		JPanel panelUsuario = new JPanel(new FlowLayout());
		JPanel panelContrase�a = new JPanel(new FlowLayout());
		JPanel panelBotones = new JPanel(new FlowLayout());
		JButton iniciarSesion = new JButton("Iniciar Sesi�n");
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
		contrase�a = new JLabel("Contrase�a:");
		panelContrase�a.add(contrase�a);
		contrase�aTxt = new JPasswordField(23);
		panelContrase�a.add(contrase�aTxt);
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
		panelDerecho.add(panelContrase�a);
		panelBotones.add(iniciarSesion);
		panelBotones.add(registrarse);
		panelDerecho.add(panelBotones);
		panelDerecho.add(error);
		add(panelDerecho);
		
		// Hacer que cuando el mensaje de error est� cierto tiempo en la pantalla, desaparezca
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
		
		// Cambiar a la pesta�a de registro al presionar este bot�n
		registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegister vr = new VentanaRegister();
				vr.setVisible(true);
				dispose();

			}
		});
		
		// Comprobar usuario y contrase�a, y si existen y coinciden pasar a la pesta�a de compra. Si no coinciden, saltar error
		iniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contrase�aFinal;
				if (mapaPersonas.containsKey(usuarioTxt.getText())) {
					personaExiste = true;
					for (Entry<String, ArrayList<String>> entrada : mapaPersonas.entrySet()) {
						if (entrada.getKey().equals(usuarioTxt.getText())) {
							contrase�aFinal = entrada.getValue().get(3);
							nombre = entrada.getValue().get(0);
							apellido = entrada.getValue().get(1);
							descuento = entrada.getValue().get(4);
							if (contrase�aFinal.equals(contrase�aTxt.getText())) {
								contrase�aCoincide = true;
							}
						}
					}
				}
				if (personaExiste && contrase�aCoincide) {
					VentanaCompra vc = new VentanaCompra(nombre, apellido, descuento);
					vc.setVisible(true);
					dispose();
				} else {
					error.setText("   Usuario o contrase�a incorrectos. Pruebe otra vez o registrese.");
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
				contrase�as.add(campos[4]);
				descuentos.add(campos[5]);
				linea = br.readLine();
				for (int i = 0; i < nombresUsuario.size(); i++) {
					ArrayList<String> lista = new ArrayList<String>();
					lista.add(nombres.get(i));
					lista.add(apellidos.get(i));
					lista.add(correos.get(i));
					lista.add(contrase�as.get(i));
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
