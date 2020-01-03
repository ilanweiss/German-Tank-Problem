
public class Tank implements Comparable<Tank>{
	
	private String serialNumber;
	
	/**
	 * A standard constructor for the tank class.
	 * 
	 * @param serialNumber - the serial number of the tank
	 */
	public Tank(String serialNumber){
		
		this.serialNumber = serialNumber;
	}
	
	/**
	 * Compares this tank with another tank for order. 
	 * Returns a negative integer, zero, or a positive integer as the serial number of this tank is
	 * is less than, equal to, or greater than the serial number of the other tank.
	 * 
	 * @param other - the tank to be compared
	 * @return a negative integer, zero, or a positive integer as the serial number of this tank is 
	 * 		   less than, equal to, or greater than the serial number of the other tank.
	 */
	public int compareTo(Tank other) {
		return (serialNumber() - other.serialNumber());
	}
	
	/**
	 * Convert the string serial number into a positive integer as explained in the assignment's
	 * document.
	 * 
	 * @return the integer represented by the serial number.
	 */
	public int serialNumber(){
		int val = 0;
		for (int i = 0; i < serialNumber.length(); i++)
			{
			int power = 1;
			for (int j = 0; j < (serialNumber.length() - i -1) ; j++)
				{
				power *= 26;	
				}
			if ((serialNumber.charAt(i)>= 'A' ) && (serialNumber.charAt(i)<= 'Z'))
				val += ((serialNumber.charAt(i) - 'A') * power);
			if ((serialNumber.charAt(i)>= 'a' ) && (serialNumber.charAt(i)<= 'z'))
				val += ((serialNumber.charAt(i) - 'a') * power);
			}			
		return val;
	}
}
