import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
//import java.util.Hashtable;
class User {
	private String username;
	private ArrayList<String> friends;
	public User() {

	}
	public User(String username1, ArrayList<String> friends1) {
		this.username = username1;
		this.friends = friends1;
	}
	public String getusername() {
		return this.username;
	}
	public ArrayList<String> getfriends() {
		return this.friends;
	}
	public void addfriend(String friend) {
		friends.add(friend);
	}
	public void removefriend(String friend) {
		friends.remove(friend);
	}
	public String toString() {
		return this.getusername() + ":" + " " + this.getfriends();
	}
}
public class SocialNetwork {
	private ArrayList<User> users;
	private SocialNetwork() {
		users = new ArrayList<User>();

	}
	public void adduser(User user2) {
		int flag = 0;
		User user3 = new User();
		for (User user1 : users) {
			if (user1.getusername().equals(user2.getusername())) {
				flag = 1;
				user3 = user1;
				break;
			}
		}
		if (flag == 0) {
			users.add(user2);
		} else {
			for (String friends2: user2.getfriends()) {
				if (!user3.getfriends().contains(friends2)) {
					user3.addfriend(friends2);
				}
			}
		}
	}
	public void removefriends(User user2) {
		//User user1;
		int flag = 0;
		User user3 = new User();
		for (User user1 : users) {
			if (user1.getusername().equals(user2.getusername())) {
				flag = 1;
				user3 = user1;
				break;
			}
			
		}
		if (flag == 1) {
			for (String friends2 : user2.getfriends()) {
				if (user3.getfriends().contains(friends2)) {
					user3.removefriend(friends2);
				}
			}
		}
	}
	public void getfriends(User user2) {
		//User user1;
		for (User user1 : users) {
			if (user1.getusername().equals(user2.getusername())) {
				System.out.print(user1.getfriends());
				return;
			}
		}
		System.out.print("Not a user in Network");
	}
	public User getuser(String username) {
		//User user1;
		for (User user1 : users) {
			if (user1.getusername().equals(username)) {
				return user1;
			}
		}
		return null;
	}
	public void getcommonfriends(String username1, String username2) {
		User user1 = getuser(username1);
		User user2 = getuser(username2);
		int flag = 0;
		String str = "[";
		if (user1 != null && user2 != null) {
			
			for (String friend : user1.getfriends()) {
				if (user2.getfriends().contains(friend)) {
					str += friend + ", ";
					flag = 1;
				}
			
			}
		} 
		if (flag == 0) {
			System.out.print("[]");
		} else {
			System.out.print(str.substring(0, str.length() - 2) + "]");
		}
	}
	public void delete(User user2) {
		User user1 = getuser(user2.getusername());
		users.remove(user1);
	}
	public ArrayList<String> convert(String[] str2) {
		ArrayList<String> str1 = new ArrayList<String>();
		for (int i = 0; i < str2.length; i++) {
			str1.add(str2[i].substring(0, str2[i].length() - 1));
		}
		return str1;
	}
	public void Network() {
		int i = 0;
		for (i = 0; i < users.size() - 1; i++) {
			System.out.print(users.get(i) + ", ");
		}
		if (i < users.size()) {
			System.out.print(users.get(i));
		}
	}
	public static void main(String[] args) {
		//Hashtable ht = new Hashtable<String, String[]>;
		SocialNetwork sn = new SocialNetwork();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] str = sc.nextLine().split(" "); 
			switch (str[0]) {
				case "Create":
					for (int i = 0; i < Integer.parseInt(str[1]); i++) {
						String[] str1 = sc.nextLine().split(" ", 5);
						sn.adduser(new User(str1[0], sn.convert(str1[4].split(" "))));

					}
					break;
				case "Network":
					//System.out.println();
					sn.Network();
					System.out.println();
					break;
				case "remove":
					//String[] str2 = str.split(" ", 3);
					//sn.removefriends(new User(str2[0], str2[2].split(" ")));

					break;
				case "addConnections":
					ArrayList<String> friends = new ArrayList<String>();
					friends.add(str[2]);
					sn.adduser(new User(str[1], friends));
					break;
				case "CommonConnections":
					//System.out.println();
					sn.getcommonfriends(str[1], str[2]);
					System.out.println();
					break;
				case "delete":
					//sn.delete(new User());
					break;
				case "getConnections":
					//System.out.println();
					sn.getfriends(new User(str[1], null));
					System.out.println();
					break;
				default:
					break;
			}
		}
	}

}