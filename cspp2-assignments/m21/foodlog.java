class foodlog  {
	String fooditem;
	double foodquantity;
	String time;
	int foodlog[];
	int foodlogsize;
	foodlog() {
		foodlog = new int[30];
		foodlogsize = 0;
	}
	foodlog(String fooditem, double foodquantity, String time) {
		this.fooditem = fooditem;
		this.foodquantity = foodquantity;
		this.time = time;
	}
	public String getFoodItem() {
		return this.fooditem;
	}
	public String getTime() {
		return this.time;
	}
	public String getFoodQuantity() {
		return this.foodquantity;
	}
	public String setFoodItem() {
		this.fooditem = fooditem;
	}
	public String setTime() {
		this.time = time;
	}
	public String setFoodQuantity() {
		this.foodquantity = foodquantity;
	}
	public String toString() {
		
	}
	

}