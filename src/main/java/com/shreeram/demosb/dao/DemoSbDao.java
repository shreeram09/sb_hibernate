package com.shreeram.demosb.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


public interface DemoSbDao<E, PK extends Serializable> {
	E merge(E detachedInstance);
	public PK save(E newInstance);
	public int update(String queryName,Map<String,Object> queryParams);
	public void delete(E newInstance);
	public List<?> findVOByNamedQuery(Class<?> voClass, String queryName, Map<String, Object> queryParams) ;
	public Map<String,String> getSchemaDetails();
	public List<?> selectNativeQuery(String query,List paramList);
	public int insertNativeQuery(String query,List paramList);
	public int updateNativeQuery(String query);
	
}
