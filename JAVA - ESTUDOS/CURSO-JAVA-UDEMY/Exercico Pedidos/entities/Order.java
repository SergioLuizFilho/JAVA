package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	List<OrderItem> orderList = new ArrayList<>();
	Client client;
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderList() {
		return orderList;
	}
	
	public void addItem(OrderItem orderItem) {
		orderList.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		if(orderList.size() > 0) {
			orderList.remove(orderItem);
		}else {
			System.out.println("Lista de itens vazia, nada para remover");
		}
	}
	
	public Double total() {
		Double total = 0.0;
		
		for(OrderItem orderItem : orderList) {
			total += orderItem.subTotal();
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		sb.append("Order moment: " + formatter.format(this.getMoment()) + "\n");
		sb.append("Order status: " + this.getStatus()+ "\n");
		sb.append(client + "\n");
		for(OrderItem orderItem : orderList) {
			sb.append(orderItem + "\n");
		}
		sb.append("Total price: " + String.format("$%.2f", this.total()) + "\n");
		
		return sb.toString();
	}
}

















