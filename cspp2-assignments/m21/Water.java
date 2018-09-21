public class Water{
	String quantity;
	String date;
	Water(String q,String dt){
		this.quantity = q;
		this.date = dt;
	}

	public String getQuantity(){
		return this.quantity;
	}
	
	public String getDate(){
		return this.date;
	}
	public String getWaterSummary(){
		return "Quantity: "+quantity+"ml || Date: "+date;
		// String s;
		// s += this.quantity +"\n";
		// s += th;
		// return s;
	}
}