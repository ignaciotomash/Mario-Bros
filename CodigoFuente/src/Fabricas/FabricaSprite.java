package Fabricas;

public abstract class FabricaSprite {

	protected String rutaSprite;

	protected FabricaSprite(String rutaASprite) {
		this.rutaSprite=rutaASprite;
	}

	public Sprite[] spriteMario() {
		Sprite[] spriteMario= new Sprite[28];
		spriteMario[0]=new Sprite(rutaSprite + "/mario_inmovil_derecha.gif");
		spriteMario[1]=new Sprite(rutaSprite + "/mario_inmovil_izquierda.gif");
		spriteMario[2]=new Sprite(rutaSprite + "/mario_caminando_derecha.gif");
		spriteMario[3]=new Sprite(rutaSprite + "/mario_caminando_izquierda.gif");
		spriteMario[4]=new Sprite(rutaSprite + "/mario_saltando_derecha.png");
		spriteMario[5]=new Sprite(rutaSprite + "/mario_saltando_izquierda.png");
		spriteMario[6]=new Sprite(rutaSprite + "/mario_flor_inmovil_derecha.png");
		spriteMario[7]=new Sprite(rutaSprite + "/mario_flor_inmovil_izquierda.png");
		spriteMario[8]=new Sprite(rutaSprite + "/mario_flor_caminando_derecha.gif");
		spriteMario[9]=new Sprite(rutaSprite + "/mario_flor_caminando_izquierda.gif");
		spriteMario[10]=new Sprite(rutaSprite + "/mario_flor_saltando_derecha.png");
		spriteMario[11]=new Sprite(rutaSprite + "/mario_flor_saltando_izquierda.png");
		spriteMario[12]=new Sprite(rutaSprite + "/super_mario_inmovil_derecha.png");
		spriteMario[13]=new Sprite(rutaSprite + "/super_mario_inmovil_izquierda.png");
		spriteMario[14]=new Sprite(rutaSprite + "/super_mario_caminando_derecha.gif");
		spriteMario[15]=new Sprite(rutaSprite + "/super_mario_caminando_izquierda.gif");
		spriteMario[16]=new Sprite(rutaSprite + "/super_mario_saltando_derecha.png");
		spriteMario[17]=new Sprite(rutaSprite + "/super_mario_saltando_izquierda.png");
		spriteMario[18]=new Sprite(rutaSprite + "/mario_invencible_derecha.gif");
		spriteMario[19]=new Sprite(rutaSprite + "/mario_invencible_inmovil_izquierda.gif");
		spriteMario[20]=new Sprite(rutaSprite + "/mario_invencible_caminando_derecha.gif");
		spriteMario[21]=new Sprite(rutaSprite + "/mario_invencible_caminando_izquierda.gif");
		spriteMario[22]=new Sprite(rutaSprite + "/mario_invencible_saltando_derecha.gif");
		spriteMario[23]=new Sprite(rutaSprite + "/mario_invencible_saltando_izquierda.gif");
		spriteMario[24]=new Sprite(rutaSprite + "/mario_muriendo.png");
		spriteMario[25]=new Sprite(rutaSprite + "/mario_ganando.png");
		spriteMario[26]=new Sprite(rutaSprite + "/super_mario_ganando.png");
		spriteMario[27]=new Sprite(rutaSprite + "/mario_flor_de_fuego_ganando.png");

		return spriteMario;
	}

	public Sprite[] spriteBuzzyBeetle() {
		Sprite[] spriteBuzzyBeetle=new Sprite[2];
		spriteBuzzyBeetle[0]=new Sprite(rutaSprite + "/buzzy_beetle_derecha.gif");
		spriteBuzzyBeetle[1]=new Sprite(rutaSprite + "/buzzy_beetle_izquierda.gif");
		return spriteBuzzyBeetle;
	}

	public Sprite[] spriteGoomba() {
		Sprite[] spriteGoomba=new Sprite[1];
		spriteGoomba[0]=new Sprite(rutaSprite + "/goomba.gif");
		return spriteGoomba;
	}

	public Sprite[] spriteSpiny() {
		Sprite[] spriteSpiny=new Sprite[3];
		spriteSpiny[0]=new Sprite(rutaSprite + "/spiny_derecha.gif");
		spriteSpiny[1]=new Sprite(rutaSprite + "/spiny_izquierda.gif");
		spriteSpiny[2]=new Sprite(rutaSprite + "/spiny_auxiliar.png");
		return spriteSpiny;
	}

