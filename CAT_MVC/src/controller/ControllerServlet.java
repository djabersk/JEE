package controller;
import java.io.IOException;
import java.util.List;

import metier.CataloqueMetierImpl;
import metier.Produit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ICatalogueMetier;

public class ControllerServlet extends HttpServlet{
		ICatalogueMetier metier;
		@Override
		public void init() throws ServletException {
			 metier=new CataloqueMetierImpl();
		}
			@Override
			protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				doPost(request, response);
//				request.getRequestDispatcher("VueProduits.jsp").forward(request, response);
			}
			@Override
			protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
				ProductModel model=new ProductModel();
				String action=request.getParameter("action");
				request.setAttribute("modele", model);
				if(action!=null){
					if(action.equals("chercher")){						
						model.setMc(request.getParameter("motcle"));
						List<Produit> produits=metier.produitsParMC(model.getMc());
						model.setProds(produits);						
					}else if(action.equals("delete")){
						String ref=request.getParameter("ref");
						metier.deleteProduit(ref);
						model.setProds(metier.listeProduits());
					}
				}
			
			request.getRequestDispatcher("VueProduits.jsp").forward(request, response);
			}
}
