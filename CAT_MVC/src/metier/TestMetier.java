package metier;

import java.util.List;

public class TestMetier {
	public static void main(String[] args){
		ICatalogueMetier metier=new CataloqueMetierImpl();		

//		Produit p=new Produit("refO5","ISIS",50, 10);		
//metier.addProduit(p);
		metier.deleteProduit("PR-04");
		List<Produit> prods=metier.listeProduits();
		System.out.println(prods.size());
		for(Produit p:prods){
			System.out.println("Reference= "+p.getReference()+", Designation: "+p.getDesignation()+", Prix: "+ p.getPrix()+", Quantite: "+p.getQuantite());
		}
		System.out.println("-----------------------------------------------------------------");
		List<Produit> prodParMC=metier.produitsParMC("HP");
		System.out.println(prodParMC.size());
		for(Produit p:prodParMC){
			System.out.println("Reference= "+p.getReference()+", Designation: "+p.getDesignation()+", Prix: "+ p.getPrix()+", Quantite: "+p.getQuantite());
		}
		System.out.println("-----------------------------------------------------------------");
		Produit p=metier.getproduit("PR-01");
		System.out.println("Reference= "+p.getReference()+", Designation: "+p.getDesignation()+", Prix: "+ p.getPrix()+", Quantite: "+p.getQuantite());
		System.out.println("-----------------------------------------------------------------");
		
		
		
}
}
