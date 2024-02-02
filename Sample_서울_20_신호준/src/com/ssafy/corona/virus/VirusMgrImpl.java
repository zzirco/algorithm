package com.ssafy.corona.virus;

import java.util.Arrays;

public class VirusMgrImpl implements VirusMgr {
	private Virus[] virus;
	private int index;
	
	private static VirusMgr instance = new VirusMgrImpl();
	private VirusMgrImpl() {
		virus=new Virus[100];		
	}
	public static VirusMgr getInstance() {
		return instance;
	}
	
	@Override
	public void add(Virus v) throws DuplicatedException{
		try {
			search(v.getName());
			throw new DuplicatedException("코로나19: 등록된 바이러스입니다.");
		} catch (NotFoundException e) {
			virus[index++]=v;
		}
	}
	@Override
	public Virus[] search() {
		return Arrays.copyOf(virus, index);
	}
	@Override
	public Virus search(String name) throws NotFoundException{
		for(int i=0; i<index; i++) {
			if(virus[i].getName().equals(name)) return virus[i];
		}
		throw new NotFoundException(name+": 미등록 바이러스입니다.");
	}
	


}
