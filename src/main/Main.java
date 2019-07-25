package main;

import java.awt.EventQueue;

import interfaces.Ventana;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana miVentana=new Ventana();
					miVentana.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
