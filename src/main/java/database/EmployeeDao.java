package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeDao 
{
	private JdbcTemplate jdbcTemplate;
	
	//The setter method is used by applicationContext.xml to pass an instance of JdbcTemplate.
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveEmployee(Employee employee)
	{
		
		String query = "INSERT INTO employee VALUES('" + employee.getId() + "','" + employee.getName() + "','" + employee.getSalary() + "')";
		
		try {
			return jdbcTemplate.update(query);
		}catch (DuplicateKeyException duplicateValue) 
		{
			System.out.println("Duplication of key value " + employee.getId());
		}
		return 0;
	}
	
	public Boolean saveEmployeeByPreparedStatement(Employee employee)
	{
		String query = "INSERT INTO employee VALUES(?,?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException {
				statement.setInt(1, employee.getId());
				statement.setString(2, employee.getName());
				statement.setInt(3, employee.getSalary());
				return statement.execute();
			}
		});
	}
	
	/*
	 * SimpleJdbcTemplate class wraps the JdbcTemplate class and provides the update method where we can pass arbitrary number of arguments.
	 */
	public int updateEmployeeByPreparedStatement(Employee employee)
	{
		String query = "UPDATE employee SET name=? where id=?";
		return jdbcTemplate.update(query, employee.getName(), employee.getId());
	}
	
	public List<Employee> getAllEmployees()
	{
		String query = "SELECT * FROM employee";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Employee>>() {
			@Override
			public List<Employee> extractData(ResultSet rows) throws SQLException, DataAccessException 
			{
				List<Employee> employees = new ArrayList<Employee>();
				while(rows.next())
				{
					employees.add(new Employee(rows.getInt(1), rows.getString(2), rows.getInt(3)));
				}
				return employees;
			}
		});
	}
	
	public int updateEmployee(Employee employee)
	{
		String query = "update employee set name='"+employee.getName()+"',salary='"+employee.getSalary()+"' where id='"+employee.getId()+"'";
		return jdbcTemplate.update(query);
	}
	
	public int deleteEmployee(Employee employee)
	{
		String query = "DELETE FROM employee where id='" + employee.getId() + "'";
		return jdbcTemplate.update(query);
	}

	public Employee getEmployeeById(int id) 
	{
		String query = "SELECT * FROM employee where id=?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Employee>() {
			@Override
			public Employee doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException 
			{
				Employee employee = new Employee();
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery();
				while(result.next())
				{
					employee.setId(result.getInt(1));
					employee.setName(result.getString(2));
					employee.setSalary(result.getInt(3));
				}
				return employee;
			}
		});
	}

	public int deleteEmployeeByID(int id) 
	{
		String query = "DELETE FROM employee where id=?";
		return jdbcTemplate.update(query, id);
	}

	public List<Employee> getEmployeesByPage(int pageId, int totalPerPage) 
	{
		String query = "SELECT * FROM employee LIMIT ?, ?";
		
		return jdbcTemplate.execute(query, new PreparedStatementCallback<List<Employee>>() {
			@Override
			public List<Employee> doInPreparedStatement(PreparedStatement statement) throws SQLException, DataAccessException 
			{
				List<Employee> employees = new ArrayList<Employee>();
				statement.setInt(1, pageId);
				statement.setInt(2, totalPerPage);
				ResultSet result = statement.executeQuery();
				while(result.next())
				{
					employees.add(new Employee(result.getInt(1), result.getString(2), result.getInt(3)));
				}
				return employees;
			}
		});
	}
}
