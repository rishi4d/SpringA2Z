package com.practice.unit_testing.mockito.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void Test() {
		DataServiceStub dataServiceStub = new DataServiceStub();
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceStub);
		assertEquals(someBusinessImpl.findTheGreatestFromAllData(), 79);
	}

}

class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 20, 21, 22, 23, 34, 67, 79 };
	}
}