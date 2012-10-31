package jp.que.ti.ysu.xls;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

class WrappedRow<ROW extends Row> implements Row {

	protected final ROW wrappedRow;

	public WrappedRow(ROW row) {
		this.wrappedRow = row;

	}

	// @Deprecated
	// public Cell createCell(short columnIndex) {
	// return row.createCell(columnIndex);
	// }
	//
	// @Deprecated
	// public Cell createCell(short columnIndex, int type) {
	// return row.createCell(columnIndex, type);
	// }

	@Override
	public Cell createCell(int column) {
		return wrappedRow.createCell(column);
	}

	@Override
	public Cell createCell(int columnIndex, int type) {
		return wrappedRow.createCell(columnIndex, type);
	}

	@Override
	public void removeCell(Cell cell) {
		wrappedRow.removeCell(cell);
	}

	@Override
	public void setRowNum(int rowIndex) {
		wrappedRow.setRowNum(rowIndex);
	}

	@Override
	public int getRowNum() {
		return wrappedRow.getRowNum();
	}

	@Override
	public Sheet getSheet() {
		return wrappedRow.getSheet();
	}

	// @Deprecated
	// public Cell getCell(short cellnum) {
	// return row.getCell(cellnum);
	// }

	@Override
	public Cell getCell(int cellnum) {
		return wrappedRow.getCell(cellnum);
	}

	@Override
	public Cell getCell(int cellnum, org.apache.poi.ss.usermodel.Row.MissingCellPolicy policy) {
		return wrappedRow.getCell(cellnum, policy);
	}

	@Override
	public short getFirstCellNum() {
		return wrappedRow.getFirstCellNum();
	}

	@Override
	public short getLastCellNum() {
		return wrappedRow.getLastCellNum();
	}

	@Override
	public int getPhysicalNumberOfCells() {
		return wrappedRow.getPhysicalNumberOfCells();
	}

	@Override
	public void setHeight(short height) {
		wrappedRow.setHeight(height);
	}

	@Override
	public void setZeroHeight(boolean zHeight) {
		wrappedRow.setZeroHeight(zHeight);
	}

	@Override
	public boolean getZeroHeight() {
		return wrappedRow.getZeroHeight();
	}

	@Override
	public void setHeightInPoints(float height) {
		wrappedRow.setHeightInPoints(height);
	}

	@Override
	public short getHeight() {
		return wrappedRow.getHeight();
	}

	@Override
	public float getHeightInPoints() {
		return wrappedRow.getHeightInPoints();
	}

	@Override
	public boolean isFormatted() {
		return wrappedRow.isFormatted();
	}

	@Override
	public CellStyle getRowStyle() {
		return wrappedRow.getRowStyle();
	}

	@Override
	public void setRowStyle(CellStyle style) {
		wrappedRow.setRowStyle(style);
	}

	@Override
	public Iterator<Cell> cellIterator() {
		return wrappedRow.cellIterator();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Iterator iterator() {
		return wrappedRow.iterator();
	}

	@Override
	public boolean equals(Object obj) {
		return wrappedRow.equals(obj);
	}

}
