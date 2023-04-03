package com.join;
        import java.util.Iterator;
		import java.util.List;
        import org.hibernate.Query;
		import org.hibernate.Session;
		import org.hibernate.SessionFactory;
		import org.hibernate.cfg.Configuration;
         public class urLogic {
            public static void main(String args[])
			{
                Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml"); 

				SessionFactory factory = cfg.buildSessionFactory();
				Session session = factory.openSession();		

				Query qry= session.createQuery("select v.vendName,v.customerName from vendor v inner join v.children c on v.vendid=c.forevenId");
				List l = qry.list();
				Iterator it=l.iterator();

				while(it.hasNext())
				{
					Object rows[] = (Object[])it.next();
					System.out.println(rows[0]+ " -- " +rows[1]);
				}
				}
			}