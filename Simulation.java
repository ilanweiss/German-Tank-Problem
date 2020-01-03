
public class Simulation {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int T = Integer.parseInt(args[2]);
		double ave = 0;  
		for (int i = 0 ; i < T ; i++){
			TankEstimator tanks = new TankEstimator();
			for (int j = 0 ; j < k ; j++){
				Heap tempTanks = new Heap();
				String serialTank = "";
				int temp = 1;
				while ( temp < N )
					{
					if ((int)(Math.random()+1) == 1) 
						serialTank += (char)(Math.random()*26 + 'a');
					else
						serialTank += (char)(Math.random()*26 + 'A');
					temp = temp*26;
					}
				Tank tank = new Tank(serialTank);
				if ((tank.serialNumber() > N)||
				(tempTanks.contains(tank)))
				{
					j--;
					continue;
				}
				tempTanks.insert(tank);
				tanks.captureTank(tank);
			}
			ave += tanks.estimateProduction();
	}
	ave = ave/T;
	System.out.println(ave);
	}
}
