package com.voya.data;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

public class ExcelDataObject extends BaseExcelDataObject{
	
	@ExcelRow
	public int index;
	
	@ExcelCellName ("Username")
	public String Username;
	
	@ExcelCellName ("Password")
	public String Password;
	

}
