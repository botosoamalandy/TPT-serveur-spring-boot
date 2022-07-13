package com.tptransversal.rdvvaksiny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpTransversalRdvVaksinyApplication{
	
//	@Autowired
//	private TypeUtilisateurRep rep;

	public static void main(String[] args) {
		SpringApplication.run(TpTransversalRdvVaksinyApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		try {
//			List<TypeUtilisateur> lid =  rep.findAll();
//			int size = lid.size();
//			for (int i = 0; i < size; i++) {
//				System.out.println(lid.get(i).toString());
//				
//			}
//			System.out.println("--------------------------------------------------");
//			rep.save(new TypeUtilisateur(4,"Tmp", 1));
//			System.out.println("okokokok "+rep.findAll().size());
//			System.out.println("--------------------------------------------------");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

}
