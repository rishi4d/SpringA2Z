package com.practice.unit_testing.mockito.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class SomeBusinessImplMockTest {

	@Test
	void Test() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 20, 21, 22, 23, 34, 67, 79 });
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
		assertEquals(someBusinessImpl.findTheGreatestFromAllData(), 79);
	}

}