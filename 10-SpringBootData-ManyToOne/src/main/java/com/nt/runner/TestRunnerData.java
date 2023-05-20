package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Biscuits;
import com.nt.entity.Package;
import com.nt.repo.BiscuitRepo;
import com.nt.repo.PackageRepo;

@Component
public class TestRunnerData implements CommandLineRunner {

	@Autowired
	BiscuitRepo brepo;
	
	@Autowired
	PackageRepo prepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		Biscuits biscuit = new Biscuits();
		biscuit.setBscName("PARLE");
		biscuit.setBiscNumber(6);
		
		Package p1 = new Package();
		p1.setBiscuits(biscuit);
		Package p2 = new Package();
		p2.setBiscuits(biscuit);
		Package p3 = new Package();
		p3.setBiscuits(biscuit);
		Package p4 = new Package();
		p4.setBiscuits(biscuit);
		
		brepo.save(biscuit);
		
		prepo.save(p1);
		prepo.save(p2);
		prepo.save(p3);
		prepo.save(p4);

	}

}
