package com.learndemo;

public class Outter {
	public static String name;
	public static int age;

	public Outter() {
		this(new Builder());
	}

	public Outter(Builder builder) {
		// TODO Auto-generated constructor stub
		name = builder.name;
		age = builder.age;
	}

	@Override
	public String toString() {
		return "Outter" + "age= '" + age + "\'" + "name= '" + name + "\'";
	}

	/**
	 * 
	 * @author lu 静态内部类
	 */
	public static class Builder {
		private String name;
		private int age = 11;

		public Builder() {
			name = name;
			age = age;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public Outter buider() {
			return new Outter(this);
		}

	}

}
