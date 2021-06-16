package com.tw.academy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CashRegisterTest {

	@Test
	void should_process_execute_printing_with_purchase() {
		//given
		Printer printer= mock(Printer.class);
		CashRegister cashRegister = new CashRegister(printer);
		Purchase purchase = mock(Purchase.class);
		String printResult="test";

		//when
		when(purchase.asString()).thenReturn(printResult);
		cashRegister.process(purchase);

		//then
		verify(printer).print(printResult);
	}

	@Test
	void should_process_execute_printing_by_spy() {
		//given
		SpyPrinter spyPrinter=new SpyPrinter();
		CashRegister cashRegister = new CashRegister(spyPrinter);
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		//verify that cashRegister.process will trigger print
		assertTrue(spyPrinter.hasExecutePrint);
	}



	private class SpyPrinter extends Printer {
		boolean hasExecutePrint=false;

		@Override
		public void print(String content) {
			hasExecutePrint=true;
		}
	}


}
