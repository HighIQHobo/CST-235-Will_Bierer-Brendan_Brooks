package Beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean
@ViewScoped
public class Orders {
	List<Order> orders = new ArrayList<Order>();
	
	public Orders()
	{
		orders.add(new Order("000000000", "Product 1", (float)1.00, 1));
		orders.add(new Order("000000001", "Product 2", (float)2.50, 2));
		orders.add(new Order("000000002", "Product 3", (float)2.20, 3));
		orders.add(new Order("000000003", "Product 4", (float)5.60, 4));
		orders.add(new Order("000000003", "Product 4", (float)5.60, 4));
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
