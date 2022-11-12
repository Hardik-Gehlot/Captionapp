package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import model.Caption;
import model.Category;
import model.User;

@Repository
public class DaoImpl implements Dao{
	@Autowired
	private HibernateTemplate template;
	
	@Transactional
	public int saveUser(User u) {
		int r = (Integer) template.save(u);
		return r;
	}
	
	
	@SuppressWarnings("unchecked")
	public User getUser(String username,String password) {
		Criterion c1 = Restrictions.and(Restrictions.eq("username",username), Restrictions.eq("password", password));
		List<User> users =  (List<User>) this.template.findByCriteria(DetachedCriteria.forClass(User.class)
				.add(c1));
		if(users!=null && users.size()>0) {
			return users.get(0);
		}else {
			return null;
		}
		
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}


	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = this.template.loadAll(Category.class);
		return categories;
	}

	@Transactional
	public int addCaption(Caption c) {
		int r = (Integer) this.template.save(c);
		return r;
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Caption> getCaptions(String category, String lang, int page) {
		return (List<Caption>)this.template.execute(new HibernateCallback<List<Caption>>() {
			@Override
			public List<Caption> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("deprecation")
				Criteria criteria = session.createCriteria(Caption.class);
				int first = ((page-1)*15);
				criteria.add(Restrictions.and(Restrictions.eq("category", category),Restrictions.eq("language", lang)));
				criteria.setFirstResult(first);
				criteria.setMaxResults(15);
				return criteria.list();
			}
		});
	}
	
	public int getTotalNumberOfCaptions(String category,String lang) {
		return this.template.execute(new HibernateCallback<Integer>() {

			@SuppressWarnings({ "unchecked", "deprecation" })
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Caption.class);
				criteria.setProjection(Projections.rowCount());
				criteria.add(Restrictions.and(Restrictions.eq("category", category),Restrictions.eq("language", lang)));
				List<Integer> list = criteria.list();
				return Integer.parseInt(String.valueOf(list.get(0)));
			}
		});
	}
	public List<User> searchUsers(String name){
		return this.template.execute(new HibernateCallback<List<User>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("deprecation")
				Criteria criteria = session.createCriteria(User.class);
				criteria.add(Restrictions.ilike("username", name,MatchMode.ANYWHERE));
				return criteria.list();
			}
		});
	}
	
	public List<Caption> searchCaption(String query,int page){
		return this.template.execute(new HibernateCallback<List<Caption>>() {

			@SuppressWarnings({ "unchecked", "deprecation" })
			@Override
			public List<Caption> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Caption.class);
				criteria.add(Restrictions.ilike("caption", query,MatchMode.ANYWHERE));
				int first = (page-1)*15;
				criteria.setFirstResult(first);
				criteria.setMaxResults(15);
				return criteria.list();
			}
		});
	}
	public int getTotalNumberOfSearchCaptions(String query) {
		return this.template.execute(new HibernateCallback<Integer>() {

			@SuppressWarnings({ "deprecation" })
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Caption.class);
				criteria.setProjection(Projections.rowCount());
				criteria.add(Restrictions.ilike("caption", query,MatchMode.ANYWHERE));
				return Integer.parseInt(String.valueOf(criteria.list().get(0)));
			}
		});
	}

	@Override
	public int getNumberOfPostsOfUser(int uid) {
		return this.template.execute(new HibernateCallback<Integer>() {

			@SuppressWarnings({ "deprecation" })
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Caption.class);
				criteria.setProjection(Projections.rowCount());
				criteria.add(Restrictions.eq("uid", uid));
				return Integer.parseInt(String.valueOf(criteria.list().get(0)));
			}
		});
	}


	@Override
	public int getNumberOfPostsLikedByUser(int uid) {
		return 0;
	}


	@Override
	public List<Caption> getCaptionOfUser(int uid, int page) {
		return this.template.execute(new HibernateCallback<List<Caption>>() {
			@SuppressWarnings({ "unchecked", "deprecation" })
			@Override
			public List<Caption> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Caption.class);
				criteria.add(Restrictions.eq("uid", uid));
				int first = (page-1)*15;
				criteria.setFirstResult(first);
				criteria.setMaxResults(15);
				return criteria.list();
			}
		});
	}
	
}
