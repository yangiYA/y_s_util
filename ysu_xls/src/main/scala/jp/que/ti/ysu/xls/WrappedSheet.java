package jp.que.ti.ysu.xls;

import java.util.Iterator;

import org.apache.poi.hssf.util.PaneInformation;
import org.apache.poi.ss.usermodel.AutoFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

class WrappedSheet<SHEET extends Sheet> implements Sheet {
	protected SHEET wrappedSheet;

	public WrappedSheet(SHEET sheet) {
		this.wrappedSheet = sheet;
	}

	@Override
	public Workbook getWorkbook() {
		return wrappedSheet.getWorkbook();
	}

	@Override
	public Row createRow(int rownum) {
		return wrappedSheet.createRow(rownum);
	}

	@Override
	public void removeRow(Row row) {
		wrappedSheet.removeRow(row);
	}

	@Override
	public Row getRow(int rowIndex) {
		return wrappedSheet.getRow(rowIndex);
	}

	@Override
	public int getPhysicalNumberOfRows() {
		return wrappedSheet.getPhysicalNumberOfRows();
	}

	@Override
	public int getFirstRowNum() {
		return wrappedSheet.getFirstRowNum();
	}

	@Override
	public int getLastRowNum() {
		return wrappedSheet.getLastRowNum();
	}

	@Override
	public void addValidationData(DataValidation dataValidation) {
		wrappedSheet.addValidationData(dataValidation);
	}

	// @Deprecated
	// public void setColumnHidden(short columnIndex, boolean hidden) {
	// sheet.setColumnHidden(columnIndex, hidden);
	// }
	//
	// @Deprecated
	// public boolean isColumnHidden(short columnIndex) {
	// return sheet.isColumnHidden(columnIndex);
	// }
	//
	// @Deprecated
	// public void setColumnWidth(short columnIndex, short width) {
	// sheet.setColumnWidth(columnIndex, width);
	// }
	//
	// @Deprecated
	// public short getColumnWidth(short columnIndex) {
	// return sheet.getColumnWidth(columnIndex);
	// }
	//
	// @Deprecated
	// public void setDefaultColumnWidth(short width) {
	// sheet.setDefaultColumnWidth(width);
	// }

	@Override
	public void setColumnHidden(int columnIndex, boolean hidden) {
		wrappedSheet.setColumnHidden(columnIndex, hidden);
	}

	@Override
	public boolean isColumnHidden(int columnIndex) {
		return wrappedSheet.isColumnHidden(columnIndex);
	}

	@Override
	public void setColumnWidth(int columnIndex, int width) {
		wrappedSheet.setColumnWidth(columnIndex, width);
	}

	@Override
	public int getColumnWidth(int columnIndex) {
		return wrappedSheet.getColumnWidth(columnIndex);
	}

	@Override
	public int getDefaultColumnWidth() {
		return wrappedSheet.getDefaultColumnWidth();
	}

	@Override
	public void setDefaultColumnWidth(int width) {
		wrappedSheet.setDefaultColumnWidth(width);
	}

	@Override
	public short getDefaultRowHeight() {
		return wrappedSheet.getDefaultRowHeight();
	}

	@Override
	public float getDefaultRowHeightInPoints() {
		return wrappedSheet.getDefaultRowHeightInPoints();
	}

	@Override
	public void setDefaultRowHeight(short height) {
		wrappedSheet.setDefaultRowHeight(height);
	}

	@Override
	public void setDefaultRowHeightInPoints(float height) {
		wrappedSheet.setDefaultRowHeightInPoints(height);
	}

	@Override
	public CellStyle getColumnStyle(int column) {
		return wrappedSheet.getColumnStyle(column);
	}

	// @Deprecated
	// public int addMergedRegion(Region region) {
	// return sheet.addMergedRegion(region);
	// }

	@Override
	public int addMergedRegion(CellRangeAddress region) {
		return wrappedSheet.addMergedRegion(region);
	}

	@Override
	public void setForceFormulaRecalculation(boolean value) {
		wrappedSheet.setForceFormulaRecalculation(value);
	}

	@Override
	public boolean getForceFormulaRecalculation() {
		return wrappedSheet.getForceFormulaRecalculation();
	}

	@Override
	public void setVerticallyCenter(boolean value) {
		wrappedSheet.setVerticallyCenter(value);
	}

	// @Deprecated
	// public boolean getVerticallyCenter(boolean value) {
	// return sheet.getVerticallyCenter(value);
	// }

	@Override
	public boolean getVerticallyCenter() {
		return wrappedSheet.getVerticallyCenter();
	}

	@Override
	public void setHorizontallyCenter(boolean value) {
		wrappedSheet.setHorizontallyCenter(value);
	}

	@Override
	public boolean getHorizontallyCenter() {
		return wrappedSheet.getHorizontallyCenter();
	}

	@Override
	public void setRightToLeft(boolean value) {
		wrappedSheet.setRightToLeft(value);
	}

