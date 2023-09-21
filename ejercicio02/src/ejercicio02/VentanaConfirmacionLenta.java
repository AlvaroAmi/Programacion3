package ejercicio02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/** Ejercicio de hilos con ventanas. Programa esta clase para que se cree una ventana
 * que pida un dato de texto al usuario y un botón de confirmar para que se confirme.
 * Haz que al pulsar el botón de confirmación se llame al procesoConfirmar()
 * que simula un proceso de almacenamiento externo que tarda unos segundos.
 * Observa que hasta que ocurre esta confirmación la ventana no responde.
 * 1. Arréglalo para que la ventana no se quede "frita" hasta que se acabe de confirmar.
 * 2. Haz que el botón de "confirmar" no se pueda pulsar dos veces mientras el proceso
 * de confirmación se esté realizando
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */

public class VentanaConfirmacionLenta extends JFrame {
	protected JPanel panel;
	protected JButton confirmar;
	protected JTextArea texto;
		
	public JButton getConfirmar() {
		return confirmar;}

	public VentanaConfirmacionLenta() {
		
		this.setSize(300,300);
		this.setTitle("Introducir texto: ");
		
		panel = new JPanel();
		confirmar = new JButton("Confirmar");
		texto = new JTextArea();
		
		this.setLayout(new BorderLayout());
		this.add(confirmar,BorderLayout.SOUTH);
		this.add(texto, BorderLayout.CENTER);
		this.setVisible(true);
		
		confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				confirmar.setEnabled(false);
				procesoConfirmar(confirmar);}
			});
		
		}
	
	private static Random r = new Random();
	
	private static void procesoConfirmar(JButton confirmar) {
		
	Thread hilo = new Thread() {
		public void run() {
			try {
				System.out.println("Guardando texto...");
				Thread.sleep(5000 + 1000*r.nextInt(6));
				confirmar.setEnabled(true);
			
			}catch(Exception e){
				e.printStackTrace();
			}}};
	hilo.start();
	}
	
	public static void main(String[] args) {
		
		new VentanaConfirmacionLenta();
		
	}}
