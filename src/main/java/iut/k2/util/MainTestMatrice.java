package main;

public class MainTestMatrice {

	public static void main(String[] args) {
		Matrice m1 = new Matrice(3,3);
		Matrice m2 = new Matrice(4,3);
		m1.insert(1, 0, 0);
		m1.insert(1, 1, 1);
		m1.insert(1, 2, 2);
		m1.insert(-3, 2, 1);
		m1.insert(-2, 2, 0);
		
		m2.insert(1, 0, 0);
		m2.insert(1, 0, 1);
		m2.insert(1, 0, 2);
		m2.insert(1, 1, 0);
		m2.insert(2, 1, 1);
		m2.insert(1, 1, 2);
		m2.insert(3, 2, 0);
		m2.insert(1, 2, 1);
		m2.insert(1, 2, 2);
		m2.insert(3, 3, 0);
		m2.insert(2, 3, 1);
		m2.insert(1, 3, 2);
		
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(CalculMatriciel.produitDeMatrices(m1, m2));
	}
}
