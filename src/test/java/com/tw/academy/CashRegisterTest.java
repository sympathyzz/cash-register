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

}
