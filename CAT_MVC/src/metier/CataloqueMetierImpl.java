package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CataloqueMetierImpl implements ICatalogueMetier{

	@Override
	public void addProduit(Produit p) {
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into produits(REF_PROD, DSEIGNATION, PRIX, QUANTITE) values ?, ?, ?, ?");			
			ps.setString(1, p.getReference());
			ps.setString(2, p.getDesignation());
			ps.setDouble(3, p.getPrix());
			ps.setInt(4, p.getQuantite());
			ps.executeUpdate();
			ps.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Produit> listeProduits() {
		List<Produit> prods=new ArrayList<Produit>();
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from produits");
			ResultSet res=ps.executeQuery();
			while(res.next()){
				Produit p=new Produit();
				p.setReference(res.getString("REF_PROD"));
				p.setDesignation(res.getString("DESIGNATION"));
				p.setPrix(res.getDouble("PRIX"));
				p.setQuantite(res.getInt("QUANTITE"));
				prods.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		Connection con=SingletonConnection.getConnection();
		List<Produit> prods=new ArrayList<Produit>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from produits where DESIGNATION like ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet res=ps.executeQuery();
			while (res.next()){
				Produit p=new Produit();
				p.setReference(res.getString("REF_PROD"));
				p.setDesignation(res.getString("DESIGNATION"));
				p.setPrix(res.getDouble("PRIX"));
				p.setQuantite(res.getInt("QUANTITE"));
				prods.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public Produit getproduit(String ref) {
		Produit p=null;
		Connection con= SingletonConnection.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("select * from produits where REF_PROD=?");
			ps.setString(1, ref);
			ResultSet res=ps.executeQuery();
			while(res.next()){
				p=new Produit();
				p.setReference(res.getString("REF_PROD"));
				p.setDesignation(res.getString("DESIGNATION"));
				p.setPrix(res.getDouble("PRIX"));
				p.setQuantite(res.getInt("QUANTITE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(p==null){
			throw new RuntimeException("produit "+ref+" introuvable");
		}
		return p;		
	}

	@Override
	public void updateProduit(Produit p) {
		Connection con=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("update  produits set DEIGNATION=?, PRIX=?, QUANTITE=? where REF_PROD=?");			
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setString(4, p.getReference());
			ps.executeUpdate();
			ps.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
	}

	@Override
	public void deleteProduit(String ref) {
		Connection con=SingletonConnection.getConnection();
	
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("delete from produits where REF_PROD=?");
				ps.setString(1, ref);
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	
	}

}
