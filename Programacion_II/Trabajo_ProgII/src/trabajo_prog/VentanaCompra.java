package trabajo_prog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.Timer;

public class VentanaCompra extends JFrame implements ActionListener {

	// Contador de cada producto cada vez que abramos la ventana
	private int contador1 = 0;
	private int contador2 = 0;
	private int contador3 = 0;
	private int contador4 = 0;
	private int contador5 = 0;
	private int contador6 = 0;
	private int contador7 = 0;
	private int contador8 = 0;
	private int contador9 = 0;
	private int contador0 = 0;

	// Contador de cada producto total 
	private int contador1T = 0;
	private int contador2T = 0;
	private int contador3T = 0;
	private int contador4T = 0;
	private int contador5T = 0;
	private int contador6T = 0;
	private int contador7T = 0;
	private int contador8T = 0;
	private int contador9T = 0;
	private int contador0T = 0;

	// Precio de cada producto
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

	// Nombre, apellido y condición del usuario
	protected String nombre;
	protected String apellido;
	protected String descuento;

	// Precio total de la compra
	public double precioTotal = 0;

	// Constructor para pasar los valores a la pestaña carrito
	public VentanaCompra(int contador1T, int contador2T, int contador3T, int contador4T, int contador5T, int contador6T,
			int contador7T, int contador8T, int contador9T, int contador0T, String nombre, String apellido) {
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
		inicializar();
	}

	// Constructor para recibir nombre y apellidos de la pestaña registro
	public VentanaCompra(String nombre, String apellido, String descuento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.descuento = descuento;
		inicializar();
	}

