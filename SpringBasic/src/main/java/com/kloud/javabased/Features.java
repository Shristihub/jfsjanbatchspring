package com.kloud.javabased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Features {
	private String os;
	private String memory;
	public String getOs() {
		return os;
	}
	@Value("Android")
	public void setOs(String os) {
		this.os = os;
	}
	public String getMemory() {
		return memory;
	}
	@Value("128MB Ram")
	public void setMemory(String memory) {
		this.memory = memory;
	}
	@Override
	public String toString() {
		return "Features [os=" + os + ", memory=" + memory + "]";
	}
	

}
