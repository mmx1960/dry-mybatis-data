package cn._94zichao;


import cn._94zichao.demo.app.model.AppUser;
import cn._94zichao.demo.app.service.AppUserService;
import cn._94zichao.demo.wechat.model.WeUser;
import cn._94zichao.demo.wechat.service.WeUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZiChaoDryDataApplicationTests {
	
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private WeUserService weUserService;
	
	@Test
	public void testSay(){
		for (AppUser user:appUserService.selectNotUpdate())
		{
			System.out.println(user.getName()+":"+user.getPhone());
		}
		for (WeUser user:weUserService.selectForUpdate())
		{
			System.out.println(user.getNickname()+":"+user.getMobile());
		}
	}
	


}
