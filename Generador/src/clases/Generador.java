
package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Generador {
    
    private Random rd;
    private List<Integer> ruleta;
    private List<Integer> sorteo;
    private int longitudRuleta;
    private int longitudSorteo;
    private int numeroSorteo;
    
    public Generador(){
	
	rd=new Random();
	ruleta = new ArrayList<Integer>();
	sorteo  = new ArrayList<Integer>();	
	longitudRuleta=0;
	longitudSorteo=0;
	numeroSorteo=0;
    }

    public Random getRd() {
	return rd;
    }

    public void setRd(Random rd) {
	this.rd = rd;
    }

    public List<Integer> getRuleta() {
	return ruleta;
    }

    public void setRuleta(List<Integer> ruleta) {
	this.ruleta = ruleta;
    }

    public List<Integer> getSorteo() {
	return sorteo;
    }

    public void setSorteo(List<Integer> sorteo) {
	this.sorteo = sorteo;
    }
   
    public int getlongitudRuleta() {
	return longitudRuleta;
    }

    public void setlongitudRuleta(int longitudRuleta) {
	this.longitudRuleta = longitudRuleta;
    }

    public int getLongitudSorteo() {
	return longitudSorteo;
    }

    public void setLongitudSorteo(int longitudSorteo) {
	this.longitudSorteo = longitudSorteo;
    }
    
    public void setNumeroSorteo(int numeroSorteo) {
    	
    	this.numeroSorteo=numeroSorteo;
    }
    
    public int getNumeroSorteo() {
    	
    	return numeroSorteo;
    }
    
    public void llenoRuleta(){
    	
    	ruleta.clear();
    	
		for(Integer i = 1;i<=longitudRuleta;i++){	
		    ruleta.add(i);
		}
    }     
    
    public void generoAleatorios(){
    	
    	//ruleta.clear();
    	llenoRuleta();    	
    	
    	sorteo.clear();
    	
    	int indice = 0;
    	int longitudTemporal=0;
    	Integer obtenido = 0;    	
    	  	
    		
    		do {
    			
    			longitudTemporal = ruleta.size();    		
    			
    			indice = rd.nextInt(longitudTemporal); // indices 0 - longitudTemporar(5)    			
    		
    			obtenido = ruleta.get(indice);
    			
    			if(ruleta.contains(obtenido)) {
    				
    				sorteo.add(obtenido);
    				ruleta.remove(obtenido);
    			}
    		}
    		while(sorteo.size()<longitudSorteo);         	
    		
    		if(sorteo.size()>0) {
    			
	    		for(int v : sorteo) {    		
	        		System.out.print("["+v+"] ");
	        	}
    		}
    }
    
    public List<Integer> ordenaLista(List<Integer> lista){
    
	int temp = 0;
	
	for(int i = 0;i<lista.size();i++){
	    
	    for(int j = 0; j<i ;j++){
		
		
		if(lista.get(i)<lista.get(j)){
		
		    temp = lista.get(i);
		    lista.set(i, lista.get(j));
		    lista.set(j, temp);		    
		}
	    }

	}
	return lista;
    }        
    
    public void mostrarLista(List<Integer> lista, String nombre){
    
	System.out.println(nombre);
	for(int v : lista)
	    System.out.print("["+v+"] ");
	
	System.out.println(" size: "+lista.size());
    }   
    
    public int isNumero(String numero) {
    	
    	class Valido{   		
			
			public boolean isTexto(){
    				
    				try {
					
    					Integer.parseInt(numero);
    					return false;
    					
    				}catch(Exception e) {
    					
    					return true;
    					
    				}  				  			
    	    }
    	}
    	
    	Valido val = new Valido();
    	
    	return val.isTexto()?Integer.MIN_VALUE:Integer.parseInt(numero);
    	
    	}
    
}

