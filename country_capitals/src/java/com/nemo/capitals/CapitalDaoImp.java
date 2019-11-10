package java.com.nemo.capitals;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.mysql.cj.x.protobuf.MysqlxConnection.CapabilitiesGetOrBuilder;

public class CapitalDaoImp implements CapitalDao {
	
	
	private SessionFactory factory;

	
	public List<CountryCapitalBean> getCountriesCapitalsList() {
		Session ses = factory.openSession();
		Query query = ses.createQuery("from countries_capitals");
		List<CountryCapitalBean> list = query.getResultList();
		return list;

	}

	public String getCapitalByCountry(String country) {
		Session ses = factory.openSession();
		Query query = ses.createQuery("select capital from CountryCapitalBean where "
				+ "country='"+country.toLowerCase()+"'");
		return query.toString();
	}

	public void addCountryCapital(CountryCapitalBean ccb) {
		Session ses = factory.openSession();
		Query query = ses.createQuery("insert into CountryCapitalBean set country='"+ccb.getCountry()+"' and capital='"
				+ccb.getCapital()+"'");
		System.out.println("Data added");
				

	}

}
