package com.shreeram.demosb.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Parameter;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shreeram.demosb.util.DemoSbUtil;
@Repository
@Transactional
public class DemoSbDaoImpl<E, PK extends Serializable> implements DemoSbDao<E,PK>{

	@Autowired
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<?> findVOByNamedQuery(Class<?> voClass, String queryName, Map<String, Object> queryParams) {
		Query<?> query = sessionFactory.getCurrentSession().getNamedQuery(queryName);
		setQueryParams(query, queryParams);
		//query.setResultTransformer(Transformers.aliasToBean(voClass)).list();/*current version 5.6 ,deprecated since 5.2, need to think different approach*/
		return query.list();
	}

	private void setQueryParams(Query<?> query, Map<String, Object> queryParams) {
		Set<Parameter<?>> params = query.getParameters();
		if (params != null) {
			for (Parameter<?> param : params) {
				if (queryParams.get(param.getName()) instanceof Collection) {
					query.setParameterList(param.getName(), (List) queryParams.get(param.getName()));
				} else {
					query.setParameter(param.getName(), queryParams.get(param.getName()));
				}

			}
		}
	}
	
	private void setQuerySQLParams(SQLQuery query,List paramList) {
		if(paramList!=null && paramList.size()>0) {
			for(int i=0;i<paramList.size();i++) {
				query.setParameter(i, paramList.get(i));
			}
		}
	}
	
	private void setQuerySQLParams(Query query,List paramList) {
		if(paramList!=null && paramList.size()>0) {
			for(int i=0;i<paramList.size();i++) {
				query.setParameter(i, paramList.get(i));
			}
		}
	}

	@Override
	public E merge(E detachedInstance) {
		return (E) sessionFactory.getCurrentSession().merge(detachedInstance);
	}

	@Override
	public PK save(E newInstance) {
		return (PK) sessionFactory.getCurrentSession().save(newInstance);
	}

	@Override
	public int update(String queryName, Map<String, Object> queryParams) {
		Query q = sessionFactory.getCurrentSession().getNamedQuery(queryName);
		setQueryParams(q, queryParams);
		return q.executeUpdate();
	}

	@Override
	public void delete(E newInstance) {
		sessionFactory.getCurrentSession().delete(newInstance);
	}

	@Override
	public Map<String, String> getSchemaDetails() {
		String url = "";
		Map<String,String> dbDetailsMap=null;
		try {
			SessionFactoryImplementor sfi = (SessionFactoryImplementor) sessionFactory;
			SessionFactoryOptions sfo = sfi.getSessionFactoryOptions();
			ConnectionProvider cp = sfo.getServiceRegistry().getService(ConnectionProvider.class);
			Connection c = cp.getConnection();
			DatabaseMetaData dmd = c.getMetaData();
			url = dmd.getURL();
			dbDetailsMap = getDatabaseMachineDetails(url);
			String uname = dmd.getUserName();
			dbDetailsMap.put("DB_USERNAME", uname);
			dbDetailsMap.put("DB_PASSWORD", DemoSbUtil.DB_PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private Map<String, String> getDatabaseMachineDetails(String url) {
		Map<String, String> ddm = new HashMap<String,String>();
		String ip = url.substring(url.lastIndexOf("//")+2,url.lastIndexOf(":"));
		String port = url.substring(url.lastIndexOf(":")+1,url.lastIndexOf("/"));
		String schema = url.substring(url.lastIndexOf("/")+1,url.length());		
		ddm.put("DB_IP", ip);
		ddm.put("DB_PORT", port);
		ddm.put("DB_SCHEMA", schema);
		return ddm;
	}

	@Override
	public List<?> selectNativeQuery(String query, List paramList) {
		SQLQuery sqlQueryObj = sessionFactory.getCurrentSession().createSQLQuery(query);
		setQuerySQLParams(sqlQueryObj, paramList);
 		return sqlQueryObj.list();
	}

	@Override
	public int insertNativeQuery(String query, List paramList) {
		SQLQuery sqlQueryObj=null;
		try {
			sqlQueryObj=sessionFactory.getCurrentSession().createSQLQuery(query);
			setQuerySQLParams(sqlQueryObj, paramList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlQueryObj.executeUpdate();
	}

	@Override
	public int updateNativeQuery(String query) {
		SQLQuery sqlQueryObj = sessionFactory.getCurrentSession().createSQLQuery(query);
		setQuerySQLParams(sqlQueryObj, null);
 		return sqlQueryObj.executeUpdate();
	}

}
