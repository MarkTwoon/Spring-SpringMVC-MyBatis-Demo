package com.chinasoft.MyBatisDemo.dao;

import java.util.List;
import java.util.Map;

public interface IAdminDao {
public List<Map<String,Object>>  selectGoodsAll();
public List<Map<String,Object>>  selectUserAll();
/* �ڽӿ���  ���е�DML���ݸ���ָ�� ֱ�ӷ��ز���ֵ
 * ����Ҫ�� model������*/
public int insertGoodByOne(Map<String,Object> map);
public int deleteGoodById(int goodsId);
public List<Map<String,Object>> selectGoodByWhere(Map<String,Object> map);
public int deleteGoods(String[] goodsId);
}