	@Override
	public boolean isRightToLeft() {
		return wrappedSheet.isRightToLeft();
	}

	@Override
	public void removeMergedRegion(int index) {
		wrappedSheet.removeMergedRegion(index);
	}

	@Override
	public int getNumMergedRegions() {
		return wrappedSheet.getNumMergedRegions();
	}

	// @Deprecated
	// public org.apache.poi.hssf.util.Region getMergedRegionAt(int index) {
	// return sheet.getMergedRegionAt(index);
	// }

	@Override
	public CellRangeAddress getMergedRegion(int index) {
		return wrappedSheet.getMergedRegion(index);
	}

	@Override
	public Iterator<Row> rowIterator() {
		return wrappedSheet.rowIterator();
	}

	@Override
	public Iterator<Row> iterator() {
		return wrappedSheet.iterator();
	}

	@Override
	public void setAutobreaks(boolean b) {
		wrappedSheet.setAutobreaks(b);
	}

	@Override
	public void setDisplayGuts(boolean b) {
		wrappedSheet.setDisplayGuts(b);
	}

	@Override
	public void setFitToPage(boolean b) {
		wrappedSheet.setFitToPage(b);
	}

	@Override
	public void setRowSumsBelow(boolean b) {
		wrappedSheet.setRowSumsBelow(b);
	}

	@Override
	public void setRowSumsRight(boolean b) {
		wrappedSheet.setRowSumsRight(b);
	}

	@Override
	public boolean getAutobreaks() {
		return wrappedSheet.getAutobreaks();
	}

	@Override
	public boolean getDisplayGuts() {
		return wrappedSheet.getDisplayGuts();
	}

	@Override
	public boolean isDisplayZeros() {
		return wrappedSheet.isDisplayZeros();
	}

	@Override
	public void setDisplayZeros(boolean value) {
		wrappedSheet.setDisplayZeros(value);
	}

	@Override
	public boolean getFitToPage() {
		return wrappedSheet.getFitToPage();
	}

	@Override
	public boolean getRowSumsBelow() {
		return wrappedSheet.getRowSumsBelow();
	}

	@Override
	public boolean getRowSumsRight() {
		return wrappedSheet.getRowSumsRight();
	}

	@Override
	public boolean isPrintGridlines() {
		return wrappedSheet.isPrintGridlines();
	}

	@Override
	public void setPrintGridlines(boolean newPrintGridlines) {
		wrappedSheet.setPrintGridlines(newPrintGridlines);
	}

	@Override
	public PrintSetup getPrintSetup() {
		return wrappedSheet.getPrintSetup();
	}

	@Override
	public Header getHeader() {
		return wrappedSheet.getHeader();
	}

	@Override
	public Footer getFooter() {
		return wrappedSheet.getFooter();
	}

	@Override
	public boolean isSelected() {
		return wrappedSheet.isSelected();
	}

	@Override
	public void setSelected(boolean sel) {
		wrappedSheet.setSelected(sel);
	}

	@Override
	public double getMargin(short margin) {
		return wrappedSheet.getMargin(margin);
	}

	@Override
	public void setMargin(short margin, double size) {
		wrappedSheet.setMargin(margin, size);
	}

	@Override
	public boolean getProtect() {
		return wrappedSheet.getProtect();
	}

	@Override
	public boolean getScenarioProtect() {
		return wrappedSheet.getScenarioProtect();
	}

	@Override
	public void protectSheet(String password) {
		wrappedSheet.protectSheet(password);
	}

	@Override
	public void setZoom(int numerator, int denominator) {
		wrappedSheet.setZoom(numerator, denominator);
	}

	@Override
	public short getTopRow() {
		return wrappedSheet.getTopRow();
	}

	@Override
	public short getLeftCol() {
		return wrappedSheet.getLeftCol();
	}

	@Override
	public void showInPane(short toprow, short leftcol) {
		wrappedSheet.showInPane(toprow, leftcol);
	}

	@Override
	public void shiftRows(int startRow, int endRow, int n) {
		wrappedSheet.shiftRows(startRow, endRow, n);
	}

	@Override
	public void shiftRows(int startRow, int endRow, int n, boolean copyRowHeight,
			boolean resetOriginalRowHeight) {
		wrappedSheet.shiftRows(startRow, endRow, n, copyRowHeight, resetOriginalRowHeight);
	}

	@Override
	public void createFreezePane(int colSplit, int rowSplit, int leftmostColumn, int topRow) {
		wrappedSheet.createFreezePane(colSplit, rowSplit, leftmostColumn, topRow);
	}

	@Override
	public void createFreezePane(int colSplit, int rowSplit) {
		wrappedSheet.createFreezePane(colSplit, rowSplit);
	}

	@Override
	public void createSplitPane(int xSplitPos, int ySplitPos, int leftmostColumn, int topRow,
			int activePane) {
		wrappedSheet.createSplitPane(xSplitPos, ySplitPos, leftmostColumn, topRow, activePane);
	}

