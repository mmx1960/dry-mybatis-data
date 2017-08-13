

package cn._94zichao.demo.wechat.service.impl;


import cn._94zichao.demo.wechat.mapper.WeUserMapper;
import cn._94zichao.demo.wechat.model.WeUser;
import cn._94zichao.demo.wechat.service.WeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeUserServiceImpl implements WeUserService {
	
	@Autowired
	private WeUserMapper weUserMapper;

	@Override
	public List<WeUser> selectForUpdate() {
		System.out.println("wechat service");
		List<WeUser> list=weUserMapper.selectForUpdate();
		return list;
	}

}

