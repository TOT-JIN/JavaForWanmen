package com.buaa.classEx;
//this 和 super
public class Student {
	private String name;
	private char sex;
	protected String birthday;
	private int compScore, engScore;
	public Student(String name, char sex, String birthday) {
		this.name =name ;
		this.sex = sex;
		this.birthday =birthday ;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public void setCompScore(int data) {
		compScore = data;
	}

	public int getCompScore() {
		return compScore;
	}

	public void setEngScore(int data) {
		engScore = data;
	}

	public int getEngScore() {
		return engScore;
	}

	public double getAverScore() {
		return (compScore + engScore) / 2.0;
	}

	public int getMaxScore() {
		int max;
		if (compScore > engScore)
			max = compScore;
		else
			max = engScore;
		return max;
	}

	public String toString() {
		return "姓名" + name + ";性别" + sex + ";出生年月；" + birthday;
	}
}
