
package cn._94zichao.demo.center.service.impl;


import cn._94zichao.demo.center.mapper.UserMapper;
import cn._94zichao.demo.center.model.User;
import cn._94zichao.demo.center.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HelloServiceImpl implements HelloService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void updateLast(List<User> list) {
	
	  System.out.println("center service");
	  userMapper.updateLast(list);


	}

}

