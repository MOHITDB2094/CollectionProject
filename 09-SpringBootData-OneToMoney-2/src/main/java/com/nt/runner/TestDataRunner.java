package com.nt.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Branch;
import com.nt.entity.College;
import com.nt.repo.BranchRepo;
import com.nt.repo.CollegeRepository;

@Component
public class TestDataRunner implements CommandLineRunner {

	@Autowired
	 BranchRepo brepo;
	
	@Autowired
	 CollegeRepository crepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Branch br1 = new Branch();
		br1.setBname( "Mech");
		br1.setBid(100);
		Branch br2 = new Branch( );
		br2.setBname("IT");
		br2.setBid(101);
		Branch br3 = new Branch();
		br3.setBname("Elect");
		br3.setBid(102);
		Branch br4 = new Branch( );
		br4.setBname("Comp");
		br4.setBid(103);
		
		College cg1 = new College(/* 125, "Tanu",Arrays.asList(br1,br2) */ );
		//cg1.setCid(125);
		cg1.setCname("BN_Pusad");
		cg1.setBlist(Arrays.asList(br1,br2));
		
		College cg2 = new College(/* 150, "Vaishnavi", Arrays.asList(br3,br4) */);
		//cg2.setCid(150);
		cg2.setCname("MIT_HYD");
		cg2.setBlist(Arrays.asList(br3,br4));
		
		brepo.save(br1);
		brepo.save(br2);
		brepo.save(br3);
		brepo.save(br4);
		
		crepo.save(cg1);
		crepo.save(cg2);
		
		
	}

}
