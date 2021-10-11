package hello;

import hello.Services.TimeService;
import hello.Services.service;


public class Get_data{


	private String first_class;
	private String second_class;
	private double first_value;
	private double second_value;

	public Get_data(){
		first_value=0;
	}
	public String getFirst_class() {
		return first_class;
	}

	public void setFirst_class(String first_class) {
		this.first_class = first_class;
	}

	public String getSecond_class() {
		return second_class;
	}

	public void setSecond_class(String content) {
		this.second_class = content;
	}

	public double getFirst_value() {
		return first_value;
	}

	public double getSecond_value() {
		return second_value;
	}

	public void setFirst_value(double first_value) {
		this.first_value = first_value;
	}

	public void setSecond_value(service service) {
		String x = service.getDifference(this.first_class,this.second_class);
		if(x.charAt(0)=='*')
			second_value=first_value*Integer.parseInt(x.substring(1));
		else if(x.charAt(0)=='/')
			second_value=first_value/Integer.parseInt(x.substring(1));
	}


}
