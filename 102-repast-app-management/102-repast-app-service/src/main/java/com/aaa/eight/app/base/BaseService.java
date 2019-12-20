package com.aaa.eight.app.base;

import com.aaa.eight.app.page.PageInfos;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Project 102-repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/18 21:14
 **/
public abstract class BaseService<T> {

    /**
     *  继承此类后直接需要实现未实现的方法
     *  获取 Tmapper
     *@Author TLZ
     *@Date 21:16  2019/12/18
     *@Param
     *@return
     **/
    public abstract Mapper<T> getMapper();

    /**
     *    新增一条数据
     *@Author TLZ
     *@Date 21:17  2019/12/18
     *@Param
     *@return
     **/
    public Integer save(T t) throws Exception {
        return getMapper().insert(t);
    }

    /**
     *    根据主键更新数据
     *@Author TLZ
     *@Date 21:25  2019/12/18
     *@Param
     *@return
     **/
    public Integer update(T t) throws Exception {
        return getMapper().updateByPrimaryKey(t);
    }
    /**
     *    根据主键进行删除
     *@Author TLZ
     *@Date 21:26  2019/12/18
     *@Param
     *@return
     **/
    public Integer deleteByPrimaryKey(Object key) throws Exception {
        return getMapper().deleteByPrimaryKey(key);
    }

    /**
     *    根据实体类中的属性进行删除
     *@Author TLZ
     *@Date 21:27  2019/12/18
     *@Param
     *@return
     **/
    public Integer deletByModel(T t) throws Exception {
        return getMapper().deleteByExample(t);
    }

    /**
     *    通过主键查询数据
     *@Author TLZ
     *@Date 21:28  2019/12/18
     *@Param
     *@return
     **/
    public T selectById(Object key) throws Exception {
        return getMapper().selectByPrimaryKey(key);
    }

    /**
     *    查询所有数据
     *@Author TLZ
     *@Date 21:29  2019/12/18
     *@Param
     *@return
     **/
    public List<T> selectAll() throws Exception {
        return getMapper().selectAll();
    }

    /**
     *    根据属性确定一条数据(必须要有唯一键)
     *    或者是能通过几个属性来确定出一条数据(有且只有一条数据)
     *@Author TLZ
     *@Date 21:29  2019/12/18
     *@Param
     *@return
     **/
    public T selectByModel(T t) throws Exception {
        return getMapper().selectOne(t);
    }

    /**
     *    通过属性查询数据返回多条数据
     *@Author TLZ
     *@Date 21:29  2019/12/18
     *@Param
     *@return
     **/
    public List<T> selectByModeCondidation(T t) throws Exception {
        return getMapper().select(t);
    }

    /**
     *    带条件查询的分页  t:条件查询
     *@Author TLZ
     *@Date 21:30  2019/12/18
     *@Param
     *@return
     **/
    public List<T> selectPage(T t, PageInfos<T> pageInfos) throws Exception {
        return getMapper().selectByRowBounds(t, new RowBounds(pageInfos.getPageNum(), pageInfos.getPageSize()));
    }

    /**
     *    带条件查询所有条数
     *    如果需要查询所有条数则直接传入null(缺省，如果缺省则直接表示查询所有)
     *@Author TLZ
     *@Date 21:30  2019/12/18
     *@Param
     *@return
     **/
    public Integer selectCount(T t) throws Exception {
        return getMapper().selectCount(t);
    }


    /**
     *    带条件的分页查询
     *@Author TLZ
     *@Date 21:31  2019/12/18
     *@Param
     *@return
     **/
    public PageInfo<T> selectPageInfo(PageInfos<T> pageInfos) throws Exception {
        // 1.首先判断pageNum是否等于空--->如果等于空则说明是第一个访问
        if(pageInfos.getPageNum() == null) {
            pageInfos.setPageNum(0);
        }
        // 2.直接使用pageHelper进行分页
        // select * from user limit 0,3
        PageHelper.startPage(pageInfos.getPageNum(), pageInfos.getPageSize());
        // 3.查询所有的数据并返回list集合(该集合就是所有的数据但是没有分页)
        List<T> tList = this.selectByModeCondidation(pageInfos.getT());
        // 4.实现list集合的分页
        PageInfo<T> pageInfo = new PageInfo<T>(tList);
        pageInfo.setTotal(this.selectCount(pageInfos.getT()));
        return pageInfo;
    }


}
