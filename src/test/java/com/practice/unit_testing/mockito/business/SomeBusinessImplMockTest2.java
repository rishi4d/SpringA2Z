package com.practice.unit_testing.mockito.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest2 {

	@Mock
	private DataService dataServiceMock;

	@InjectMocks
	private SomeBusinessImpl someBusinessImpl;

	@Test
	void findTheGreatestFromAllData_BasicScenario() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 20, 21, 22, 23, 34, 67, 79 });
		assertEquals(someBusinessImpl.findTheGreatestFromAllData(), 79);
	}
	
	@Test
	void findTheGreatestFromAllData_OneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 20 });
		assertEquals(someBusinessImpl.findTheGreatestFromAllData(), 20);
	}
	
	@Test
	void findTheGreatestFromAllData_EmptyArray() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { });
		assertEquals(someBusinessImpl.findTheGreatestFromAllData(), Integer.MIN_VALUE);
	}
	
	@Test
	void simpleTest() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(4);
		assertEquals(4, listMock.size());
	}
	
	@Test
	void multipleReturns() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(1).thenReturn(2);
		assertEquals(1, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}
	
	@Test
	void parameters() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("String");
		assertEquals("String", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}
	
	@Test
	void genericParameters() {
		List listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("String");
		assertEquals("String", listMock.get(0));
		assertEquals("String", listMock.get(1));
	}
}