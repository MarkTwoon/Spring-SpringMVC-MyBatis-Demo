package com.chinasoft.SpringDemo.pojo;

public class User {
private String userName;
private int userAge;
private String userSex;
private String phone;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public int getUserAge() {
	return userAge;
}
public void setUserAge(int userAge) {
	this.userAge = userAge;
}
public String getUserSex() {
	return userSex;
}
public void setUserSex(String userSex) {
	this.userSex = userSex;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public User(String userName, int userAge, String userSex, String phone) {
	 
	this.userName = userName;
	this.userAge = userAge;
	this.userSex = userSex;
	this.phone = phone;
}
/*后端实体类 参与控制器数据装载
 * 显式无参构造  必须要声明*/
public User(){
	
}
}
