package practica0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.AffineTransform;

import javax.swing.*;

public class VentanaJuego extends JFrame{
	protected JPanel panelblanco;
	protected JPanel panelbotones;
	protected JButton acelerar;
	protected JButton frenar;
	protected JButton izq;
	protected JButton dcha;
	protected CocheJuego coche = new CocheJuego();
	
	public CocheJuego getCoche() {
		return coche;	
	}

	public VentanaJuego() {
		this.setSize(600,600);
		this.setTitle("Practica 0, Alvaro Amilibia");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		panelblanco = new JPanel();
		panelblanco.setLayout(null);
		panelbotones = new JPanel();
		acelerar = new JButton("Acelerar");
		frenar = new JButton("Frenar");
		izq = new JButton("Girar Izq.");
		dcha = new JButton("Girar Der.");
		
		panelbotones.setLayout(new FlowLayout());
		panelbotones.setBackground(new Color(204, 204, 204));
		panelbotones.add(acelerar);
		panelbotones.add(frenar);
		panelbotones.add(izq);
		panelbotones.add(dcha);
	    panelblanco.add(coche.getLabelcoche());
	    
	    this.add(panelblanco, BorderLayout.CENTER);
		this.add(panelbotones, BorderLayout.SOUTH);
		
		acelerar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(5);
				System.out.println(coche.toString());	
			}});
		
		frenar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(-5);
				System.out.println(coche.toString());
			}});
		
		izq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(-10); //10 o -10?
				System.out.println(coche.toString());
			}});
		
		dcha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(10);
				System.out.println(coche.toString());
				
			}});
		
		this.setVisible(true);
	}
	
	

	public static void main(String[] args) {
       
	   VentanaJuego ventana = new VentanaJuego();
       boolean seguir[] = {true};

       Thread miHilo = new Thread() {
    	   public void run() {
    		   while(seguir[0]) {
    			  ventana.getCoche().mueve(0.4); 
    			  ventana.getCoche().getLabelcoche().getDireccion((int) ventana.getCoche().getMiDireccionActual());
    			  
    			  if ((ventana.getWidth()-80 < ventana.getCoche().getPosX()) ||(-30 > ventana.getCoche().getPosX())) {
    				  ventana.getCoche().gira(150)
    				 
    				  ;}
    			  if ((ventana.getHeight()-120 < ventana.getCoche().getPosY()) || (-30 > ventana.getCoche().getPosY()) ){
    				  ventana.getCoche().gira(150);
    			  }
    				  
    				  
    			  System.out.println(ventana.getCoche().toString());
    			   try {
    				   Thread.sleep(40);
    			   }catch(Exception e) {
    				   
    			   };
    		   }}};
             
      miHilo.start();
      
      ventana.addWindowListener(new WindowAdapter() {
    	  @Override
          public void windowClosing(WindowEvent e) {
              seguir[0] = false;}  
      });
      
     
        };
	
	
	
	
	
}
