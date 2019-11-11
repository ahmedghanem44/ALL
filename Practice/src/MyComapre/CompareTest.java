package MyComapre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CompareTest {

	public static void main(String[] args) {
		
		HashSet<User> users = new HashSet<User>();
		User u1 = new User(1,"ahmed",34);
		User u2 = new User(2,"ali",22);
		User u3 = new User(3,"omar",16);
		User u4 = new User(4,"mohamed",38);
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		ArrayList<User> usersList = new ArrayList<User>(users);
		Collections.sort(usersList,new UserComparator());
		for(User u : usersList) {
			System.out.println(u.getId()+"-"+u.getName()+"-"+u.getAge());
		}
		System.out.println();
		HashMap<User,Integer> userMap = new HashMap<>();
		userMap.put(u1, 23);
		userMap.put(u2, 36);
		userMap.put(u3, 12);
		userMap.put(u4, 44);
		
		TreeMap<User,Integer> usersTree = new TreeMap<>();
		usersTree.putAll(userMap);
		
		User u = new User();
		Iterator itr = usersTree.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry me= (Map.Entry) itr.next();
			u = (User) me.getKey();
			System.out.println(u.getId()+"-"+u.getName()+"-"+u.getAge());
		}
		
		usersList.stream().sorted().forEach(us->System.out.println(us.getAge()));
		
		userMap.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByKey())
		.forEach(us->System.out.println(us.getKey().getId()+"-"+us.getKey().getName()+"-"+us.getKey().getAge()));
		
		
		
		
	}

}
