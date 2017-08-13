

package cn._94zichao.demo.wechat.mapper;


import cn._94zichao.demo.wechat.model.WeUser;
import cn._94zichao.mybatis.annotation.DataSource;

import java.util.List;

@DataSource("wechat")
public interface WeUserMapper  {
    public abstract List<WeUser> selectForUpdate();

}

