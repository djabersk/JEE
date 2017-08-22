package controller;

import java.util.List;

import metier.Produit;

public class ProductModel {
private String mc;
private List<Produit> prods;
public String getMc() {
	return mc;
}
public void setMc(String mc) {
	this.mc = mc;
}
public List<Produit> getProds() {
	return prods;
}
public void setProds(List<Produit> prods) {
	this.prods = prods;
}
}
