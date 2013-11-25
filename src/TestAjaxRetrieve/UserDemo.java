package TestAjaxRetrieve;

import java.util.ArrayList;

public class UserDemo {
private String name;
private ArrayList<String> girlFriends;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public ArrayList<String> getGirlFriends() {
	return girlFriends;
}
public void setGirlFriends(ArrayList<String> girlFriends) {
	this.girlFriends = (ArrayList<String>)girlFriends.clone();
}

}
