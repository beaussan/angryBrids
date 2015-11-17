package iut.k2.util;

public class Matrice {
	
	double tab[][];
	
	public Matrice(int largeur, int hauteur){
		tab = new double[hauteur][largeur];
	}
	
	public Matrice() {
		// TODO Auto-generated constructor stub
	}

	public void insert(double valeur, int x, int y){
		tab[y][x] = valeur;
	}
	
	public double getValue(int x, int y){
		return tab[y][x];
	}
	
	public double[][] getAllValues(){
		return tab;
	}
	
	public int getHauteur(){
		return tab.length;
	}
	
	public int getLargeur(){
		return tab[0].length;
	}
	
	public String toString(){
		String res = "";
		for(int hauteur = 0; hauteur < tab.length; hauteur++){
			for(int largeur = 0; largeur < tab[0].length; largeur++){
				res+= tab[hauteur][largeur] + " ";
			}
			res+="\n";
		}
		return res;
	}
}
