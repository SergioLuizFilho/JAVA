package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	private String name, email;
	private Date birthDate;
	
	public static SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
	
	public Client() {
	}

	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Client: ").append(this.getName());
		sb.append(" (").append(formatter1.format(this.getBirthDate())).append(") - ");
		sb.append(this.getEmail());	
		return sb.toString();
	}
}










