package com.simple.basic.command;

public class BuilderVO {
	

	private String name;
	private int age;
	
	public BuilderVO(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	@Override
	public String toString() {
		return "BuilderVO [name=" + name + ", age=" + age + "]";
	}
	
	public static class Builder {
		
		private String name;
		private int age;
		
		private Builder() {}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public BuilderVO build() {
			return new BuilderVO(this);
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
	
	
//	private String name;
//	private int age;
//	
//	private BuilderVO(Builder builder) {
//		this.name = builder.inner_name;
//		this.age = builder.inner_age;
//	}
//	
//	public static Builder builder() {
//		return new Builder();
//	}
//
//	@Override
//	public String toString() {
//		return "BuilderVO [name=" + name + ", age=" + age + "]";
//	}
//
//	public static class Builder {
//		private String inner_name;
//		private int inner_age;
//		
//		private Builder() {}
//		
//		public Builder setName(String name) {
//			this.inner_name = name;
//			return this;
//		}
//		
//		public Builder setAge(int age) {
//			this.inner_age = age;
//			return this;
//		}
//		
//		public BuilderVO build() {
//			return new BuilderVO(this);
//		}
//		
//	}
