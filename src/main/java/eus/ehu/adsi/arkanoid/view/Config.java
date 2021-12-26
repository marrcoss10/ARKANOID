package eus.ehu.adsi.arkanoid.view;

import java.awt.*;
import java.io.IOException;

import eus.ehu.adsi.arkanoid.Sonido;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public abstract class Config {

	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;

	public static final double BALL_RADIUS = 10.0;
	public static final double BALL_VELOCITY = 0.2;

	public static final double PADDLE_WIDTH = 60.0;
	public static final double PADDLE_HEIGHT = 20.0;
	public static final double PADDLE_VELOCITY = 0.4;

	public static final double BLOCK_WIDTH = 60.0;
	public static final double BLOCK_HEIGHT = 20.0;

	public static final int COUNT_BLOCKS_X = 11;
	public static final int COUNT_BLOCKS_Y = 4;

	public static final int PLAYER_LIVES = 5;

	public static final double FT_SLICE = 1.0;
	public static final double FT_STEP = 1.0;

	public static final String FONT = "Courier New";
	public static final Color FONT_COLOR = Color.lightGray;

    public static Color background = Color.black;
	public static Color ball = Color.white;
	public static Color lad = Color.orange;
	public static Color pad = Color.green;

    //Recibe los parametros de personalizacion
	public static void recibirColores(String fondo, String bola, String ladrillo, String paddle, String sonido){
		//Comprobamos el color del fondo
		if(fondo.equals("Rojo")){background = Color.red;}
		else if(fondo.equals("Naranja")){background = Color.orange;}
		else if(fondo.equals("Azul")){background = Color.blue;}
		else if(fondo.equals("Amarillo")){background = Color.yellow;}
		else if(fondo.equals("Verde")){background = Color.green;}
		else if(fondo.equals("Rosa")){background = Color.pink;}
		else if(fondo.equals("Negro")){background = Color.black;}
		else if(fondo.equals("Blanco")){background = Color.white;}
		else{background = Color.black;}
        
        //Comprobamos el color de la bola
		if(bola.equals("Rojo")){ball = Color.red;}
		else if(bola.equals("Naranja")){ball = Color.orange;}
		else if(bola.equals("Azul")){ball = Color.blue;}
		else if(bola.equals("Amarillo")){ball = Color.yellow;}
		else if(bola.equals("Verde")){ball = Color.green;}
		else if(bola.equals("Rosa")){ball = Color.pink;}
		else if(bola.equals("Blanco")){ball = Color.white;}
        
        //Comprobamos el color de los ladrillos
		if(ladrillo.equals("Rojo")){lad = Color.red;}
		else if(ladrillo.equals("Naranja")){lad = Color.orange;}
		else if(ladrillo.equals("Azul")){lad = Color.blue;}
		else if(ladrillo.equals("Amarillo")){lad = Color.yellow;}
		else if(ladrillo.equals("Verde")){lad = Color.green;}
		else if(ladrillo.equals("Rosa")){lad = Color.pink;}
		else if(ladrillo.equals("Blanco")){lad = Color.white;}

        //Comprobamos el color del paddle
		if(paddle.equals("Rojo")){pad = Color.red;}
		else if(paddle.equals("Naranja")){pad = Color.orange;}
		else if(paddle.equals("Azul")){pad = Color.blue;}
		else if(paddle.equals("Amarillo")){pad = Color.yellow;}
		else if(paddle.equals("Verde")){pad = Color.green;}
		else if(paddle.equals("Rosa")){pad = Color.pink;}
		else if(paddle.equals("Blanco")){pad = Color.white;}

		//Comprobar que el fondo no es igual a algo
		if(fondo.equals(bola)){background = Color.black;}
		if(fondo.equals(ladrillo)){background = Color.black;}
		if(fondo.equals(paddle)){background = Color.black;}


        //Asignamos los colores correspondientes a cada parametro 
		BACKGROUND_COLOR = background;
		BALL_COLOR = ball;
		PADDLE_COLOR = pad;
		BRICK_COLOR = lad;

		//no elige sonido
		if(sonido.equals("Ninguno")){}
		else{ //elige sonido
			Sonido s = new Sonido();
			s.reproducir();
		}
	}
	public static Color BACKGROUND_COLOR = background;
	public static  Color BALL_COLOR = ball;
	public static  Color PADDLE_COLOR = pad;
	public static  Color BRICK_COLOR = lad;
}
