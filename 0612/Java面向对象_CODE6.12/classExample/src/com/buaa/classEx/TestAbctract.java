package com.buaa.classEx;

////如果一个类里有抽象的方法，则这个类就必须声明成抽象的。
abstract class Vehicle {  //抽象类

	public abstract void calcFuelEfficiency();//抽象方法

	public abstract void calcTripDistance();//抽象方法
}

abstract class Truck extends Vehicle {
	public Truck(double max_load) {
	}

	public void calcFuelEfficiency() {
	}
/*
	public void calcTripDistance() {
	}
*/
}

class RiverBarge extends Vehicle {
	public RiverBarge(double max_load) {
	}

	public void calcFuelEfficiency() {
	}

	public void calcTripDistance() {
	}
}



public abstract class TestAbctract {  //一个抽象类中却可以没有抽象方法。

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
