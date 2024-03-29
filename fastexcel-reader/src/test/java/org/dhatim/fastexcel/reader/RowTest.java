package org.dhatim.fastexcel.reader;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.dhatim.fastexcel.reader.Resources.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RowTest {

	@Test
	public void testGetCellByAddress() throws IOException {
		try (InputStream inputStream = open("/xlsx/issue.xlsx");
		     ReadableWorkbook excel = new ReadableWorkbook(inputStream)) {
			Sheet firstSheet = excel.getFirstSheet();
			Row row = firstSheet.read().get(0);
			System.out.println(row.getCellText(0));
			assertNotNull(row);
			CellAddress addressA1 = new CellAddress("C1");
			Cell cellIndex0 = row.getCell(2);
			System.out.println(cellIndex0.getValue());
			Cell cellA1 = row.getCell(addressA1);
			System.out.println(cellA1.getAddress());//C1
			assertEquals(addressA1, cellIndex0.getAddress());
			System.out.println(cellIndex0.getAddress());
			assertEquals(cellIndex0, cellA1);
			System.out.println();
		}
	}
}
  