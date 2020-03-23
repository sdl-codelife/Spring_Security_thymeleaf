package com.sdl.xadmin.dao;

import com.sdl.xadmin.entity.MenuRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (MenuRole)表数据库访问层
 *
 * @author sdl
 * @since 2020-03-22 15:15:41
 */
public interface MenuRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    MenuRole queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MenuRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param menuRole 实例对象
     * @return 对象列表
     */
    List<MenuRole> queryAll(MenuRole menuRole);

    /**
     * 新增数据
     *
     * @param menuRole 实例对象
     * @return 影响行数
     */
    int insert(MenuRole menuRole);

    /**
     * 修改数据
     *
     * @param menuRole 实例对象
     * @return 影响行数
     */
    int update(MenuRole menuRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}