package com.chinasoft.MyBatisDemo.dao;

import java.util.List;
import java.util.Map;

public interface IAdminDao {
public List<Map<String,Object>>  selectGoodsAll();
public List<Map<String,Object>>  selectUserAll();
/* 在接口中  所有的DML数据更新指令 直接返回布尔值
 * 不需要在 model层配置*/
public int insertGoodByOne(Map<String,Object> map);
public int deleteGoodById(int goodsId);
public List<Map<String,Object>> selectGoodByWhere(Map<String,Object> map);
public int deleteGoods(String[] goodsId);
}
