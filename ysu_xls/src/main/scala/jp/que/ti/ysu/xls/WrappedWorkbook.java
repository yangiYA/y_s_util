package jp.que.ti.ysu.xls;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class WrappedWorkbook<WORKBOOK extends Workbook> implements Workbook {
	public WrappedWorkbook(WORKBOOK workbook) {
		this.wrappedWorkbook = workbook;
	}

	protected WORKBOOK wrappedWorkbook;

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getActiveSheetIndex()
	 */
	@Override
	public int getActiveSheetIndex() {
		return wrappedWorkbook.getActiveSheetIndex();
	}

	/**
	 * @param sheetIndex
	 * @see org.apache.poi.ss.usermodel.Workbook#setActiveSheet(int)
	 */
	@Override
	public void setActiveSheet(int sheetIndex) {
		wrappedWorkbook.setActiveSheet(sheetIndex);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getFirstVisibleTab()
	 */
	@Override
	public int getFirstVisibleTab() {
		return wrappedWorkbook.getFirstVisibleTab();
	}

	/**
	 * @param sheetIndex
	 * @see org.apache.poi.ss.usermodel.Workbook#setFirstVisibleTab(int)
	 */
	@Override
	public void setFirstVisibleTab(int sheetIndex) {
		wrappedWorkbook.setFirstVisibleTab(sheetIndex);
	}

	/**
	 * @param sheetname
	 * @param pos
	 * @see org.apache.poi.ss.usermodel.Workbook#setSheetOrder(java.lang.String, int)
	 */
	@Override
	public void setSheetOrder(String sheetname, int pos) {
		wrappedWorkbook.setSheetOrder(sheetname, pos);
	}

	/**
	 * @param index
	 * @see org.apache.poi.ss.usermodel.Workbook#setSelectedTab(int)
	 */
	@Override
	public void setSelectedTab(int index) {
		wrappedWorkbook.setSelectedTab(index);
	}

	/**
	 * @param sheet
	 * @param name
	 * @see org.apache.poi.ss.usermodel.Workbook#setSheetName(int, java.lang.String)
	 */
	@Override
	public void setSheetName(int sheet, String name) {
		wrappedWorkbook.setSheetName(sheet, name);
	}

	/**
	 * @param sheet
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getSheetName(int)
	 */
	@Override
	public String getSheetName(int sheet) {
		return wrappedWorkbook.getSheetName(sheet);
	}

	/**
	 * @param name
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getSheetIndex(java.lang.String)
	 */
	@Override
	public int getSheetIndex(String name) {
		return wrappedWorkbook.getSheetIndex(name);
	}

	/**
	 * @param sheet
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getSheetIndex(org.apache.poi.ss.usermodel.Sheet)
	 */
	@Override
	public int getSheetIndex(Sheet sheet) {
		return wrappedWorkbook.getSheetIndex(sheet);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#createSheet()
	 */
	@Override
	public Sheet createSheet() {
		return wrappedWorkbook.createSheet();
	}

	/**
	 * @param sheetname
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#createSheet(java.lang.String)
	 */
	@Override
	public Sheet createSheet(String sheetname) {
		return wrappedWorkbook.createSheet(sheetname);
	}

	/**
	 * @param sheetNum
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#cloneSheet(int)
	 */
	@Override
	public Sheet cloneSheet(int sheetNum) {
		return wrappedWorkbook.cloneSheet(sheetNum);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getNumberOfSheets()
	 */
	@Override
	public int getNumberOfSheets() {
		return wrappedWorkbook.getNumberOfSheets();
	}

	/**
	 * @param index
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getSheetAt(int)
	 */
	@Override
	public Sheet getSheetAt(int index) {
		return wrappedWorkbook.getSheetAt(index);
	}

	/**
	 * @param name
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getSheet(java.lang.String)
	 */
	@Override
	public Sheet getSheet(String name) {
		return wrappedWorkbook.getSheet(name);
	}

	/**
	 * @param index
	 * @see org.apache.poi.ss.usermodel.Workbook#removeSheetAt(int)
	 */
	@Override
	public void removeSheetAt(int index) {
		wrappedWorkbook.removeSheetAt(index);
	}

	/**
	 * @param sheetIndex
	 * @param startColumn
	 * @param endColumn
	 * @param startRow
	 * @param endRow
	 * @see org.apache.poi.ss.usermodel.Workbook#setRepeatingRowsAndColumns(int, int, int, int, int)
	 */
	@Override
	public void setRepeatingRowsAndColumns(int sheetIndex, int startColumn, int endColumn,
			int startRow, int endRow) {
		wrappedWorkbook.setRepeatingRowsAndColumns(sheetIndex, startColumn, endColumn, startRow,
				endRow);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#createFont()
	 */
	@Override
	public Font createFont() {
		return wrappedWorkbook.createFont();
	}

	/**
	 * @param boldWeight
	 * @param color
	 * @param fontHeight
	 * @param name
	 * @param italic
	 * @param strikeout
	 * @param typeOffset
	 * @param underline
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#findFont(short, short, short, java.lang.String, boolean, boolean,
	 *      short, byte)
	 */
	@Override
	public Font findFont(short boldWeight, short color, short fontHeight, String name,
			boolean italic, boolean strikeout, short typeOffset, byte underline) {
		return wrappedWorkbook.findFont(boldWeight, color, fontHeight, name, italic, strikeout,
				typeOffset, underline);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getNumberOfFonts()
	 */
	@Override
	public short getNumberOfFonts() {
		return wrappedWorkbook.getNumberOfFonts();
	}

	/**
	 * @param idx
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getFontAt(short)
	 */
	@Override
	public Font getFontAt(short idx) {
		return wrappedWorkbook.getFontAt(idx);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#createCellStyle()
	 */
	@Override
	public CellStyle createCellStyle() {
		return wrappedWorkbook.createCellStyle();
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getNumCellStyles()
	 */
	@Override
	public short getNumCellStyles() {
		return wrappedWorkbook.getNumCellStyles();
	}

	/**
	 * @param idx
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getCellStyleAt(short)
	 */
	@Override
	public CellStyle getCellStyleAt(short idx) {
		return wrappedWorkbook.getCellStyleAt(idx);
	}

	/**
	 * @param stream
	 * @throws IOException
	 * @see org.apache.poi.ss.usermodel.Workbook#write(java.io.OutputStream)
	 */
	@Override
	public void write(OutputStream stream) throws IOException {
		wrappedWorkbook.write(stream);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getNumberOfNames()
	 */
	@Override
	public int getNumberOfNames() {
		return wrappedWorkbook.getNumberOfNames();
	}

	/**
	 * @param name
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getName(java.lang.String)
	 */
	@Override
	public Name getName(String name) {
		return wrappedWorkbook.getName(name);
	}

	/**
	 * @param nameIndex
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getNameAt(int)
	 */
	@Override
	public Name getNameAt(int nameIndex) {
		return wrappedWorkbook.getNameAt(nameIndex);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#createName()
	 */
	@Override
	public Name createName() {
		return wrappedWorkbook.createName();
	}

	/**
	 * @param name
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getNameIndex(java.lang.String)
	 */
	@Override
	public int getNameIndex(String name) {
		return wrappedWorkbook.getNameIndex(name);
	}

	/**
	 * @param index
	 * @see org.apache.poi.ss.usermodel.Workbook#removeName(int)
	 */
	@Override
	public void removeName(int index) {
		wrappedWorkbook.removeName(index);
	}

	/**
	 * @param name
	 * @see org.apache.poi.ss.usermodel.Workbook#removeName(java.lang.String)
	 */
	@Override
	public void removeName(String name) {
		wrappedWorkbook.removeName(name);
	}

	/**
	 * @param sheetIndex
	 * @param reference
	 * @see org.apache.poi.ss.usermodel.Workbook#setPrintArea(int, java.lang.String)
	 */
	@Override
	public void setPrintArea(int sheetIndex, String reference) {
		wrappedWorkbook.setPrintArea(sheetIndex, reference);
	}

	/**
	 * @param sheetIndex
	 * @param startColumn
	 * @param endColumn
	 * @param startRow
	 * @param endRow
	 * @see org.apache.poi.ss.usermodel.Workbook#setPrintArea(int, int, int, int, int)
	 */
	@Override
	public void setPrintArea(int sheetIndex, int startColumn, int endColumn, int startRow,
			int endRow) {
		wrappedWorkbook.setPrintArea(sheetIndex, startColumn, endColumn, startRow, endRow);
	}

	/**
	 * @param sheetIndex
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getPrintArea(int)
	 */
	@Override
	public String getPrintArea(int sheetIndex) {
		return wrappedWorkbook.getPrintArea(sheetIndex);
	}

	/**
	 * @param sheetIndex
	 * @see org.apache.poi.ss.usermodel.Workbook#removePrintArea(int)
	 */
	@Override
	public void removePrintArea(int sheetIndex) {
		wrappedWorkbook.removePrintArea(sheetIndex);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getMissingCellPolicy()
	 */
	@Override
	public MissingCellPolicy getMissingCellPolicy() {
		return wrappedWorkbook.getMissingCellPolicy();
	}

	/**
	 * @param missingCellPolicy
	 * @see org.apache.poi.ss.usermodel.Workbook#setMissingCellPolicy(org.apache.poi.ss.usermodel.Row.MissingCellPolicy)
	 */
	@Override
	public void setMissingCellPolicy(MissingCellPolicy missingCellPolicy) {
		wrappedWorkbook.setMissingCellPolicy(missingCellPolicy);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#createDataFormat()
	 */
	@Override
	public DataFormat createDataFormat() {
		return wrappedWorkbook.createDataFormat();
	}

	/**
	 * @param pictureData
	 * @param format
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#addPicture(byte[], int)
	 */
	@Override
	public int addPicture(byte[] pictureData, int format) {
		return wrappedWorkbook.addPicture(pictureData, format);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getAllPictures()
	 */
	@Override
	public List<? extends PictureData> getAllPictures() {
		return wrappedWorkbook.getAllPictures();
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getCreationHelper()
	 */
	@Override
	public CreationHelper getCreationHelper() {
		return wrappedWorkbook.getCreationHelper();
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#isHidden()
	 */
	@Override
	public boolean isHidden() {
		return wrappedWorkbook.isHidden();
	}

	/**
	 * @param hiddenFlag
	 * @see org.apache.poi.ss.usermodel.Workbook#setHidden(boolean)
	 */
	@Override
	public void setHidden(boolean hiddenFlag) {
		wrappedWorkbook.setHidden(hiddenFlag);
	}

	/**
	 * @param sheetIx
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#isSheetHidden(int)
	 */
	@Override
	public boolean isSheetHidden(int sheetIx) {
		return wrappedWorkbook.isSheetHidden(sheetIx);
	}

	/**
	 * @param sheetIx
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#isSheetVeryHidden(int)
	 */
	@Override
	public boolean isSheetVeryHidden(int sheetIx) {
		return wrappedWorkbook.isSheetVeryHidden(sheetIx);
	}

	/**
	 * @param sheetIx
	 * @param hidden
	 * @see org.apache.poi.ss.usermodel.Workbook#setSheetHidden(int, boolean)
	 */
	@Override
	public void setSheetHidden(int sheetIx, boolean hidden) {
		wrappedWorkbook.setSheetHidden(sheetIx, hidden);
	}

	/**
	 * @param sheetIx
	 * @param hidden
	 * @see org.apache.poi.ss.usermodel.Workbook#setSheetHidden(int, int)
	 */
	@Override
	public void setSheetHidden(int sheetIx, int hidden) {
		wrappedWorkbook.setSheetHidden(sheetIx, hidden);
	}

	/**
	 * @param toopack
	 * @see org.apache.poi.ss.usermodel.Workbook#addToolPack(org.apache.poi.ss.formula.udf.UDFFinder)
	 */
	@Override
	public void addToolPack(UDFFinder toopack) {
		wrappedWorkbook.addToolPack(toopack);
	}

	/**
	 * @param value
	 * @see org.apache.poi.ss.usermodel.Workbook#setForceFormulaRecalculation(boolean)
	 */
	@Override
	public void setForceFormulaRecalculation(boolean value) {
		wrappedWorkbook.setForceFormulaRecalculation(value);
	}

	/**
	 * @return
	 * @see org.apache.poi.ss.usermodel.Workbook#getForceFormulaRecalculation()
	 */
	@Override
	public boolean getForceFormulaRecalculation() {
		return wrappedWorkbook.getForceFormulaRecalculation();
	}
}
