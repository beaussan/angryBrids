package main;

import java.util.ArrayList;
import java.util.List;

public class CalculMatriciel {

	static public Matrice produit(Matrice mg, Matrice mh){
		//TODO Calcul de matrice, Attention: 4 boucles
		Matrice m = new Matrice(mh.getLargeur(), mg.getHauteur());
		if(mg.getLargeur() == mh.getHauteur()){
			//Coordonnée Y de la matrice finale
			for(int i = 0; i < m.getHauteur(); i++){
				//Coordonnée X de la matrice finale
				for(int j = 0; j < m.getLargeur(); j++){
					double resultat = 0;
					//Parcours de taille mgLargeur ou mhHauteur
					for(int k = 0; k < mg.getLargeur(); k++){
						resultat += mg.getValue(k, i) * mh.getValue(j, k);
					}
					m.insert(resultat, j, i);
				}
				
			}
		}else{
			System.out.println("Mauvaises dimensions");
			return null;
		}
		return m;
	}
	
	static public Matrice homothetie(Matrice m, double k){
		
		return null;
	}
	
	static public Matrice rotation(Matrice m, double angle){
		
		return null;
	}
}
