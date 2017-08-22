package metier;

import java.util.List;

public interface ICatalogueMetier {
	public void addProduit(Produit p);
	public List<Produit> listeProduits();
	public List<Produit> produitsParMC(String mc);
	public Produit getproduit(String ref);
	public void updateProduit(Produit p);
	public void deleteProduit(String ref);

}
