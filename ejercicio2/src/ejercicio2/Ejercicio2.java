package ejercicio2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;



public class Ejercicio2 {
	   public static void main(String[] args) {
	      List<Producto> shopping = List.of(
	            new Producto("Clothes", new BigDecimal("15.90"), Impuesto.NORMAL),
	            new Producto("Bread", new BigDecimal("1.5"), Impuesto.SUPERREDUCED),
	            new Producto("Meat", new BigDecimal("13.99"), Impuesto.REDUCED),
	            new Producto("Cheese", new BigDecimal("3.59"), Impuesto.SUPERREDUCED),
	            new Producto("Coke", new BigDecimal("1.89"), Impuesto.REDUCED),
	            new Producto("Whiskey", new BigDecimal("19.90"), Impuesto.NORMAL));
	      
	      //// Implementacion
	      	  
	  		  Object TotalPrecios = shopping.stream()
	  			  .filter(c -> c.name.startsWith("C"))
	  			  .map(d -> d.name)
	  			  .sorted()
	  			  .collect(Collectors.toList());
  				  
	  			  
	  			  System.out.println("Los productos que empiezan por c son " + TotalPrecios.toString());
	  			  
	  		  	  
  			  Object Precio = shopping.stream()
  					  .map(c -> c.price.add(c.price.multiply(new BigDecimal(c.impuesto.percent)).divide(new BigDecimal(100))))
  					  .reduce(BigDecimal.ZERO, (x , y) -> x.add(y).setScale(2 , RoundingMode.CEILING));
  			  
  			  System.out.println("El total de todos los productos " + Precio + " €");
	  			  

	  		  

	   }
	   
	   
	}