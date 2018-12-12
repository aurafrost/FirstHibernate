import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry s=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(s).getMetadataBuilder().build();
		
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		//add to db
		/*
		StudentTest2 obj=new StudentTest2();
		obj.setId(2);
		obj.setName("John");
		obj.setAddress("Atlanta");
		obj.setFees(30000);
		
		session.save(obj);
		t.commit();
		*/
		
		//delete
		/*
		StudentTest2 obj=session.get(StudentTest2.class, 1);
		session.delete(obj);
		t.commit();
		*/
		
		//update
		/*
		StudentTest2 obj=session.get(StudentTest2.class, 2);
		obj.setAddress("Paris");
		session.update(obj);
		t.commit();
		*/
		
		//Criteria
		/*
		Criteria c=session.createCriteria(StudentTest2.class);
		List<StudentTest2>obj1=c.list();
		for(StudentTest2 st:obj1){
			System.out.println(st.getId()+","+st.getName()+","+st.getAddress()+","+st.getFees());
		}
		*/
		
		//restrictions
		/*
		c=session.createCriteria(StudentTest2.class);
		c.add(Restrictions.gt("fees",20000.00));
		c.addOrder(Order.desc("fees"));
		obj1=c.list();
		for(StudentTest2 st:obj1){
			System.out.println(st.getId()+","+st.getName()+","+st.getAddress()+","+st.getFees());
		}
		*/
		
		//projection
		/*
		c=session.createCriteria(StudentTest2.class);
		c.setProjection(Projections.property("name"));
		List<String>str=c.list();
		for(String st:str){
			System.out.println(st);
		}
		*/
		
		//list entries in table
		/*
		List ss=session.createQuery(" from studenttest2").list();
		for(Iterator i=ss.iterator();i.hasNext();) {
			StudentTest2 o=(StudentTest2)i.next();
			System.out.println(o.getId()+","+o.getName()+","+o.getAddress()+","+o.getFees());
		}
		*/
		
		//Hibernate Query Language-HQL
		Query q=session.createQuery(" from StudentTest2 s where s.fees> :fees");
		q.setParameter("fees", 25000.00);
		List it=q.getResultList();
		for(Iterator i=it.iterator();i.hasNext();) {
			StudentTest2 o=(StudentTest2)i.next();
			System.out.println(o.getId()+","+o.getName()+","+o.getAddress()+","+o.getFees());
		}
		
		q=session.createQuery("select sum(fees) from StudentTest2");
		List<Integer>p=q.getResultList();
		System.out.println(p.get(0));
		
		session.close();
		factory.close();
	}

}
