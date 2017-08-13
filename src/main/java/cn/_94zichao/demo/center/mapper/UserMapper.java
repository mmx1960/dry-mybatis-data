

package cn._94zichao.demo.center.mapper;


import cn._94zichao.demo.center.model.User;
import cn._94zichao.mybatis.annotation.DataSource;

import java.util.List;
@DataSource("center")
public interface UserMapper  {
    void updateLast(List<User> list);


}

