package kr.co.ca;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {
	@Autowired
	private DataSource dataFactory;//기존까지는 이렇게 선언하면 datafactory는 null이었지만
								//autowired가 springframework가 관리하는 bean을 자동으로 넣어준다
	@Test//테스트할 메소드에는 test어노테이션을 반드시 붙여준다.//반환형은 반드시 void 파라미터는 반드시 없어야 한다.
	public void testConnection() {
		//테스트시 모든 메서드를 테스트하려면 그냥 우클릭을통해 하고 특정 메소드만 하고 싶다면 메소드이름을 드래그 한 후 runas junit
		Connection conn = null;
		try {
			conn = dataFactory.getConnection();
			System.out.println("커넥션연결");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	@Test
	public void testConnection2() {
		Connection conn = null;
		try {
			conn = dataFactory.getConnection();
			System.out.println("커넥션연결");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	@Test
	public void testConnection3() {
		Connection conn = null;
		try {
			conn = dataFactory.getConnection();
			System.out.println("커넥션연결");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
