package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller findById ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller e : list) {
			System.out.println(e);
		}
		
		System.out.println("=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller e : list) {
			System.out.println(e);
		}
		
		/*System.out.println("=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		
		System.out.println("Inserted! New id = " + newSeller.getId());*/
		
		System.out.println("=== TEST 5: seller update ===");
		Seller seller2 = sellerDao.findById(1);
		seller2.setName("Martha Waine");
		sellerDao.update(seller2);
		System.out.println("Update completed!");
		
		System.out.println("=== TEST 6: seller delete ===");
		System.out.print("Enter id for delete test: ");
		Integer id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		sc.close();
	}
}
