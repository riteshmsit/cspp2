class Pattern {
	public static void main(String[] args) {
		String s ="";
		for(int i=1;i<=5; i++){
			s = "";
			for(int j=1;j<=i;j++) {
				s += j + " ";
			}
			System.out.println(s);
		}		
	}
}