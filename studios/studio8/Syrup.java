package studio8;

import java.util.Random;

public class Syrup {

	public double density;
	public String brand;
	Random rand = new Random();

	public Syrup(String brand, double density) {

		this.density = density;
		this.brand = brand;
	}

	public int hashCode(){
		//return rand.nextInt();
		double sum = 0;
		for(int i=0; i<brand.length();i++){
			sum = sum + (double)brand.charAt(i);
		}
		int hash = (int)(31*density+17*sum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Syrup other = (Syrup) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (Double.doubleToLongBits(density) != Double
				.doubleToLongBits(other.density))
			return false;
		return true;
	}



}

