package iut.k2.physics;

import iut.k2.util.CalculMatriciel;
import iut.k2.util.Matrice;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;

public class MainTestMatrice {

	@Test
	public void testProduitMatriciel(){
		Matrice m1 = new Matrice(2,2);
		Matrice m2 = new Matrice(2,2);
		
		Matrice response = new Matrice(2,2);
		
		m1.insert(1, 0, 0);
		m1.insert(-1, 0, 1);
		m1.insert(0, 1, 0);
		m1.insert(3, 1, 1);
		m2.insert(3, 0, 0);
		m2.insert(2, 0, 1);
		m2.insert(1, 1, 0);
		m2.insert(1, 1, 1);
		 
		response.insert(3, 0, 0);
		response.insert(3, 0, 1);
		response.insert(1, 1, 0);
		response.insert(2, 1, 1);
		
		Assert.assertArrayEquals(response.getAllValues(), CalculMatriciel.produit(m1, m2).getAllValues());
		
	}
}
