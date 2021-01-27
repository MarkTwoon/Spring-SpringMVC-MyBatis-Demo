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
    /*dao�� ����ʵ����*/
    IAdminDao mapper=session.getMapper(IAdminDao.class);
    /*����dao�� ִ�ж�Ӧ��SQL����*/
   /* List<Map<String,Object>>  list=mapper.selectGoodsAll();
    System.out.println(list);
    System.out.println("SQLָ��ִ�гɹ�");
    
    List<Map<String,Object>> userList=mapper.selectGoodsAll();
    System.out.println(userList);*/
     /*for(int i=0;i<3;i++){
    	List<Map<String,Object>>  list=mapper.selectGoodsAll();
    	System.out.println(list);
        System.out.println("SQLָ��ִ�гɹ�����"+i+"��");
    } 
    Map<String,Object> map=new HashMap<String, Object>();
    map.put("goodsName", "��Ȫˮ");
    map.put("goodsType", "����ˮ");
    map.put("goodsNumber", "60");
    map.put("goodsPrice", "2");
    �����������   ��Ʒ������
    if(mapper.insertGoodByOne(map)>0){
    System.out.println("���������ɹ���");	
    }else{
    	System.out.println("��������ʧ�ܣ���");	
    } */
   /*  if(mapper.deleteGoodById(2)>0){
    	 System.out.println("����ɾ���ɹ���");	
     }else{
    	 System.out.println("����ɾ��ʧ�ܣ�");	
     }*/
     /*ע����ɾ��  ��Ҫ�����ύ��*/
    /* session.commit();*/
    /*���������ݺ�  �ٴβ�ѯ��Ʒ������ ����û�����ݼ�ʱ���£� */
    /*List<Map<String,Object>>  list=mapper.selectGoodsAll();
	System.out.println(list);*/
    /*Map<String,Object> map=new HashMap<String, Object>();
   map.put("goodsName", "��");
    map.put("goodsType", "��");
    System.out.println(
    		mapper.selectGoodByWhere(map));*/
    /*String []goodsId={"1","3","6"};
    int a=mapper.deleteGoods(goodsId);
    System.out.println("ɾ��ָ�� Ӱ����:"+a);
    session.commit();*/
    Map<String,Object> map=new HashMap<String, Object>();
    map.put("goodsId", "8");
    System.out.println(mapper.selectGoodsAndUserByWhere(map));
 
    Map<String,Object> map1=new HashMap<String, Object>();
    map1.put("userId", "2");
    System.out.println(mapper.selectGoodsAndUserByWhere(map1));
    
    Map<String,Object> map2=new HashMap<String, Object>();
    map2.put("goodsName", "ˮ");
    System.out.println(mapper.selectGoodsAndUserByWhere(map2));
    map2.put("userName", "��");
    System.out.println(mapper.selectGoodsAndUserByWhere(map2));
    
    MyBatisConfig.closeMyBatis(session); 	 
	}

}
