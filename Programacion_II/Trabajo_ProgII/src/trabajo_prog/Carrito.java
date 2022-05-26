package trabajo_prog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Carrito extends JFrame {

	private double total;
	private int contador1T;
	private int contador2T;
	private int contador3T;
	private int contador4T;
	private int contador5T;
	private int contador6T;
	private int contador7T;
	private int contador8T;
	private int contador9T;
	private int contador0T;
	private ArrayList<Integer> contadores = new ArrayList<Integer>();
	public int cont = 0;

	private double precio1 = 791;
	private double precio2 = 13.45;
	private double precio3 = 8.99;
	private double precio4 = 24.25;
	private double precio5 = 25.00;
	private double precio6 = 10.00;
	private double precio7 = 351.00;
	private double precio8 = 69.69;
	private double precio9 = 814.00;
	private double precio0 = 219.00;

	protected String nombre, apellido;

	public Carrito(double total, int contador1T, int contador2T, int contador3T, int contador4T, int contador5T,
			int contador6T, int contador7T, int contador8T, int contador9T, int contador0T, String nombre,
			String apellido) {
		super();
		this.total = total;
		this.contador1T = contador1T;
		this.contador2T = contador2T;
		this.contador3T = contador3T;
		this.contador4T = contador4T;
		this.contador5T = contador5T;
		this.contador6T = contador6T;
		this.contador7T = contador7T;
		this.contador8T = contador8T;
		this.contador9T = contador9T;
		this.contador0T = contador0T;
		this.nombre = nombre;
		this.apellido = apellido;
		contadores.add(contador1T);
		contadores.add(contador2T);
		contadores.add(contador3T);
		contadores.add(contador4T);
		contadores.add(contador5T);
		contadores.add(contador6T);
		contadores.add(contador7T);
		contadores.add(contador8T);
		contadores.add(contador9T);
		contadores.add(contador0T);
		inicializar();
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getContador1T() {
		return contador1T;
	}

	public int getContador2T() {
		return contador2T;
	}

	public int getContador3T() {
		return contador3T;
	}

	public int getContador4T() {
		return contador4T;
	}

	public int getContador5T() {
		return contador5T;
	}

	public int getContador6T() {
		return contador6T;
	}

	public int getContador7T() {
		return contador7T;
	}

	public int getContador8T() {
		return contador8T;
	}

	public int getContador9T() {
		return contador9T;
	}

	public int getContador0T() {
		return contador0T;
	}

	public ArrayList<Integer> getContadores() {
		return contadores;
	}

	public void setContador1T(int contador1t) {
		contador1T = contador1t;
	}

	public void setContador2T(int contador2t) {
		contador2T = contador2t;
	}

	public void setContador3T(int contador3t) {
		contador3T = contador3t;
	}

	public void setContador4T(int contador4t) {
		contador4T = contador4t;
	}

	public void setContador5T(int contador5t) {
		contador5T = contador5t;
	}

	public void setContador6T(int contador6t) {
		contador6T = contador6t;
	}

	public void setContador7T(int contador7t) {
		contador7T = contador7t;
	}

	public void setContador8T(int contador8t) {
		contador8T = contador8t;
	}

	public void setContador9T(int contador9t) {
		contador9T = contador9t;
	}

	public void setContador0T(int contador0t) {
		contador0T = contador0t;
	}

	public void setContadores(ArrayList<Integer> contadores) {
		this.contadores = contadores;
	}

	private void inicializar() {
		
		// Crear pantalla, icono, título, tamaño, localización y disposición principal
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/graphics/amazon.png");
		setIconImage(icono);
		setTitle("Amazon");
		setSize(800, 500);
		setLocation(200, 100);
		this.setLayout(new BorderLayout());

		// Panel norte
		JPanel panelNorte = new JPanel(new GridLayout(1, 3));
		JLabel zona = new JLabel("   ZONA DE PAGO");
		zona.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		zona.setForeground(Color.DARK_GRAY);
		JButton botonVuelta = new JButton(new ImageIcon("src/graphics/atras.png"));

		panelNorte.add(botonVuelta);
		panelNorte.add(new JLabel(new ImageIcon("src/graphics/amazonfinal.jpg")));
		panelNorte.add(zona);

		// Panel sur
		JPanel panelSur = new JPanel(new GridLayout(1, 3));
		JLabel precio = new JLabel("   Total: " + getTotal() + " €");
		JButton pago = new JButton("Pago", new ImageIcon("src/graphics/pago.png"));
		pago.setBackground(Color.pink);
		panelSur.add(precio);
		JLabel mensajeFinal = new JLabel("");
		mensajeFinal.setForeground(new Color(255, 0, 255));
		panelSur.add(mensajeFinal);
		panelSur.add(pago);

		// Panel centro
		JPanel panelCentro = new JPanel(new GridLayout(1, 2));
		JPanel panelIzquierda = new JPanel(new GridLayout(contarProductos(), 1));
		
		/* Espacio donde se enseñan:
		 * - Unidades de producto a comprar
		 * - Nombre del producto
		 * - Precio total de ese producto 
		 */
		if (contador1T != 0) {
			JLabel lab1I = new JLabel(
					"   " + contador1T + "x Iphone13 256GB\t\t" + "    " + contador1T * precio1 + " €");
			lab1I.setFont(new Font("Arial", Font.BOLD, 20));
			panelIzquierda.add(lab1I);
		}
		if (contador2T != 0) {
			JLabel lab2I = new JLabel("   " + contador2T + "x Linterna\t\t" + "    " + contador2T * precio2 + " €");
			lab2I.setFont(new Font("Arial", Font.BOLD, 20));
			panelIzquierda.add(lab2I);
		}
		if (contador3T != 0) {
			JLabel lab3I = new JLabel("   " + contador3T + "x Zippo\t\t" + "    " + contador3T * precio3 + " €");
			lab3I.setFont(new Font("Arial", Font.BOLD, 20));
			panelIzquierda.add(lab3I);
		}
		if (contador4T != 0) {
			JLabel lab4I = new JLabel(
					"   " + contador4T + "x Ratón Logitech\t\t" + "    " + contador4T * precio4 + " €");
			lab4I.setFont(new Font("Arial", Font.BOLD, 20));
			panelIzquierda.add(lab4I);
		}
		if (contador5T != 0) {
			JLabel lab5I = new JLabel(
					"   " + contador5T + "x Auriculares Inalámbricos\t\t" + "    " + contador5T * precio5 + " €");
			lab5I.setFont(new Font("Arial", Font.BOLD, 20));
			panelIzquierda.add(lab5I);
		}
		if (contador6T != 0) {
			JLabel lab6I = new JLabel(
					"   " + contador6T + "x Bandera España\t\t" + "    " + contador6T * precio6 + " €");
			lab6I.setFont(new Font("Arial", Font.BOLD, 20));
			panelIzquierda.add(lab6I);
		}
		if (contador7T != 0) {
			JLabel lab7I = new JLabel(
					"   " + contador7T + "x Patinete Eléctrico Xiaomi\t\t" + "    " + contador7T * precio7 + " €");
			lab7I.setFont(new Font("Arial", Font.BOLD, 20));
			panelIzquierda.add(lab7I);
		}
		if (contador8T != 0) {
			JLabel lab8I = new JLabel(
					"   " + contador8T + "x Teclado Mars Gaming\t\t" + "    " + contador8T * precio8 + " €");
			lab8I.setFont(new Font("Arial", Font.BOLD, 20));
			panelIzquierda.add(lab8I);
		}
		if (contador9T != 0) {
			JLabel lab9I = new JLabel(
					"   " + contador9T + "x Television 4K HD 65 pulgadas\t\t" + "    " + contador9T * precio9 + " €");
			lab9I.setFont(new Font("Arial", Font.BOLD, 20));
			panelIzquierda.add(lab9I);
		}
		if (contador0T != 0) {
			JLabel lab0I = new JLabel(
					"   " + contador0T + "x Reloj Garmin 245 Forerunner Music" + "    " + contador0T * precio0 + " €");
			lab0I.setFont(new Font("Arial", Font.BOLD, 20));
			panelIzquierda.add(lab0I);
		}

		panelCentro.add(panelIzquierda);


		this.add(panelNorte, BorderLayout.NORTH);
		this.add(panelSur, BorderLayout.SOUTH);
		this.add(panelCentro);

		// Botón para volver a la pestaña de compra, sin olvidar datos anteriores
		botonVuelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCompra vc = new VentanaCompra(contador1T, contador2T, contador3T, contador4T, contador5T,
						contador6T, contador7T, contador8T, contador9T, contador0T, nombre, apellido);
				vc.setVisible(true);
				dispose();
			}
		});

		// Botón para cuando se haya terminado
		pago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajeFinal.setText("¡GRACIAS POR SU COMPRA! :)");
			}
		});

		// Cuando se presiona la x, se cierra la ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Función para contar cantidad de productos a comprar, y en función a eso adaptar el tamaño de la pantalla
	public int contarProductos() {
		for (int contador : contadores) {
			if (contador != 0) {
				cont++;
			}
		}
		return cont;
	}
}