	private void inicializar() {
		
		if(descuento.equals("estudiante")) {
			precio1 *= 0.5;
			precio2 *= 0.5;
			precio3 *= 0.5;
			precio4 *= 0.5;
			precio5 *= 0.5;
			precio6 *= 0.5;
			precio7 *= 0.5;
			precio8 *= 0.5;
			precio9 *= 0.5;
			precio0 *= 0.5;
		}else if(descuento.equals("jubilado")) {
			precio1 *= 0.25;
			precio2 *= 0.25;
			precio3 *= 0.25;
			precio4 *= 0.25;
			precio5 *= 0.25;
			precio6 *= 0.25;
			precio7 *= 0.25;
			precio8 *= 0.25;
			precio9 *= 0.25;
			precio0 *= 0.25;
		}
		// Crear pantalla, icono, título, tamaño, localización y disposición principal
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Image icono = pantalla.getImage("src/graphics/amazon.png");
		setIconImage(icono);
		setTitle("Amazon");
		setSize(800, 500);
		setLocation(200, 100);
		this.setLayout(new BorderLayout());

		// Panel superior con imagenes y nombre del cliente
		JPanel panelSuperior = new JPanel(new GridLayout(1, 3));
		JLabel titulo = new JLabel("     Área de compra");
		titulo.setFont(new Font("Serif", Font.BOLD, 25));
		titulo.setForeground(Color.RED);
		panelSuperior.add(titulo);
		JLabel id = new JLabel(nombre + " " + apellido);
		id.setFont(new Font("Arial", Font.BOLD, 30));
		id.setForeground(Color.GREEN);
		panelSuperior.add(id);
		JButton botonCarrito = new JButton(new ImageIcon("src/graphics/carrito.png"));
		botonCarrito.setPreferredSize(new Dimension(150, 40));
		panelSuperior.add(botonCarrito);
		this.add(panelSuperior, BorderLayout.NORTH);

		// Panel donde se encuentran nuestros objetos
		JPanel panelObjetos = new JPanel(new GridLayout(5, 2));

		/* Cada producto cuenta con:
		 * - Etiqueta con la cantidad de productos seleccionada
		 * - Boton para incrementar o disminuir cantidad
		 * - Boton para añadir
		 * - Espacio donde se alerta cuando se ha introducido el producto
		 */
		// Producto1
		JPanel producto1 = new JPanel(new GridLayout(1, 2));
		JLabel imagen1 = new JLabel(new ImageIcon("src/graphics/iphone13.jpg"));
		producto1.add(imagen1);
		JPanel producto1Der = new JPanel(new GridLayout(4, 1));
		producto1Der.add(new JLabel(precio1 + " €"));
		JLabel cantidad1 = new JLabel(contador1 + "");
		JPanel cantidad1P = new JPanel();
		cantidad1P.add(cantidad1);
		cantidad1.setLocation(50, 50);
		producto1Der.add(cantidad1P);
		JPanel producto1Botones = new JPanel(new GridLayout(1, 3));
		JButton decrementar1 = new JButton("-");
		JButton incrementar1 = new JButton("+");
		producto1Botones.add(decrementar1);
		JLabel mensaje1 = new JLabel("");
		mensaje1.setFont(new Font("Arial", Font.BOLD, 12));
		mensaje1.setForeground(Color.GREEN);
		producto1Botones.add(mensaje1);
		producto1Botones.add(incrementar1);
		producto1Der.add(producto1Botones);
		JPanel añadir1 = new JPanel(new GridLayout(1, 3));
		JButton añadir1B = new JButton("Añadir");
		añadir1B.setFont(new Font("Arial", Font.PLAIN, 10));
		añadir1.add(new JLabel(""));
		añadir1.add(añadir1B);
		añadir1.add(new JLabel(""));
		producto1Der.add(añadir1);
		producto1.add(producto1Der);
		panelObjetos.add(producto1);
		incrementar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador1++;
				cantidad1.setText(contador1 + "");
			}
		});
		decrementar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador1 == 0) {
					contador1 = 0;
				} else {
					contador1--;
				}
				cantidad1.setText(contador1 + "");
			}
		});
		añadir1B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador1T += contador1;
				contador1 = 0;
				cantidad1.setText(contador1 + "");
				mensaje1.setText("  Añadido");
				ActionListener desaparecer = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mensaje1.setText("");
					}
				};
				Timer tiempo1 = new Timer(2000, desaparecer);
				tiempo1.start();
			}
		});

		// Producto 2
		JPanel producto2 = new JPanel(new GridLayout(1, 2));
		JLabel imagen2 = new JLabel(new ImageIcon("src/graphics/linterna.jpg"));
		producto2.add(imagen2);
		JPanel producto2Der = new JPanel(new GridLayout(4, 1));
		producto2Der.add(new JLabel(precio2 + " €"));
		JLabel cantidad2 = new JLabel("0");
		JPanel cantidad2P = new JPanel();
		cantidad2P.add(cantidad2);
		cantidad2.setLocation(50, 50);
		producto2Der.add(cantidad2P);
		JPanel producto2Botones = new JPanel(new GridLayout(1, 3));
		JButton decrementar2 = new JButton("-");
		JButton incrementar2 = new JButton("+");
		producto2Botones.add(decrementar2);
		JLabel mensaje2 = new JLabel("");
		mensaje2.setFont(new Font("Arial", Font.BOLD, 12));
		mensaje2.setForeground(Color.GREEN);
		producto2Botones.add(mensaje2);
		producto2Botones.add(incrementar2);
		producto2Der.add(producto2Botones);
		JPanel añadir2 = new JPanel(new GridLayout(1, 3));
		JButton añadir2B = new JButton("Añadir");
		añadir2B.setFont(new Font("Arial", Font.PLAIN, 10));
		añadir2.add(new JLabel(""));
		añadir2.add(añadir2B);
		añadir2.add(new JLabel(""));
		producto2Der.add(añadir2);
		producto2.add(producto2Der);
		panelObjetos.add(producto2);
		incrementar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador2++;
				cantidad2.setText(contador2 + "");
			}
		});
		decrementar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador2 == 0) {
					contador2 = 0;
				} else {
					contador2--;
				}
				cantidad2.setText(contador2 + "");
			}
		});
		añadir2B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador2T += contador2;
				contador2 = 0;
				cantidad2.setText(contador2 + "");
				mensaje2.setText("   Añadido");
				ActionListener desaparecer = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mensaje2.setText("");
					}
				};
				Timer tiempo2 = new Timer(2000, desaparecer);
				tiempo2.start();
			}
		});

		// Producto 3
		JPanel producto3 = new JPanel(new GridLayout(1, 2));
		JLabel imagen3 = new JLabel(new ImageIcon("src/graphics/zippo.jpg"));
		producto3.add(imagen3);
		JPanel producto3Der = new JPanel(new GridLayout(4, 1));
		producto3Der.add(new JLabel(precio3 + " €"));
		JLabel cantidad3 = new JLabel("0");
		JPanel cantidad3P = new JPanel();
		cantidad3P.add(cantidad3);
		cantidad3.setLocation(50, 50);
		producto3Der.add(cantidad3P);
		JPanel producto3Botones = new JPanel(new GridLayout(1, 3));
		JButton decrementar3 = new JButton("-");
		JButton incrementar3 = new JButton("+");
		producto3Botones.add(decrementar3);
		JLabel mensaje3 = new JLabel("");
		mensaje3.setFont(new Font("Arial", Font.BOLD, 12));
		mensaje3.setForeground(Color.GREEN);
		producto3Botones.add(mensaje3);
		producto3Botones.add(incrementar3);
		producto3Der.add(producto3Botones);
		JPanel añadir3 = new JPanel(new GridLayout(1, 3));
		JButton añadir3B = new JButton("Añadir");
		añadir3B.setFont(new Font("Arial", Font.PLAIN, 10));
		añadir3.add(new JLabel(""));
		añadir3.add(añadir3B);
		añadir3.add(new JLabel(""));
		producto3Der.add(añadir3);
		producto3.add(producto3Der);
		panelObjetos.add(producto3);
		incrementar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador3++;
				cantidad3.setText(contador3 + "");
			}
		});
		decrementar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador3 == 0) {
					contador3 = 0;
				} else {
					contador3--;
				}
				cantidad3.setText(contador3 + "");
			}
		});
		añadir3B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador3T += contador3;
				contador3 = 0;
				cantidad3.setText(contador3 + "");
				mensaje3.setText("  Añadido");
				ActionListener desaparecer = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mensaje3.setText("");
					}
				};
				Timer tiempo3 = new Timer(2000, desaparecer);
				tiempo3.start();
			}
		});

		// Producto 4
		JPanel producto4 = new JPanel(new GridLayout(1, 2));
		JLabel imagen4 = new JLabel(new ImageIcon("src/graphics/raton.jpg"));
		producto4.add(imagen4);
		JPanel producto4Der = new JPanel(new GridLayout(4, 1));
		producto4Der.add(new JLabel(precio4 + " €"));
		JLabel cantidad4 = new JLabel("0");
		JPanel cantidad4P = new JPanel();
		cantidad4P.add(cantidad4);
		cantidad4.setLocation(50, 50);
		producto4Der.add(cantidad4P);
		JPanel producto4Botones = new JPanel(new GridLayout(1, 3));
		JButton decrementar4 = new JButton("-");
		JButton incrementar4 = new JButton("+");
		producto4Botones.add(decrementar4);
		JLabel mensaje4 = new JLabel("");
		mensaje4.setFont(new Font("Arial", Font.BOLD, 12));
		mensaje4.setForeground(Color.GREEN);
		producto4Botones.add(mensaje4);
		producto4Botones.add(incrementar4);
		producto4Der.add(producto4Botones);
		JPanel añadir4 = new JPanel(new GridLayout(1, 3));
		JButton añadir4B = new JButton("Añadir");
		añadir4B.setFont(new Font("Arial", Font.PLAIN, 10));
		añadir4.add(new JLabel(""));
		añadir4.add(añadir4B);
		añadir4.add(new JLabel(""));
		producto4Der.add(añadir4);
		producto4.add(producto4Der);
		panelObjetos.add(producto4);
		incrementar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador4++;
				cantidad4.setText(contador4 + "");
			}
		});
		decrementar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador4 == 0) {
					contador4 = 0;
				} else {
					contador4--;
				}
				cantidad4.setText(contador4 + "");
			}
		});
		añadir4B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador4T += contador4;
				contador4 = 0;
				cantidad4.setText(contador4 + "");
				mensaje4.setText("  Añadido");
				ActionListener desaparecer = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mensaje4.setText("");
					}
				};
				Timer tiempo4 = new Timer(2000, desaparecer);
				tiempo4.start();
			}
		});

		// Producto 5
		JPanel producto5 = new JPanel(new GridLayout(1, 2));
		JLabel imagen5 = new JLabel(new ImageIcon("src/graphics/cascos.jpg"));
		producto5.add(imagen5);
		JPanel producto5Der = new JPanel(new GridLayout(4, 1));
		producto5Der.add(new JLabel(precio5 + " €"));
		JLabel cantidad5 = new JLabel("0");
		JPanel cantidad5P = new JPanel();
		cantidad5P.add(cantidad5);
		cantidad5.setLocation(50, 50);
		producto5Der.add(cantidad5P);
		JPanel producto5Botones = new JPanel(new GridLayout(1, 3));
		JButton decrementar5 = new JButton("-");
		JButton incrementar5 = new JButton("+");
		producto5Botones.add(decrementar5);
		JLabel mensaje5 = new JLabel("");
		mensaje5.setFont(new Font("Arial", Font.BOLD, 12));
		mensaje5.setForeground(Color.GREEN);
		producto5Botones.add(mensaje5);
		producto5Botones.add(incrementar5);
		producto5Der.add(producto5Botones);
		JPanel añadir5 = new JPanel(new GridLayout(1, 3));
		JButton añadir5B = new JButton("Añadir");
		añadir5B.setFont(new Font("Arial", Font.PLAIN, 10));
		añadir5.add(new JLabel(""));
		añadir5.add(añadir5B);
		añadir5.add(new JLabel(""));
		producto5Der.add(añadir5);
		producto5.add(producto5Der);
		panelObjetos.add(producto5);
		incrementar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador5++;
				cantidad5.setText(contador5 + "");
			}
		});
		decrementar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador5 == 0) {
					contador5 = 0;
				} else {
					contador5--;
				}
				cantidad5.setText(contador5 + "");
			}
		});
		añadir5B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador5T += contador5;
				contador5 = 0;
				cantidad5.setText(contador5 + "");
				mensaje5.setText("  Añadido");
				ActionListener desaparecer = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mensaje5.setText("");
					}
				};
				Timer tiempo5 = new Timer(2000, desaparecer);
				tiempo5.start();
			}
		});

		// Producto 6
		JPanel producto6 = new JPanel(new GridLayout(1, 2));
		JLabel imagen6 = new JLabel(new ImageIcon("src/graphics/españita.jpg"));
		producto6.add(imagen6);
		JPanel producto6Der = new JPanel(new GridLayout(4, 1));
		producto6Der.add(new JLabel(precio6 + " €"));
		JLabel cantidad6 = new JLabel("0");
		JPanel cantidad6P = new JPanel();
		cantidad6P.add(cantidad6);
		cantidad6.setLocation(50, 50);
		producto6Der.add(cantidad6P);
		JPanel producto6Botones = new JPanel(new GridLayout(1, 3));
		JButton decrementar6 = new JButton("-");
		JButton incrementar6 = new JButton("+");
		producto6Botones.add(decrementar6);
		JLabel mensaje6 = new JLabel("");
		mensaje6.setFont(new Font("Arial", Font.BOLD, 12));
		mensaje6.setForeground(Color.GREEN);
		producto6Botones.add(mensaje6);
		producto6Botones.add(incrementar6);
		producto6Der.add(producto6Botones);
		JPanel añadir6 = new JPanel(new GridLayout(1, 3));
		JButton añadir6B = new JButton("Añadir");
		añadir6B.setFont(new Font("Arial", Font.PLAIN, 10));
		añadir6.add(new JLabel(""));
		añadir6.add(añadir6B);
		añadir6.add(new JLabel(""));
		producto6Der.add(añadir6);
		producto6.add(producto6Der);
		panelObjetos.add(producto6);
		incrementar6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador6++;
				cantidad6.setText(contador6 + "");
			}
		});
		decrementar6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador6 == 0) {
					contador6 = 0;
				} else {
					contador6--;
				}
				cantidad6.setText(contador6 + "");
			}
		});
		añadir6B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador6T += contador6;
				contador6 = 0;
				cantidad6.setText(contador6 + "");
				mensaje6.setText("   Añadido");
				ActionListener desaparecer = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mensaje6.setText("");
					}
				};
				Timer tiempo6 = new Timer(2000, desaparecer);
				tiempo6.start();
			}
		});

		// Producto 7
		JPanel producto7 = new JPanel(new GridLayout(1, 2));
		JLabel imagen7 = new JLabel(new ImageIcon("src/graphics/patinete.jpg"));
		producto7.add(imagen7);
		JPanel producto7Der = new JPanel(new GridLayout(4, 1));
		producto7Der.add(new JLabel(precio7 + " €"));
		JLabel cantidad7 = new JLabel("0");
		JPanel cantidad7P = new JPanel();
		cantidad7P.add(cantidad7);
		cantidad7.setLocation(50, 50);
		producto7Der.add(cantidad7P);
		JPanel producto7Botones = new JPanel(new GridLayout(1, 3));
		JButton decrementar7 = new JButton("-");
		JButton incrementar7 = new JButton("+");
		producto7Botones.add(decrementar7);
		JLabel mensaje7 = new JLabel("");
		mensaje7.setFont(new Font("Arial", Font.BOLD, 12));
		mensaje7.setForeground(Color.GREEN);
		producto7Botones.add(mensaje7);
		producto7Botones.add(incrementar7);
		producto7Der.add(producto7Botones);
		JPanel añadir7 = new JPanel(new GridLayout(1, 3));
		JButton añadir7B = new JButton("Añadir");
		añadir7B.setFont(new Font("Arial", Font.PLAIN, 10));
		añadir7.add(new JLabel(""));
		añadir7.add(añadir7B);
		añadir7.add(new JLabel(""));
		producto7Der.add(añadir7);
		producto7.add(producto7Der);
		panelObjetos.add(producto7);
		incrementar7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador7++;
				cantidad7.setText(contador7 + "");
			}
		});
		decrementar7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador7 == 0) {
					contador7 = 0;
				} else {
					contador7--;
				}
				cantidad7.setText(contador7 + "");
			}
		});
		añadir7B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador7T += contador7;
				contador7 = 0;
				cantidad7.setText(contador7 + "");
				mensaje7.setText("  Añadido");
				ActionListener desaparecer = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mensaje7.setText("");
					}
				};
				Timer tiempo7 = new Timer(2000, desaparecer);
				tiempo7.start();
			}
		});

		// Producto 8
		JPanel producto8 = new JPanel(new GridLayout(1, 2));
		JLabel imagen8 = new JLabel(new ImageIcon("src/graphics/teclado.jpg"));
		producto8.add(imagen8);
		JPanel producto8Der = new JPanel(new GridLayout(4, 1));
		producto8Der.add(new JLabel(precio8 + " €"));
		JLabel cantidad8 = new JLabel("0");
		JPanel cantidad8P = new JPanel();
		cantidad8P.add(cantidad8);
		cantidad8.setLocation(50, 50);
		producto8Der.add(cantidad8P);
		JPanel producto8Botones = new JPanel(new GridLayout(1, 3));
		JButton decrementar8 = new JButton("-");
		JButton incrementar8 = new JButton("+");
		producto8Botones.add(decrementar8);
		JLabel mensaje8 = new JLabel("");
		mensaje8.setFont(new Font("Arial", Font.BOLD, 12));
		mensaje8.setForeground(Color.GREEN);
		producto8Botones.add(mensaje8);
		producto8Botones.add(incrementar8);
		producto8Der.add(producto8Botones);
		JPanel añadir8 = new JPanel(new GridLayout(1, 3));
		JButton añadir8B = new JButton("Añadir");
		añadir8B.setFont(new Font("Arial", Font.PLAIN, 10));
		añadir8.add(new JLabel(""));
		añadir8.add(añadir8B);
		añadir8.add(new JLabel(""));
		producto8Der.add(añadir8);
		producto8.add(producto8Der);
		panelObjetos.add(producto8);
		incrementar8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador8++;
				cantidad8.setText(contador8 + "");
			}
		});
		decrementar8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador8 == 0) {
					contador8 = 0;
				} else {
					contador8--;
				}
				cantidad8.setText(contador8 + "");
			}
		});
		añadir8B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador8T += contador8;
				contador8 = 0;
				cantidad8.setText(contador8 + "");
				mensaje8.setText("  Añadido");
				ActionListener desaparecer = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mensaje8.setText("");
					}
				};
				Timer tiempo8 = new Timer(2000, desaparecer);
				tiempo8.start();
			}
		});

		// Producto 9
		JPanel producto9 = new JPanel(new GridLayout(1, 2));
		JLabel imagen9 = new JLabel(new ImageIcon("src/graphics/tele.jpg"));
		producto9.add(imagen9);
		JPanel producto9Der = new JPanel(new GridLayout(4, 1));
		producto9Der.add(new JLabel(precio9 + " €"));
		JLabel cantidad9 = new JLabel("0");
		JPanel cantidad9P = new JPanel();
		cantidad9P.add(cantidad9);
		cantidad9.setLocation(50, 50);
		producto9Der.add(cantidad9P);
		JPanel producto9Botones = new JPanel(new GridLayout(1, 3));
		JButton decrementar9 = new JButton("-");
		JButton incrementar9 = new JButton("+");
		producto9Botones.add(decrementar9);
		JLabel mensaje9 = new JLabel("");
		mensaje9.setFont(new Font("Arial", Font.BOLD, 12));
		mensaje9.setForeground(Color.GREEN);
		producto9Botones.add(mensaje9);
		producto9Botones.add(incrementar9);
		producto9Der.add(producto9Botones);
		JPanel añadir9 = new JPanel(new GridLayout(1, 3));
		JButton añadir9B = new JButton("Añadir");
		añadir9B.setFont(new Font("Arial", Font.PLAIN, 10));
		añadir9.add(new JLabel(""));
		añadir9.add(añadir9B);
		añadir9.add(new JLabel(""));
		producto9Der.add(añadir9);
		producto9.add(producto9Der);
		panelObjetos.add(producto9);
		incrementar9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador9++;
				cantidad9.setText(contador9 + "");
			}
		});
		decrementar9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador9 == 0) {
					contador9 = 0;
				} else {
					contador9--;
				}
				cantidad9.setText(contador9 + "");
			}
		});
		añadir9B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador9T += contador9;
				contador9 = 0;
				cantidad9.setText(contador9 + "");
				mensaje9.setText("  Añadido");
				ActionListener desaparecer = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mensaje9.setText("");
					}
				};
				Timer tiempo9 = new Timer(2000, desaparecer);
				tiempo9.start();
			}
		});

		// Producto 0
		JPanel producto0 = new JPanel(new GridLayout(1, 2));
		JLabel imagen0 = new JLabel(new ImageIcon("src/graphics/reloj.jpg"));
		producto0.add(imagen0);
		JPanel producto0Der = new JPanel(new GridLayout(4, 1));
		producto0Der.add(new JLabel(precio0 + " €"));
		JLabel cantidad0 = new JLabel("0");
		JPanel cantidad0P = new JPanel();
		cantidad0P.add(cantidad0);
		cantidad0.setLocation(50, 50);
		producto0Der.add(cantidad0P);
		JPanel producto0Botones = new JPanel(new GridLayout(1, 3));
		JButton decrementar0 = new JButton("-");
		JButton incrementar0 = new JButton("+");
		producto0Botones.add(decrementar0);
		JLabel mensaje0 = new JLabel("");
		mensaje0.setFont(new Font("Arial", Font.BOLD, 12));
		mensaje0.setForeground(Color.GREEN);
		producto0Botones.add(mensaje0);
		producto0Botones.add(incrementar0);
		producto0Der.add(producto0Botones);
		JPanel añadir0 = new JPanel(new GridLayout(1, 3));
		JButton añadir0B = new JButton("Añadir");
		añadir0B.setFont(new Font("Arial", Font.PLAIN, 10));
		añadir0.add(new JLabel(""));
		añadir0.add(añadir0B);
		añadir0.add(new JLabel(""));
		producto0Der.add(añadir0);
		producto0.add(producto0Der);
		panelObjetos.add(producto0);
		incrementar0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador0++;
				cantidad0.setText(contador0 + "");
			}
		});
		decrementar0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador0 == 0) {
					contador0 = 0;
				} else {
					contador0--;
				}
				cantidad0.setText(contador0 + "");
			}
		});
		añadir0B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador0T += contador0;
				contador0 = 0;
				cantidad0.setText(contador0 + "");
				mensaje0.setText("  Añadido");
				ActionListener desaparecer = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mensaje0.setText("");
					}
				};
				Timer tiempo0 = new Timer(2000, desaparecer);
				tiempo0.start();
			}
		});

		this.add(panelObjetos);
		
		// Cuando se presiona la x, se cierra la ventana
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Boton para pasar a la pestaña carrito junto con los contadores
		botonCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carrito c = new Carrito(contarTotal(), contador1T, contador2T, contador3T, contador4T, contador5T,
						contador6T, contador7T, contador8T, contador9T, contador0T, nombre, apellido);
				c.setVisible(true);
				dispose();

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	// Para contar el total de la compra
	public double contarTotal() {
		precioTotal += contador1T * precio1 + contador2T * precio2 + contador3T * precio3 + contador4T * precio4
				+ contador5T * precio5 + contador6T * precio6 + contador7T * precio7 + contador8T * precio8
				+ contador9T * precio9 + contador0T * precio0;
		return precioTotal;
	}

}
