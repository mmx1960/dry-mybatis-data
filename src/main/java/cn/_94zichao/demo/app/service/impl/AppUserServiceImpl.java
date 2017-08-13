
package cn._94zichao.demo.app.service.impl;


import cn._94zichao.demo.app.mapper.AppUserMapper;
import cn._94zichao.demo.app.model.AppUser;
import cn._94zichao.demo.app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AppUserServiceImpl implements AppUserService {
	
	@Autowired
	private AppUserMapper appUserMapper;

	@Override
	public List<AppUser>  selectNotUpdate() {
		System.out.println("app service");
		List<AppUser> list=appUserMapper.selectForUpdate();
		return list;

	}

}

