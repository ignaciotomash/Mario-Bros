package Juego;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class DetectorColisiones {

	public DetectorColisiones() {}

	public void detectarColisionesMarioPlataformas(Nivel nivel) {

		boolean colisionaPlataforma = false;
		Mario mario = nivel.obtenerMario();
		Sprite spriteMario = nivel.obtenerMario().obtenerSprite();
		String porDerecha = "derecha";
		String porIzquierda = "izquierda";
		String porArriba = "arriba";
		String porAbajo = "abajo";

		for (Entidad plataforma : nivel.obtenerPlataformas()) {

			if (!plataforma.estaEliminada()) {
				Sprite spritePlataforma = plataforma.obtenerSprite();

				if (spriteMario.intersects(spritePlataforma)) {

					colisionaPlataforma = true;

					if (spriteMario.obtenerRectanguloAbajo().intersects(spritePlataforma.obtenerRectanguloArriba())) {
						mario.serAfectado(plataforma, porAbajo); 
						mario.establecerPosicionAnteriorY(mario.obtenerPosicionY());
					}
					if (spriteMario.obtenerRectanguloDerecho().intersects(spritePlataforma.obtenerRectanguloIzquierdo())) 
						mario.serAfectado(plataforma, porDerecha);

					if (spriteMario.obtenerRectanguloIzquierdo().intersects(spritePlataforma.obtenerRectanguloDerecho())) 
						mario.serAfectado(plataforma, porIzquierda);

					if (spriteMario.obtenerRectanguloArriba().intersects(spritePlataforma.obtenerRectanguloAbajo())) {
						mario.serAfectado(plataforma, porArriba);
						plataforma.serAfectado(mario);
					}
				}

				if (!colisionaPlataforma && mario.estaSobrePlataforma()) 
					mario.sobrePlataforma(false); 
			}
		}
	}

	public void detectarColisionesMarioEnemigos(Nivel nivel) {

		boolean marioMataAEnemigo;
		boolean enemigoMataAMario;
		Mario mario = nivel.obtenerMario();
		Sprite spriteMario = nivel.obtenerMario().obtenerSprite();

		for (Entidad enemigo : nivel.obtenerEnemigos()) {

			if (!enemigo.estaEliminada()) {
				Sprite spriteEnemigo = enemigo.obtenerSprite();

				marioMataAEnemigo = spriteMario.obtenerRectanguloAbajo().intersects(spriteEnemigo.obtenerRectanguloArriba());

				enemigoMataAMario = 
						
						spriteMario.obtenerRectanguloDerecho().intersects(spriteEnemigo.obtenerRectanguloIzquierdo())
						|| spriteMario.obtenerRectanguloIzquierdo().intersects(spriteEnemigo.obtenerRectanguloDerecho())
						|| spriteMario.obtenerRectanguloArriba().intersects(spriteEnemigo.obtenerRectanguloAbajo());

				if (spriteMario.intersects(spriteEnemigo)) {

					if (marioMataAEnemigo) 

						enemigo.serAfectado(mario);

					else if (enemigoMataAMario)

						mario.serAfectado(enemigo);
				}
			}
		}
	}

	public void detectarColisionesMarioPowerUps(Nivel nivel) {

		boolean intersectaron;
		Mario mario = nivel.obtenerMario();
		Sprite spriteMario = nivel.obtenerMario().obtenerSprite();

		for (Entidad powerUp : nivel.obtenerPowerUps()) {
			if (!powerUp.estaEliminada()) {
				Sprite spritePowerUp = powerUp.obtenerSprite();

				intersectaron = 

						spriteMario.obtenerRectanguloDerecho().intersects(spritePowerUp.obtenerRectanguloIzquierdo())
						|| spriteMario.obtenerRectanguloIzquierdo().intersects(spritePowerUp.obtenerRectanguloDerecho())
						|| spriteMario.obtenerRectanguloArriba().intersects(spritePowerUp.obtenerRectanguloAbajo())
						|| spriteMario.obtenerRectanguloDerecho().intersects(spritePowerUp.obtenerRectanguloArriba())
						|| spriteMario.obtenerRectanguloIzquierdo().intersects(spritePowerUp.obtenerRectanguloArriba());

				if (spriteMario.intersects(spritePowerUp)) {

					if (intersectaron) 

						mario.serAfectado(powerUp);

				}
			}
		}
	}

	public void detectarColisionesEnemigoConEnemigo(Nivel nivel) {

		boolean intersectaron;

		for (Entidad enemigo1: nivel.obtenerEnemigos()) {

			if(!enemigo1.estaEliminada()) {
				Sprite spriteEnemigo1 = enemigo1.obtenerSprite();

				for(Entidad enemigo2: nivel.obtenerEnemigos()) {
					if (!enemigo2.estaEliminada()) {
						Sprite spriteEnemigo2= enemigo2.obtenerSprite();

						intersectaron = 

								spriteEnemigo1.obtenerRectanguloDerecho().intersects(spriteEnemigo2.obtenerRectanguloIzquierdo())
								|| spriteEnemigo1.obtenerRectanguloIzquierdo().intersects(spriteEnemigo2.obtenerRectanguloDerecho())
								|| spriteEnemigo1.obtenerRectanguloArriba().intersects(spriteEnemigo2.obtenerRectanguloAbajo())
								|| spriteEnemigo1.obtenerRectanguloDerecho().intersects(spriteEnemigo2.obtenerRectanguloArriba())
								|| spriteEnemigo1.obtenerRectanguloIzquierdo().intersects(spriteEnemigo2.obtenerRectanguloArriba());

						if(spriteEnemigo1.intersects(spriteEnemigo2) && enemigo1 != enemigo2)

							if(intersectaron)

								enemigo1.serAfectado(enemigo2);
					}
				}
			}
		}
	}

	public void detectarColisionesEntidadesPlataformas(Nivel nivel) {

		for (Entidad entidad : nivel.obtenerEntidades()) {
			if (!entidad.estaEliminada()) {

				Sprite spriteEntidad = entidad.obtenerSprite();
				boolean colisionaPlataforma = false; 

				for (Entidad plataforma : nivel.obtenerPlataformas()) {
					if (!plataforma.estaEliminada()) {

						Sprite spritePlataforma = plataforma.obtenerSprite();

						if (spriteEntidad.intersects(spritePlataforma) && entidad != plataforma) {

							colisionaPlataforma = true;  

							if (spriteEntidad.obtenerRectanguloAbajo().intersects(spritePlataforma.obtenerRectanguloArriba())) {
								entidad.serAfectado(plataforma, "abajo"); 
								entidad.establecerPosicionAnteriorY(entidad.obtenerPosicionY());
							}
							if (spriteEntidad.obtenerRectanguloDerecho().intersects(spritePlataforma.obtenerRectanguloIzquierdo())) 
								entidad.serAfectado(plataforma, "derecha");

							if (spriteEntidad.obtenerRectanguloIzquierdo().intersects(spritePlataforma.obtenerRectanguloDerecho())) 
								entidad.serAfectado(plataforma, "izquierda");

							if (spriteEntidad.obtenerRectanguloArriba().intersects(spritePlataforma.obtenerRectanguloAbajo())) 
								entidad.serAfectado(plataforma, "arriba");
						}
					}
				}

				if (!colisionaPlataforma && entidad.estaSobrePlataforma()) 
					entidad.sobrePlataforma(false);  
			}
		}
	}

	public void detectarColisionesEntidadesBolasDeFuego(Nivel nivel) {

		for(Entidad entidad : nivel.obtenerEntidades()) {
			if(!entidad.estaEliminada()) {
				Sprite spriteEntidad = entidad.obtenerSprite();

				for(Entidad bola : nivel.obtenerBolasDeFuego()) {
					if(!bola.estaEliminada()) {
						Sprite spriteBola = bola.obtenerSprite();

						if(spriteEntidad.intersects(spriteBola) && bola != entidad) {

							if (spriteEntidad.obtenerRectanguloAbajo().intersects(spriteBola.obtenerRectanguloArriba())) 
								entidad.serAfectado(bola, "abajo"); 

							if (spriteEntidad.obtenerRectanguloDerecho().intersects(spriteBola.obtenerRectanguloIzquierdo())) 
								entidad.serAfectado(bola, "derecha");

							if (spriteEntidad.obtenerRectanguloIzquierdo().intersects(spriteBola.obtenerRectanguloDerecho())) 
								entidad.serAfectado(bola, "izquierda");

							if (spriteEntidad.obtenerRectanguloArriba().intersects(spriteBola.obtenerRectanguloAbajo())) 
								entidad.serAfectado(bola, "arriba");
						}
					}
				}
			}
		}
	}
}