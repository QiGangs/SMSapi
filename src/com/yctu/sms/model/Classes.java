package com.yctu.sms.model;

public class Classes {
private String class_id;
private String name;
public String getClass_id() {
	return class_id;
}
public void setClass_id(String class_id) {
	this.class_id = class_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Classes [class_id=" + class_id + ", name=" + name + "]";
}


}
