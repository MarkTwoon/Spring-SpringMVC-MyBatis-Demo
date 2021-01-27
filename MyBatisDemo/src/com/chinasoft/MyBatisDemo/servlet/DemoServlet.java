package com.chinasoft.MyBatisDemo.servlet;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.chinasoft.MyBatisDemo.config.MyBatisConfig;
import com.chinasoft.MyBatisDemo.dao.IAdminDao;

public class DemoServlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  SqlSession  session=MyBatisConfig.openMyBatis();
    /*dao层 抽象实例化*/
    IAdminDao mapper=session.getMapper(IAdminDao.class);
    /*调用dao层 执行对应的SQL方法*/
   /* List<Map<String,Object>>  list=mapper.selectGoodsAll();
    System.out.println(list);
    System.out.println("SQL指令执行成功");
    
    List<Map<String,Object>> userList=mapper.selectGoodsAll();
    System.out.println(userList);*/
     /*for(int i=0;i<3;i++){
    	List<Map<String,Object>>  list=mapper.selectGoodsAll();
    	System.out.println(list);
        System.out.println("SQL指令执行成功，第"+i+"次");
    } 
    Map<String,Object> map=new HashMap<String, Object>();
    map.put("goodsName", "矿泉水");
    map.put("goodsType", "饮用水");
    map.put("goodsNumber", "60");
    map.put("goodsPrice", "2");
    在这里更新了   商品表数据
    if(mapper.insertGoodByOne(map)>0){
    System.out.println("数据新增成功！");	
    }else{
    	System.out.println("数据新增失败！！");	
    } */
   /*  if(mapper.deleteGoodById(2)>0){
    	 System.out.println("数据删除成功！");	
     }else{
    	 System.out.println("数据删除失败！");	
     }*/
     /*注意增删改  需要事物提交！*/
    /* session.commit();*/
    /*更新完数据后  再次查询商品表数据 看有没有数据及时更新！ */
    /*List<Map<String,Object>>  list=mapper.selectGoodsAll();
	System.out.println(list);*/
    /*Map<String,Object> map=new HashMap<String, Object>();
   map.put("goodsName", "瓜");
    map.put("goodsType", "货");
    System.out.println(
    		mapper.selectGoodByWhere(map));*/
    /*String []goodsId={"1","3","6"};
    int a=mapper.deleteGoods(goodsId);
    System.out.println("删除指令 影响行:"+a);
    session.commit();*/
    Map<String,Object> map=new HashMap<String, Object>();
    map.put("goodsId", "8");
    System.out.println(mapper.selectGoodsAndUserByWhere(map));
 
    Map<String,Object> map1=new HashMap<String, Object>();
    map1.put("userId", "2");
    System.out.println(mapper.selectGoodsAndUserByWhere(map1));
    
    Map<String,Object> map2=new HashMap<String, Object>();
    map2.put("goodsName", "水");
    System.out.println(mapper.selectGoodsAndUserByWhere(map2));
    map2.put("userName", "张");
    System.out.println(mapper.selectGoodsAndUserByWhere(map2));
    
    MyBatisConfig.closeMyBatis(session); 	 
	}

}
