package TestJDBCTemplate;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrderDishDAO {
public static void main(String[] strings){
	ApplicationContext context = 
			new ClassPathXmlApplicationContext("All-Modules.xml");
	OrderDishDAO orderDishDAO = (OrderDishDAO)context.getBean("OrderDishDAO");
	//Test Create
	OrderDish newOrderDish = new OrderDish();
	newOrderDish.setDishName("鱼香肉丝");
	newOrderDish.setPrice(new BigDecimal(19.50));
	newOrderDish.setDiscribe("美味可口，香气难挡");
	newOrderDish.setPicture("/XXXXX/XXX.jpg");
	int insertID = orderDishDAO.createOrderDish(newOrderDish);
	System.out.println("ID:" + insertID);
	
	//Test Delete
	int effectedRowNum = orderDishDAO.deleteById(6);
	System.out.println("EffectedRowNum:" + effectedRowNum);
	
	//Test Update
	int id = 7;
    String newName = "小鸡蘑菇";
	BigDecimal newPrice = new BigDecimal(30);
	orderDishDAO.updateById(id,newName,newPrice);
	
	//Test getItemById
	OrderDish orderDish = orderDishDAO.getOrderDishById(3);
	System.out.println("DishName:" + orderDish.getDishName());
	System.out.println("DishPrice:" + orderDish.getPrice());
	
	//Test getItems
	List<OrderDish> list = orderDishDAO.getOrderDishList();
	System.out.println("List Of Table");
	for (OrderDish	orderDishItem : list) {
		System.out.println("DishId:" + orderDishItem.getDishId());
	}
}
}
