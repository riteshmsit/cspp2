class waterlog  {
	double waterconsumed;
	String time;
	double weight;
	double fatpercentage;
	int waterlog[];
	int waterlogsize;
	waterlog() {
		waterlog[] = new int[30];
		waterlogsize = 0;
	}
	waterlog(double waterconsumed,String time,double weight,double fatpercentage) {
		this.waterconsumed = waterconsumed;
		this.time = time;
		this.weight = weight;
		this.fatpercentage = fatpercentage;
	}
	public String getWaterConsumed() {
		return this.waterconsumed;
	}
	public String getTime() {
		return this.time;
	}
	public String getWeight() {
		return this.weight;
	}
	public String getFatPercentage() {
		return this.fatpercentage;
	}
	public String setWaterConsumed() {
		this.waterconsumed = waterconsumed;
	}
	public String setTime() {
		this.time = time;
	}
	public String setWeight() {
		this.weight = weight;
	}
	public String setFatPercentage() {
		this.fatpercentage = fatpercentage;
	}
	public void toString() {
		if ( == "water") {

		} else {
			
		}
	}
}