	@Override
	public PaneInformation getPaneInformation() {
		return wrappedSheet.getPaneInformation();
	}

	@Override
	public void setDisplayGridlines(boolean show) {
		wrappedSheet.setDisplayGridlines(show);
	}

	@Override
	public boolean isDisplayGridlines() {
		return wrappedSheet.isDisplayGridlines();
	}

	@Override
	public void setDisplayFormulas(boolean show) {
		wrappedSheet.setDisplayFormulas(show);
	}

	@Override
	public boolean isDisplayFormulas() {
		return wrappedSheet.isDisplayFormulas();
	}

	@Override
	public void setDisplayRowColHeadings(boolean show) {
		wrappedSheet.setDisplayRowColHeadings(show);
	}

	@Override
	public boolean isDisplayRowColHeadings() {
		return wrappedSheet.isDisplayRowColHeadings();
	}

	@Override
	public void setRowBreak(int row) {
		wrappedSheet.setRowBreak(row);
	}

	@Override
	public boolean isRowBroken(int row) {
		return wrappedSheet.isRowBroken(row);
	}

	@Override
	public void removeRowBreak(int row) {
		wrappedSheet.removeRowBreak(row);
	}

	@Override
	public int[] getRowBreaks() {
		return wrappedSheet.getRowBreaks();
	}

	@Override
	public int[] getColumnBreaks() {
		return wrappedSheet.getColumnBreaks();
	}

	@Override
	public void setColumnBreak(int column) {
		wrappedSheet.setColumnBreak(column);
	}

	@Override
	public boolean isColumnBroken(int column) {
		return wrappedSheet.isColumnBroken(column);
	}

	@Override
	public void removeColumnBreak(int column) {
		wrappedSheet.removeColumnBreak(column);
	}

	@Override
	public Drawing createDrawingPatriarch() {
		return wrappedSheet.createDrawingPatriarch();
	}

	// @Deprecated
	// public void setColumnGroupCollapsed(short columnNumber, boolean collapsed) {
	// sheet.setColumnGroupCollapsed(columnNumber, collapsed);
	// }
	//
	// @Deprecated
	// public void groupColumn(short fromColumn, short toColumn) {
	// sheet.groupColumn(fromColumn, toColumn);
	// }
	//
	// @Deprecated
	// public void ungroupColumn(short fromColumn, short toColumn) {
	// sheet.ungroupColumn(fromColumn, toColumn);
	// }

	@Override
	public void setColumnGroupCollapsed(int columnNumber, boolean collapsed) {
		wrappedSheet.setColumnGroupCollapsed(columnNumber, collapsed);
	}

	@Override
	public void groupColumn(int fromColumn, int toColumn) {
		wrappedSheet.groupColumn(fromColumn, toColumn);
	}

	@Override
	public void ungroupColumn(int fromColumn, int toColumn) {
		wrappedSheet.ungroupColumn(fromColumn, toColumn);
	}

	@Override
	public void groupRow(int fromRow, int toRow) {
		wrappedSheet.groupRow(fromRow, toRow);
	}

	@Override
	public void ungroupRow(int fromRow, int toRow) {
		wrappedSheet.ungroupRow(fromRow, toRow);
	}

	@Override
	public void setRowGroupCollapsed(int rowIndex, boolean collapse) {
		wrappedSheet.setRowGroupCollapsed(rowIndex, collapse);
	}

	@Override
	public void setDefaultColumnStyle(int column, CellStyle style) {
		wrappedSheet.setDefaultColumnStyle(column, style);
	}

	@Override
	public void autoSizeColumn(int column) {
		wrappedSheet.autoSizeColumn(column);
	}

	@Override
	public void autoSizeColumn(int column, boolean useMergedCells) {
		wrappedSheet.autoSizeColumn(column, useMergedCells);
	}

	@Override
	public Comment getCellComment(int row, int column) {
		return wrappedSheet.getCellComment(row, column);
	}

	@Override
	public SheetConditionalFormatting getSheetConditionalFormatting() {
		return wrappedSheet.getSheetConditionalFormatting();
	}

	@Override
	public String getSheetName() {
		return wrappedSheet.getSheetName();
	}

	@Override
	public CellRange<? extends Cell> setArrayFormula(String formula, CellRangeAddress range) {
		return wrappedSheet.setArrayFormula(formula, range);
	}

	@Override
	public CellRange<? extends Cell> removeArrayFormula(Cell cell) {
		return wrappedSheet.removeArrayFormula(cell);
	}

	@Override
	public DataValidationHelper getDataValidationHelper() {
		return wrappedSheet.getDataValidationHelper();
	}

	@Override
	public AutoFilter setAutoFilter(CellRangeAddress range) {
		return wrappedSheet.setAutoFilter(range);
	}
}
