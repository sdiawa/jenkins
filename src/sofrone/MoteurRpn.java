package sofrone;



import java.util.Stack;

import Exception.AbscenceOperande;
import Exception.DenominateurNull;
import sofrone.Operation;

public class MoteurRpn {

	//création d'une pile vide
	static Stack<Double> pile;
	
	

	public MoteurRpn(){
		pile = new Stack<Double>();
		
	}
	
	
	
	public void empiler(double operande){
	//la valeur max a empiler est 100 en valeur absolu
	//si la condition est vérifier l'operande est enregistré
	//sinon rien ne s'ajoute à la pile
		
		if(Math.abs(operande)<100) {
		pile.push(operande);} 
		else{
	//message si la condition précédente n'est pas vérifier 
			System.out.println("saisir une valeur entre -99 et 99 inclus");}
			}
	
	public double depiler(){
		return pile.pop();
	}
 
	
	public  void enregistre(String s)  throws AbscenceOperande , DenominateurNull{
		
		//vérifier qu'il y'a au moins deux operandes dans la pile avant l'operation
		if(pile.size() < 2){
			
			throw new AbscenceOperande();
		}
		
		
		
		else
		if(s=="PLUS"){
			double s1,s2;
			
				s1=(double) pile.pop() ;
				
				s2=(double) pile.pop();
				
				double d=Operation.PLUS.eval(s2, s1);
				pile.push(d);
				
			
			
		}
		else if(s=="MINUS"){
			double s1,s2;
			
				s1=(double) pile.pop() ;
				
				s2=(double) pile.pop();
				
				double d=Operation.MINUS.eval(s2, s1);
				pile.push(d);
				
				
			
			
			
		}
		else if(s=="MULT"){
			double s1,s2;
			
				s1=(double) pile.pop() ;
				
				s2=(double) pile.pop();
				
				double d=Operation.MULT.eval(s2, s1);
				pile.push(d);
				
			
			
			
		}
		else if(s=="DIVIDE"){
			double s1,s2;
			
				s1=(double) pile.pop() ;
				
				s2=(double) pile.pop();
				
				if(s1==0.0){
					throw new DenominateurNull();

				
				}
				else {
					double d=Operation.DIVIDE.eval(s2, s1);
					pile.push(d);
				}
			}
			
			
		
		
		
		
	}
	public Stack<Double> getStack(){
		return pile;
	}
	public void afficherPile(){
		System.out.print("Saissie : \n");
		System.out.print(" [");
		for(double d:pile){
			

			System.out.print(d+" ");
		}
		System.out.print("]  ");
	
	
	

}
}

