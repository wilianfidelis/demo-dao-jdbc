package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartamentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: seller findById ====");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findById ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: seller findById ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		/*System.out.println("\n=== Test 4: seller Insert ====");
		Seller newSeller = new Seller(null, "Wilian fidelis", "wilian.fidelis@gmail.com", new Date(), 1200.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id = " + newSeller.getId());*/
		
		System.out.println("\n=== Test 5: seller Update ====");
		seller = sellerDao.findById(1);
		seller.setName("Pepe");
		sellerDao.update(seller);
		System.out.println("Update complete "+ seller.getName());
	}
}
