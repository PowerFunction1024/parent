package com.jadd.controller;

import com.jadd.been.User;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ExcelExportController {

	private static final Logger log = LoggerFactory.getLogger(ExcelExportController.class);

	@PostMapping("/export.do")
	public String export(HttpServletResponse response) {
		try {
			// 设置响应输出的头类型
			response.setHeader("content-Type", "application/vnd.ms-excel");
			// 下载文件的默认名称
			response.setHeader("Content-Disposition", "attachment;filename=user.xls");
			// =========easypoi部分
			ExportParams exportParams = new ExportParams();
			// exportParams.setDataHanlder(null);//和导入一样可以设置一个handler来处理特殊数据
			Workbook workbook = ExcelExportUtil.exportExcel(exportParams, User.class, data());
			workbook.write(response.getOutputStream());
			return "success";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return "error";
		}
	}

	/***
	 * 创建模拟数据
	 * 
	 * @return
	 */
	private List<User> data() {
		List<User> list = new ArrayList<>();

		for (int i = 0; i < 20; i++) {
			list.add(new User("id-" + i, "Leftso-" + i, 15 + i, new Date()));
		}
		return list;
	}
}