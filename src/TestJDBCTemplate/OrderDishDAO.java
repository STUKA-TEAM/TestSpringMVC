package TestJDBCTemplate;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import sun.jdbc.odbc.OdbcDef;

public class OrderDishDAO {
private DataSource dataSource;
private JdbcTemplate jdbcTemplate;
public void setDataSource(DataSource dataSource){
	this.dataSource = dataSource;
	this.jdbcTemplate = new JdbcTemplate(dataSource);
}

//Create
/**
 * 
 * @param dishName
 * @param price
 * @param discribe
 * @param picture
 * @return auto-generated key
 */
public int createOrderDish(final OrderDish orderDish){
	int result = 0;
	final String SQL = "insert into order_dishes(DishName, Price, "
			   + "Discribe, Picture) values (?,?,?,?)";
	
	KeyHolder keyHolder = new GeneratedKeyHolder();
	
	result = jdbcTemplate.update(new PreparedStatementCreator() {
	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	            PreparedStatement ps =
	                connection.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
	            System.out.println("HERE");
	            ps.setString(1, orderDish.getDishName());
	            ps.setBigDecimal(2, orderDish.getPrice());
	            ps.setString(3, orderDish.getDiscribe());
	            ps.setString(4, orderDish.getPicture());
	            
	            return ps;
	        }
	    },
	    keyHolder);
	
	return keyHolder.getKey().intValue();	
}

//Delete
/**
 * 
 * @param id
 * @return number of effected rows
 */
public int deleteById(int id){
	String SQL = "delete from order_dishes where DishId = ?";
	int effectedRowNum = jdbcTemplate.update(SQL,id);
	return effectedRowNum;
}


//Update
/**
 * 
 * @param id
 * @param name
 * @param price
 * @return
 */
public int updateById(int id, String name, BigDecimal price){
	String SQL = "update order_dishes set DishName = ?, Price = ? where DishId = ?";
	int effectedRowNum = jdbcTemplate.update(SQL,new Object[]{name,price,id});
	return effectedRowNum;
}

//Query
/**
 * 
 * @param id
 * @return the OrderDish object
 */
public OrderDish getOrderDishById(int id){
	String SQL = "select * from order_dishes where DishId = ?";
	OrderDish orderDish = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new OrderDishMapper());
	return orderDish;
}

/**
 * 
 * @return the list of OrderDish object
 */
public List<OrderDish> getOrderDishList(){
	String SQL = "select * from order_dishes"; 
	List<OrderDish> list = jdbcTemplate.query(SQL, new OrderDishMapper());
	return list;
}

}
