

package cn._94zichao.demo.app.mapper;


import cn._94zichao.demo.app.model.AppUser;
import cn._94zichao.mybatis.annotation.DataSource;

import java.util.List;
@DataSource("app")
public interface  AppUserMapper  {
    public List<AppUser> selectForUpdate();
}

