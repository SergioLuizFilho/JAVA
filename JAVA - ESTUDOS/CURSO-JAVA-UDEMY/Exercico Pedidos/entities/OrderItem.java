package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	
	Product product;
	
	public OrderItem() {
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Double subTotal() {
		return (this.getPrice() * (double)this.getQuantity());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(product.getName() + ", ");
		sb.append(String.format("$%.2f, ", product.getPrice()));
		sb.append("Quantity: " + this.getQuantity() + ", ");
		sb.append("Subtotal: " + String.format("$%.2f, ", this.subTotal()));
		
		return sb.toString();
	}
}