	public Sprite[] spriteLakitu() {
		Sprite[] spriteLakitu=new Sprite[3];
		spriteLakitu[0]=new Sprite(rutaSprite + "/lakitu_derecha.gif");
		spriteLakitu[1]=new Sprite(rutaSprite + "/lakitu_izquierda.gif");
		return spriteLakitu;
	}

	public Sprite[] spriteKoopaTroopa() {
		Sprite[] spriteKoopaTroopa=new Sprite[6];
		spriteKoopaTroopa[0]=new Sprite(rutaSprite + "/koopa_troopa_derecha.gif");
		spriteKoopaTroopa[1]=new Sprite(rutaSprite + "/koopa_troopa_izquierda.gif");
		spriteKoopaTroopa[2]=new Sprite(rutaSprite + "/koopa_troopa_caparazon.png");
		return spriteKoopaTroopa;
	}

	public Sprite[] spritePiranhaPlant() {
		Sprite[] spritePiranhaPlant=new Sprite[1];
		spritePiranhaPlant[0]=new Sprite(rutaSprite + "/piranha_plant.gif");
		return spritePiranhaPlant;
	}

	public Sprite[] spriteBloqueDePregunta() {
		Sprite[] spriteBloqueDePregunta=new Sprite[2];
		spriteBloqueDePregunta[0]=new Sprite(rutaSprite + "/bloque_de_pregunta.gif");
		spriteBloqueDePregunta[1]=new Sprite(rutaSprite + "/bloque_solido.png");
		return spriteBloqueDePregunta;
	}

	public Sprite[] spriteBloqueSolido() {
		Sprite[] spriteBloqueSolido=new Sprite[1];
		spriteBloqueSolido[0]=new Sprite(rutaSprite + "/bloque_solido.png");
		return spriteBloqueSolido;
	}

	public Sprite[] spriteVacio() {
		Sprite[] spriteVacio=new Sprite[1];
		spriteVacio[0]=new Sprite(rutaSprite + "/vacio.png");
		return spriteVacio;
	}

	public Sprite[] spriteTuberia() {
		Sprite[] spriteTuberia=new Sprite[1];
		spriteTuberia[0]=new Sprite(rutaSprite + "/tuberia.gif");
		return spriteTuberia;
	}

	public Sprite[] spriteLadrilloSolido() {
		Sprite[] spriteLadrilloSolido=new Sprite[1];
		spriteLadrilloSolido[0]=new Sprite(rutaSprite + "/ladrillo_solido.png");
		return spriteLadrilloSolido;
	}

	public Sprite[] spriteMoneda() {
		Sprite[] spriteMoneda=new Sprite[2];
		spriteMoneda[0]=new Sprite(rutaSprite + "/moneda.gif");
		spriteMoneda[1]=new Sprite(rutaSprite + "/dentro_de_bloque.png");
		return spriteMoneda;
	}

	public Sprite[] spriteFlorDeFuego() {
		Sprite[] spriteFlorDeFuego=new Sprite[2];
		spriteFlorDeFuego[0]=new Sprite(rutaSprite + "/flor_de_fuego.gif");
		spriteFlorDeFuego[1]=new Sprite(rutaSprite + "/dentro_de_bloque.png");
		return spriteFlorDeFuego;
	}

	public Sprite[] spriteEstrella() {
		Sprite[] spriteEstrella=new Sprite[2];
		spriteEstrella[0]=new Sprite(rutaSprite + "/estrella.gif");
		spriteEstrella[1]=new Sprite(rutaSprite + "/dentro_de_bloque.png");
		return spriteEstrella;
	}

	public Sprite[] spriteChampinionVerde() {
		Sprite[] spriteChampinionVerde=new Sprite[2];
		spriteChampinionVerde[0]=new Sprite(rutaSprite + "/champinion_verde.png");
		spriteChampinionVerde[1]=new Sprite(rutaSprite + "/dentro_de_bloque.png");
		return spriteChampinionVerde;
	}

	public Sprite[] spriteSuperChampinion() {
		Sprite[] spriteSuperChampinion=new Sprite[2];
		spriteSuperChampinion[0]=new Sprite(rutaSprite + "/super_champinion.png");
		spriteSuperChampinion[1]=new Sprite(rutaSprite + "/dentro_de_bloque.png");
		return spriteSuperChampinion;
	}

	public Sprite[] spriteBolaDeFuego() {
		Sprite[] spriteBolaDeFuego=new Sprite[2];
		spriteBolaDeFuego[0]=new Sprite(rutaSprite + "/bola_de_fuego.gif");
		spriteBolaDeFuego[1]=new Sprite(rutaSprite + "/bola_de_fuego_explotando.gif");
		return spriteBolaDeFuego;
	}

}
