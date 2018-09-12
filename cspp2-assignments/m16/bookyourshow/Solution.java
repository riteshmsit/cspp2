import java.util.*;
class movie{
	String movie_name;
	String time;
	String[] seats;
	movie(String movie_name, String time, String[] seats){
		this.movie_name = movie_name;
		this.time = time;
		this.seats = seats;
	}
}

class ticket{
	String movie_name;
	String time;
	String person_name;
	String mobile;
	ticket(String movie_name, String time, String person_name, String mobile){
		this.movie_name = movie_name;
		this.time = time;
		this.person_name = person_name;
		this.mobile = mobile;
	}
}

class bookmyshow{
	movie[] movies = new movie[10];
	int size = 0;
	ticket[] tickets = new ticket[10];
	int tic_size = 0;
	boolean flag= false;
	public void add(String movie_name, String time, String[] seats){
		movie new_movie = new movie(movie_name, time, seats);
		movies[size++] = new_movie;
	}

	public String get(String movie_name, String time){
		for(int i = 0; i < size; i++){
			if(movies[i].movie_name.equals(movie_name) && movies[i].time.equals(time)){
				return movie_name + ","+time;
			}
		}
		return "No show";
	}
	public void book(String movie_name, String time, String person_name, String mobile, String[] req_seats){
		// if(size == 0){
		// 	System.out.println("No show");
		// 	return;
		// }
		if(available(movie_name, time, req_seats)){
			ticket new_tic = new ticket(movie_name, time, person_name, mobile);
			tickets[tic_size++] = new_tic;
			return;
		}
		if(flag == false){
			System.out.println("No show");
		}else{
			flag = false;
		}
	}

	private boolean available(String movie_name, String time,String[] req_seats){
		// System.out.println(Arrays.toString(req_seats));
		for(int i = 0; i<size;i++){
			if(movies[i].movie_name.equals(movie_name) && movies[i].time.equals(time)){
				flag = true;
				for(int j = 0; j < req_seats.length; j++){
					for(int k = 0; k < movies[i].seats.length; k++){
						if(req_seats[j].equals(movies[i].seats[k])){
							movies[i] = block(movies[i],req_seats);
							return true;
						}

					}
				}
			}
		}
		return false;
	}

	private movie block(movie obj, String[] req_seats){
		for(int i = 0; i < obj.seats.length; i++){
			for(int j = 0; j < req_seats.length; j++){
				if(obj.seats[i].equals(req_seats[j])){
					obj.seats[i] = "N/A";
				}
			}
		}
		return obj;
	}
	public String print(String movie_name, String time, String mobile){
		for(int i = 0; i < tic_size; i++){
			if(tickets[i].movie_name.equals(movie_name)){
				if(tickets[i].time.equals(time)){
					if(tickets[i].mobile.equals(mobile)){
						return mobile+" "+movie_name +" "+time;
					}
				}
			} 
		}
		return "Invalid";
	}
	public void printAll(){
		// System.out.println("movie array");
		for(int i = 0; i < size; i++){
			System.out.println(movies[i].movie_name + ","+movies[i].time+","+Arrays.toString(movies[i].seats));
		}
		
	}
}


class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no_of_lines = Integer.parseInt(sc.nextLine());
		bookmyshow obj = new bookmyshow();
		for(int i = 0; i < no_of_lines; i++){
			String[] input = sc.nextLine().split(" ",2);
			if(input[0].equals("add")){
				String[] att = input[1].split(",",3);
				String[] seats = att[2].substring(1, att[2].length()-1).split(",");
				obj.add(att[0], att[1], seats);
			}else if(input[0].equals("book")){
				String[] att = input[1].split(",",5);
				String[] seats = att[4].substring(1, att[4].length()-1).split(",");
				// System.out.println(seats);

				obj.book(att[0], att[1], att[2], att[3],seats);
			}else if(input[0].equals("get")){
				String[] att = input[1].split(",");
				System.out.println(obj.get(att[0], att[1]));
			}else if(input[0].equals("print")){
				String[] att = input[1].split(",");
				System.out.println(obj.print(att[0], att[1],att[2]));
			}else if(input[0].equals("showAll")){
				obj.printAll();
			}
		}
	}
}