package Fabricas;
import java.util.LinkedList;

import Enemigos.*;
import PowerUps.*;
import Mario.*;
import Plataformas.*;

public class FabricaEntidades {

	private FabricaSprite fabricaSprite;
    
	public FabricaEntidades(FabricaSprite fabricaSprite) {
		this.fabricaSprite=fabricaSprite;
	}
    
	public void establecerFabricaSprite(FabricaSprite fabricaSprite) {
		this.fabricaSprite=fabricaSprite;
	}
	
	public Mario crearMario(int x, int y) {
		Sprite[] spriteMario=fabricaSprite.spriteMario();
		Mario mario=new Mario(x, y, spriteMario);
		return mario;
	}

	public BuzzyBeetle crearBuzzyBeetle(int x, int y) {
		Sprite[] spriteBuzzyBeetle=fabricaSprite.spriteBuzzyBeetle();
		BuzzyBeetle buzzyBeetle=new BuzzyBeetle(x, y, spriteBuzzyBeetle);
		return buzzyBeetle;
	}

	public Goomba crearGoomba(int x, int y) {
		Sprite spriteGoomba[]=fabricaSprite.spriteGoomba();
		Goomba goomba=new Goomba(x, y, spriteGoomba);
		return goomba;
	}

	public Spiny crearSpiny(int x, int y) {
		Sprite spriteSpiny[]=fabricaSprite.spriteSpiny();
		Spiny spiny=new Spiny(x, y, spriteSpiny);
		return spiny;
	}

	public Lakitu crearLakitu(int x, int y, LinkedList<Spiny> spinys) {
		Sprite spriteLakitu[]=fabricaSprite.spriteLakitu();
		Lakitu lakitu=new Lakitu(x, y, spriteLakitu, spinys);
		return lakitu;
	}

	public KoopaTroopa crearKoopaTroopa(int x, int y) {
		Sprite spriteKoopaTroopa[]=fabricaSprite.spriteKoopaTroopa();
		KoopaTroopa koopaTroopa=new KoopaTroopa(x, y, spriteKoopaTroopa);
		return koopaTroopa;
	}

	public PiranhaPlant crearPiranhaPlant(int x, int y) {
		Sprite spritePiranhaPlant[]=fabricaSprite.spritePiranhaPlant();
		PiranhaPlant piranhaPlant=new PiranhaPlant(x, y, spritePiranhaPlant);
		return piranhaPlant;
	}

	public BloqueDePregunta crearBloqueDePregunta(int x, int y, PowerUp powerUp) {
		Sprite spriteBloqueDePregunta[]=fabricaSprite.spriteBloqueDePregunta();
		BloqueDePregunta bloqueDePregunta=new BloqueDePregunta(x, y, spriteBloqueDePregunta, powerUp);
		return bloqueDePregunta;
	}

	public BloqueSolido crearBloqueSolido(int x, int y) {
		Sprite spriteBloqueSolido[]=fabricaSprite.spriteBloqueSolido();
		BloqueSolido bloqueSolido=new BloqueSolido(x, y, spriteBloqueSolido);
		return bloqueSolido;
	}

	public LadrilloSolido crearLadrilloSolido(int x, int y) {
		Sprite spriteLadrilloSolido[]=fabricaSprite.spriteLadrilloSolido();
		LadrilloSolido ladrilloSolido=new LadrilloSolido(x, y, spriteLadrilloSolido);
		return ladrilloSolido;
	}

	public Vacio crearVacio(int x, int y) {
		Sprite spriteVacio[]=fabricaSprite.spriteVacio();
		Vacio vacio=new Vacio(x, y, spriteVacio);
		return vacio;
	}

	public Tuberia crearTuberia(int x, int y) {
		Sprite spriteTuberia[]=fabricaSprite.spriteTuberia();
		Tuberia tuberia=new Tuberia(x, y, spriteTuberia);
		return tuberia;
	}

	public Tuberia crearTuberia(int x, int y, PiranhaPlant piranha) {
		Sprite spriteTuberia[]=fabricaSprite.spriteTuberia();
		Tuberia tuberia = new Tuberia(x, y, spriteTuberia);
		return tuberia;
	}

	public Moneda crearMoneda(int x, int y) {
		Sprite spriteMoneda[]=fabricaSprite.spriteMoneda();
		Moneda moneda=new Moneda(x, y, spriteMoneda);
		return moneda;
	}

	public FlorDeFuego crearFlorDeFuego(int x, int y) {
		Sprite spriteFlorDeFuego[]=fabricaSprite.spriteFlorDeFuego();
		FlorDeFuego florDeFuego=new FlorDeFuego(x, y, spriteFlorDeFuego);
		return florDeFuego;
	}

	public Estrella crearEstrella(int x, int y) {
		Sprite spriteEstrella[]=fabricaSprite.spriteEstrella();
		Estrella estrella=new Estrella(x, y, spriteEstrella);
		return estrella;
	}

	public ChampinionVerde crearChampinionVerde(int x, int y) {
		Sprite spriteChampinionVerde[]=fabricaSprite.spriteChampinionVerde();
		ChampinionVerde champinionVerde=new ChampinionVerde(x, y, spriteChampinionVerde);
		return champinionVerde;
	}

	public SuperChampinion crearSuperChampinion(int x, int y) {
		Sprite spriteSuperChampinion[]=fabricaSprite.spriteSuperChampinion();
		SuperChampinion superChampinion=new SuperChampinion(x, y, spriteSuperChampinion);
		return superChampinion;
	}

	public BolaDeFuego crearBolaDeFuego(int x, int y) {
		Sprite spriteBolaDeFuego[]=fabricaSprite.spriteBolaDeFuego();
		BolaDeFuego bolaDeFuego=new BolaDeFuego(x, y, spriteBolaDeFuego);
		return bolaDeFuego;
	}

}
